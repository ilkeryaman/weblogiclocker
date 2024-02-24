package com.yaman.weblogiclocker.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    private static final Properties properties = new Properties();

    public static String getPropertyValue(String propertyName) {
        return getPropertyValue(propertyName, null);
    }

    public static String getPropertyValue(String propertyName, String defaultValue){
        String propertyValue;
        if(properties.isEmpty() || StringUtils.isEmpty(properties.getProperty(propertyName))){
            propertyValue = System.getProperty(propertyName);
            if(StringUtils.isEmpty(propertyValue)){
                propertyValue = System.getenv(propertyName);
                if(StringUtils.isEmpty(propertyValue) && !StringUtils.isEmpty(defaultValue)){
                    propertyValue = defaultValue;
                }
            }
        } else {
            propertyValue = properties.getProperty(propertyName);
        }
        return propertyValue;
    }

    public static void loadProperties() {
        FileInputStream file;
        String path = "./application.properties";

        try {
            file = new FileInputStream(path);
            properties.load(file);
            file.close();
        } catch (IOException e) {}
    }
}
