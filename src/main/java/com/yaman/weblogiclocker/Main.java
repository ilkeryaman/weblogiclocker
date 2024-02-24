package com.yaman.weblogiclocker;

import com.yaman.weblogiclocker.service.WeblogicLockerService;

public class Main {
    /*
    ======================================================================
    NOTES:
    -------
    *   To find appropriate chromedriver.exe version, use below json file:
    https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with-downloads.json
     */
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            WeblogicLockerService.tryLock();
            exitAfterAWhile();
        });
        thread.start();
    }

    private static void exitAfterAWhile(){
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {}
        System.exit(0);
    }
}