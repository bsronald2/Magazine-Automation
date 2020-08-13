package com.trivago.magazine.ui.pages;

import com.trivago.magazine.ui.actions.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DestinationPage extends BasePage {

    private String namePage;
    private WebElement headingTitle;
    private String destinationUrlFolder;

    /**
     * Destination page constructor
     * @param destination
     */
    public DestinationPage(String destination) {
        this.namePage = destination;
        setHeadingTitle(destination);
        this.destinationUrlFolder = String.format("/destination/%s/", destination.toLowerCase());
    }

    /**
     * Set Heading title web element.
     *
     * @param destination destination name
     */
    private void setHeadingTitle(String destination) {
        String headingTitleXpath = String.format("//div[contains(@class, 'hero-title')]/h1[contains(., '%s')]",
                destination);
        By byXpath = By.xpath(headingTitleXpath);
        headingTitle = driver.findElement(byXpath);
    }

    /**
     * This method return heading page title.
     *
     * @return Page title as String
     */
    public String getHeadingTitle() {
        return Common.getText(this.headingTitle);
    }

    public boolean isTheCorrectDestination() {
        String currentUrl = driver.getCurrentUrl();

        return currentUrl.contains(this.destinationUrlFolder);
    }
}
