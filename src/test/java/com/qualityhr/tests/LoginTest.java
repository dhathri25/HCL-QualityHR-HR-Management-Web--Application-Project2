package com.qualityhr.tests;

import com.qualityhr.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testValidLoginDhathri() {
        System.out.println(">>> STARTING LOGIN TEST - DHATHRI PUTTY <<<");
        
        LoginPage loginPage = new LoginPage(driver);
        
        String user = config.getUsername();
        String pass = config.getPassword();
        
        loginPage.login(user, pass);

        String currentUrl = driver.getCurrentUrl();
        boolean isDashboard = currentUrl.contains("dashboard");
        
        System.out.println("Login Redirection URL: " + currentUrl);
        Assert.assertTrue(isDashboard, "Login failed! Dashboard was not reached.");
        
        System.out.println(">>> LOGIN TEST PASSED - 5/5 <<<");
    }
}