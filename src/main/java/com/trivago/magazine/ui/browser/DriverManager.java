package com.trivago.magazine.ui.browser;

import com.trivago.magazine.entities.EnvironmentInfo;
import com.trivago.magazine.utils.Constants;
import com.trivago.magazine.utils.EnvironmentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {


    private static final EnvironmentInfo ENVIRONMENT = (EnvironmentInfo) (new EnvironmentManager(Constants.ENV_INFO_PATH,
            EnvironmentInfo.class).getEnvInfo());
    public static final int WAIT_TIME_OUT = 30;

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * This method is in charge to initialize the DriverManager.
     */
    private DriverManager() {
        final String baseUrl = ENVIRONMENT.getUrl();
        final int timeout = ENVIRONMENT.getUi().getTimeout();
        final String browser = ENVIRONMENT.getUi().getBrowser().toUpperCase();
        System.out.println(baseUrl);
        // Load driver and set up
        driver = DriverFactory.getDriver(browser).initDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        driver.get(baseUrl);
    }

    /**
     * This method Instance the instance if this does not exist.
     *
     * @return a instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Get the webDriver specification.
     *
     * @return webDriver Specification.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * This method obtains WebDriverWait.
     *
     * @return WebDriverWait.
     */
    public WebDriverWait getWait() {
        return wait;
    }

}
