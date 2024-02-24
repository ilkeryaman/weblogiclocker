package com.yaman.weblogiclocker.enums;

public enum DefaultValue {
    WEBLOGIC_URL("http://someurl.com/console");

    private String val;

    DefaultValue(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
