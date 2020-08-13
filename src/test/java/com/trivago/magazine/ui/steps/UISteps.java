package com.trivago.magazine.ui.steps;

import com.trivago.magazine.entities.ContactForm;
import com.trivago.magazine.ui.actions.Validations;
import com.trivago.magazine.ui.pages.ContactPage;
import com.trivago.magazine.ui.pages.DestinationPage;
import com.trivago.magazine.ui.pages.MagazineHomePage;
import com.trivago.magazine.ui.pages.PageNavigator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Map;

public class UISteps {

    MagazineHomePage magazineHomePage;
    DestinationPage destinationPage;
    ContactPage contactPage;
    String destination;

    public UISteps() {
        this.magazineHomePage = new MagazineHomePage();
    }

    @When("I navigate to destination {string} through menu")
    public void iNavigateToDestinationThroughMenu(String destination) {
        this.destination = destination;
        this.destinationPage = this.magazineHomePage.navigateToDestination(destination);
    }

    @Then("I verify that the correct destination page is displayed")
    public void iVerifyThatTheCorrectDestinationPageIsDisplayed() {
        String actualTitle = this.destinationPage.getHeadingTitle().toLowerCase();
        boolean isCorrectPage = this.destinationPage.isTheCorrectDestination();
        Assert.assertEquals("Destination Title are not equals:", destination.toLowerCase(), actualTitle);
        Assert.assertTrue("This is not the correct destination", isCorrectPage);
    }

    @When("I navigate to {string} page using footer link")
    public void iNavigateToPageUsingFooterLink(String page) throws InterruptedException, ClassNotFoundException {
        this.magazineHomePage.navigatePageUsingFooter(page);
    }

    @When("I fill out the contact form")
    public void iFillOutTheContactForm(DataTable table) {
        Map<String, ContactForm> contactForms = table.asMap(String.class, ContactForm.class);
        this.contactPage = new ContactPage();
        for(Map.Entry<String, ContactForm> entry : contactForms.entrySet()) {
            ContactForm contactForm = entry.getValue();
            this.contactPage.fillOutForm(contactForm);
        }
    }

    @And("I submit the form")
    public void iSendTheFormSuccessfully() {
        this.contactPage.submitForm();
    }

    @Then("The following message should be displayed {string}")
    public void theFollowingMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = this.contactPage.getConfirmationMessage();
        Assert.assertEquals("Messages are not equal:", expectedMessage, actualMessage);
    }

    @Given("I am in homepage")
    public void iAmInHomepage() {
        if (!PageNavigator.getInstance().isHomePage()) {
            magazineHomePage = PageNavigator.getInstance().magazineHomePage();
        }
    }

    @Then("I verify that all links are working")
    public void iVerifyThatAllLinksAreWorking() {
        HashSet<String> links = this.magazineHomePage.getAllPageLinks();
        boolean areValidLinks = Validations.areLinksWorking(links);
        Assert.assertTrue("One or more links are not working.", areValidLinks);
    }
}
