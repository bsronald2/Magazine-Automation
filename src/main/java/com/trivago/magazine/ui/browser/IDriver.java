package com.trivago.magazine.ui.browser;

import org.openqa.selenium.WebDriver;

public interface IDriver {

    public WebDriver initDriver();
    public String webDriverPathByOS();
}
