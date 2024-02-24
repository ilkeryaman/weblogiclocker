package com.yaman.weblogiclocker.enums;

public enum WebElementName {
    SAVE("save");

    private String val;

    WebElementName(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
