package com.yaman.weblogiclocker.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class NotificationService {
    public static void showWeblogicSuccessNotification() throws AWTException {
        showNotification("SUCCESS", "Weblogic is locked successfully!", "Weblogic is locked successfully!", TrayIcon.MessageType.INFO);
    }

    public static void showWeblogicErrorNotification() throws AWTException {
        showNotification("ERROR", "Unfortunately, auto-locker is failed!", "Unfortunately, auto-locker is failed!", TrayIcon.MessageType.ERROR);
    }

    private static void showNotification(String caption, String tooltip, String message, TrayIcon.MessageType messageType) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        Image image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(NotificationService.class.getResource("/icon.png")));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        TrayIcon trayIcon = new TrayIcon(image, tooltip);
        trayIcon.setImageAutoSize(true);
        tray.add(trayIcon);

    }
}
