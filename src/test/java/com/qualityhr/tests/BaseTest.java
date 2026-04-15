package com.qualityhr.tests;

import com.qualityhr.utils.ConfigReader;
import com.qualityhr.driver.DriverFactory; // Fixed to match your folder structure
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
        driver = DriverFactory.initDriver(config.getBrowser());
        driver.get(config.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}