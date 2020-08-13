package com.trivago.magazine.ui.pages;

import com.trivago.magazine.ui.actions.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MagazineFooter extends BasePage {


    /**
     * Click on Link.
     *
     * @param page name
     */
    public void clickOnLink(String page) {
        String link = String.format("//a[contains(@class, 'footer-link') and contains(., '%s')]", page);
        By byXpath = By.xpath(link);
        WebElement element = driver.findElement(byXpath);
        Common.clickElement(element);

        // Switch tab
        final int newTab = 1;
        Common.switchTab(newTab);
    }

    /**
     * Return new object instance of the page clicked on.
     *
     * @param page name
     * @return new instance object
     */
    public BasePage getPage(String page) {

        if ("CONTACT".equals(page.toUpperCase())) {
            return new ContactPage();
        } // add another pages ....
        throw new IllegalArgumentException("Page " + page + " is not supported.");
    }
}
