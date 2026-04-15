package com.qualityhr.tests;

import com.qualityhr.pages.LoginPage;
import com.qualityhr.pages.AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test
    public void testAdminUserRoleCreation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        AdminPage adminPage = new AdminPage(driver);
        adminPage.navigateToAdmin();        
        String testUser = "User_" + System.currentTimeMillis();
        adminPage.createSystemUser("Orange", testUser, "Pass@1234");
        
        Assert.assertTrue(adminPage.isUserCreated(), "Admin user creation failed!");
    }
}