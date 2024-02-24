package com.yaman.weblogiclocker.config;

import com.yaman.weblogiclocker.enums.PropertyName;
import com.yaman.weblogiclocker.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {
    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", PropertyUtils.getPropertyValue(PropertyName.CHROME_WEB_DRIVER_PATH.getVal()));
        return new ChromeDriver(ChromeOptionsConfig.getHeadlessConfig());
    }
}
