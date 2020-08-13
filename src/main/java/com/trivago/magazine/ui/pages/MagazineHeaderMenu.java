package com.trivago.magazine.ui.pages;

import com.trivago.magazine.ui.actions.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MagazineHeaderMenu extends BasePage implements IBasePage {

    @FindBy(css = "div#menu[style='']")
    private WebElement headerMenu;

    @FindBy(css = "")
    private WebElement destinationTitle;

    /**
     * Constructor wait until element is loaded
     */
    public MagazineHeaderMenu() {
        waitPageIsLoad();
    }

    @Override
    public void waitPageIsLoad() {

    }

    /**
     * Click on destination.
     */
    public DestinationContainer clickOnDestinationTitle() {
        clickOnTitle("Destinations");

        return new DestinationContainer();
    }

    /**
     * Click on Title.
     *
     * @param title name
     */
    public void clickOnTitle(String title) {
        // Load Web element
        String xpathString = String.format("//div[@class='menu-title' and contains(., '%s')]", title);
        By byXpath = By.xpath(xpathString);
        WebElement element = driver.findElement(byXpath);

        // Click on Element
        Common.clickElement(element);

    }
}
