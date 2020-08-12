package com.trivago.magazine.ui.browser;

import com.trivago.magazine.utils.EnvironmentChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {


    private final Logger log = LogManager.getLogger(Chrome.class);

    enum WEB_DRIVER {
        PATH_WINDOWS("drivers/chromedriver.exe"),
        PATH_LINUX("drivers/chromedriver"),
        KEY("webdriver.chrome.driver");

        String value;
        WEB_DRIVER(String value) {
            this.value = value;
        }
    }

    @Override
    public WebDriver initDriver() {
        final String webDriverPath = webDriverPathByOS();
        System.setProperty(WEB_DRIVER.KEY.value, webDriverPath);
        return new ChromeDriver();
    }

    @Override
    public String webDriverPathByOS() {
        final String osName = EnvironmentChecker.getInstance().getOsName();
        if (osName.equals("Windows")) {
            return WEB_DRIVER.PATH_WINDOWS.value;
        } else if (osName.equals("Linux")) {
            return WEB_DRIVER.PATH_LINUX.value;
        } else {
            log.info("Web driver path was not found for " + osName);
            throw new RuntimeException("Environment not supported");
        }

    }
}
