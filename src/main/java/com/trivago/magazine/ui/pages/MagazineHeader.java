package com.trivago.magazine.ui.pages;

import com.trivago.magazine.ui.actions.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MagazineHeader extends BasePage {

    @FindBy(css = "div[class='search-icon']")
    private WebElement searchIcon;

    @FindBy(css = "div[class='nav-icon']")
    private WebElement navIcon;

    /**
     * Click on menu Icon.
     * @return new Magazine Header Menu
     */
    public MagazineHeaderMenu clickOnMenuIcon() {
        Common.clickElement(navIcon);

        return new MagazineHeaderMenu();
    }
}
