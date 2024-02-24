package com.yaman.weblogiclocker.enums;

public enum WebElementId {
    USERNAME_TEXTBOX("j_username"),
    PASSWORD_TEXTBOX("j_password");

    private String val;

    WebElementId(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
