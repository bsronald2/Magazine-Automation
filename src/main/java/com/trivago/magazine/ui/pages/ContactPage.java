package com.trivago.magazine.ui.pages;

import com.trivago.magazine.entities.ContactForm;
import com.trivago.magazine.ui.actions.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    @FindBy(css = "textarea.contact-msg")
    private WebElement textArea;

    @FindBy(css = "button.contact-submit")
    private WebElement submitBtn;

    @FindBy(css = "p.feedback")
    private WebElement confirmMessage;

    @FindBy(css = "input.contact-input")
    private WebElement fullNameArea;

    @FindBy(id = "contact-email")
    private WebElement emailArea;

    @FindBy(id = "confirm")
    private  WebElement confirmCheckBox;

    MagazineHeader header;

    public ContactPage() {
        header = new MagazineHeader();
    }

    /**
     *  Fill out message field.
     *
     * @param message to send
     */
    public void fillOutMessageField(String message) {
        Common.sendKeys(textArea, message);
    }

    /**
     * Fill out full name text field.
     *
     * @param fullname user full name
     */
    public void fillOutFullNameField(String fullname) {
        Common.sendKeys(fullNameArea, fullname);
    }

    /**
     * Fill out email text field.
     *
     * @param email address
     */
    public void fillOutEmailField(String email) {
        Common.sendKeys(emailArea, email);
    }

    /**
     *  Fill out all contact form.
     *
     * @param contactForm object
     */
    public void fillOutForm(ContactForm contactForm) {
        fillOutMessageField(contactForm.getMessage());
        fillOutFullNameField(contactForm.getFullname());
        fillOutEmailField(contactForm.getEmail());
    }

    /**
     * Click on Submit Button.
     */
    public void submitForm() {
        Common.clickElement(confirmCheckBox);
        Common.clickElement(submitBtn);
    }

    /**
     * This method return message after submit contact form.
     *
     * @return String message
     */
    public String getConfirmationMessage() {
        return Common.getText(confirmMessage);
    }
}
