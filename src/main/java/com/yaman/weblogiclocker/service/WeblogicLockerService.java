package com.yaman.weblogiclocker.service;

import com.yaman.weblogiclocker.config.WebDriverConfig;
import com.yaman.weblogiclocker.enums.*;
import com.yaman.weblogiclocker.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class WeblogicLockerService {
    public static void tryLock(){
        boolean isLocked = false;
        WebDriver driver = null;
        try {
            PropertyUtils.loadProperties();
            driver = WebDriverConfig.getWebDriver();
            driver.get(PropertyUtils.getPropertyValue(PropertyName.WEBLOGIC_URL.getVal(), DefaultValue.WEBLOGIC_URL.getVal()));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(WebElementId.USERNAME_TEXTBOX.getVal())));
            username.sendKeys(PropertyUtils.getPropertyValue(PropertyName.USERNAME.getVal()));
            WebElement password = driver.findElement(By.id(WebElementId.PASSWORD_TEXTBOX.getVal()));
            password.sendKeys(PropertyUtils.getPropertyValue(PropertyName.PASSWORD.getVal()));
            WebElement loginButton = driver.findElement(By.className(WebElementClassName.LOGIN_BUTTON.getVal()));
            loginButton.click();

            for(int i=0; i<100; i++){
                WebElement changeCenterStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(WebElementClassName.CHANGE_CENTER_LABEL.getVal())));
                if(changeCenterStatus.getText().equals("Click the Lock & Edit button to modify, add or delete items in this domain.")){
                    WebElement lockButton = wait.until(ExpectedConditions.elementToBeClickable(By.name(WebElementName.SAVE.getVal())));
                    lockButton.click();
                    isLocked = true;
                    break;
                } else {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    driver.navigate().refresh();
                }
            }
        } catch (Exception e){}
        finally {
            if(driver != null){
                driver.close();
                driver.quit();
            }
        }

        if(isLocked) {
            showSuccessMessage();
        } else {
            showErrorMessage();
        }
    }

    private static void showSuccessMessage(){
        try {
            NotificationService.showWeblogicSuccessNotification();
        } catch (AWTException e){
            throw new RuntimeException(e);
        }
    }

    private static void showErrorMessage(){
        try {
            NotificationService.showWeblogicErrorNotification();
        } catch (AWTException e){
            throw new RuntimeException(e);
        }
    }
}
