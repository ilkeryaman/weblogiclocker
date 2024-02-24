package com.yaman.weblogiclocker.enums;

public enum PropertyName {
    CHROME_WEB_DRIVER_PATH("wll.chrome.web.driver.path"),
    WEBLOGIC_URL("wll.url"),
    USERNAME("wll.username"),
    PASSWORD("wll.password");

    private String val;

    PropertyName(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
