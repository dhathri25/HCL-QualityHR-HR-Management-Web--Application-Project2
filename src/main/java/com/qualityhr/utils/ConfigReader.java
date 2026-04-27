package com.qualityhr.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        // This method looks directly into the 'resources' folder of your project
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("CRITICAL: config.properties not found in the classpath!");
                return;
            }
            properties.load(input);
        } catch (Exception e) {
            System.err.println("CRITICAL: Error loading config.properties");
            e.printStackTrace();
        }
        
    }

    public String getBrowser() { return properties.getProperty("browser"); }
    public String getUrl() { return properties.getProperty("url"); }
    public String getUsername() { return properties.getProperty("username"); }
    public String getPassword() { return properties.getProperty("password"); }
    public int getTimeout() { return Integer.parseInt(properties.getProperty("timeout")); }
}