package com.yaman.weblogiclocker.config;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsConfig {
    public static ChromeOptions getHeadlessConfig(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        return options;
    }
}
