package com.yaman.weblogiclocker.enums;

public enum WebElementClassName {
    LOGIN_BUTTON("formButton"),
    CHANGE_CENTER_LABEL("changeliststatus");

    private String val;

    WebElementClassName(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
