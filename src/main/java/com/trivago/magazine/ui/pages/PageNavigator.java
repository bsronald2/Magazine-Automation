package com.trivago.magazine.ui.pages;

import com.trivago.magazine.entities.EnvironmentInfo;
import com.trivago.magazine.utils.Constants;
import com.trivago.magazine.utils.EnvironmentManager;

public class PageNavigator extends BasePage {

    private static PageNavigator instance = null;
    public EnvironmentInfo environmentInfo;

    private PageNavigator() {
        environmentInfo = (EnvironmentInfo) (new EnvironmentManager(Constants.ENV_INFO_PATH,
                EnvironmentInfo.class).getEnvInfo());
    }

    public static PageNavigator getInstance() {
        if (instance == null) {
            return new PageNavigator();
        }

        return instance;
    }

    /**
     * Navigate to Magazine Home Page.
     *
     * @return new MagazineHomePage instance
     */
    public MagazineHomePage magazineHomePage() {
        driver.get(environmentInfo.url);
        return new MagazineHomePage();
    }

    /**
     * True if we are in homepage, otherwise false.
     *
     * @return Boolean value
     */
    public boolean isHomePage() {
        String currentUrl = driver.getCurrentUrl();

        return currentUrl.equals(environmentInfo.url);
    }
}
