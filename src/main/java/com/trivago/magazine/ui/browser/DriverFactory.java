package com.trivago.magazine.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class DriverFactory {

    public static final String BROWSER_NOT_FOUND = "Browser was not found";

    private DriverFactory() {
        // Private Constructor
    }


    public static IDriver getDriver(final String browser) {
        if (browser.equals("CHROME")) {
            return new Chrome();
        } else if (browser.equals("FIREFOX")) {
            // TODO pending to implement other browser
        }

        throw new WebDriverException(BROWSER_NOT_FOUND);
    }
}
