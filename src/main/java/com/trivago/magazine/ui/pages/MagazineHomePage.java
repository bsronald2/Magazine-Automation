package com.trivago.magazine.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashSet;
import java.util.List;




public class MagazineHomePage extends BasePage implements IBasePage {

    @FindBy(css = "a[class='logo']")
    private WebElement mainLogoLink;


    private MagazineFooter footer;
    private MagazineHeader header;
    private String parentWindowHandle;


    public MagazineHomePage() {
        waitPageIsLoad();
        this.header = new MagazineHeader();
        this.footer = new MagazineFooter();
        this.parentWindowHandle = driver.getWindowHandle();
    }

    @Override
    public void waitPageIsLoad() {
        wait.until(ExpectedConditions.visibilityOf(mainLogoLink));
    }

    /**
     * This method navigate to destination page.
     *
     * @param destination name of the destination page
     * @return new Destination page
     */
    public DestinationPage navigateToDestination(String destination) {
        MagazineHeaderMenu headerMenu = header.clickOnMenuIcon();
        DestinationContainer destinationContainer = headerMenu.clickOnDestinationTitle();

        return destinationContainer.clickOnDestination(destination);
    }

    /**
     * Navigate Footer pages.
     *
     * @param page name
     * @throws InterruptedException
     */
    public void navigatePageUsingFooter(String page) throws InterruptedException {
        footer.clickOnLink(page);
    }



    /**
     *  Collect all links on MagazineHomePage.
     *
     * @return HashSet of Strings
     */
    public HashSet<String> getAllPageLinks() {
        List<WebElement> linksElements = driver.findElements(By.tagName("a"));
        HashSet<String> urls = new HashSet<>();
        for (WebElement linkElement : linksElements) {
            String url = linkElement.getAttribute("href");
            if (url == null || url.isEmpty() || url.contains("javascript")) {
                continue;
            }
            urls.add(url);
        }

        return urls;
    }
}




