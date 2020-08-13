package com.trivago.magazine.ui.pages;

import com.trivago.magazine.ui.actions.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DestinationContainer extends BasePage implements IBasePage {


    @FindBy(css = "div.menu-expand[data-menu-title='Destinations']")
    private WebElement menuExpand;

    public DestinationContainer() {
        waitPageIsLoad();
    }
    @Override
    public void waitPageIsLoad() {
        wait.until(ExpectedConditions.visibilityOf(menuExpand));
    }

    /**
     *  Click on destination.
     *
     * @param destination name
     * @return new DestinationPage
     */
    public DestinationPage clickOnDestination(String destination) {
        String xpathString = String.format("//div[@class='destination-menu' and contains(., '%s')]", destination);
        By byXpath = By.xpath(xpathString);
        WebElement destinationWebElement = driver.findElement(byXpath);
        Common.clickElement(destinationWebElement);

        return new DestinationPage(destination);
    }
}
