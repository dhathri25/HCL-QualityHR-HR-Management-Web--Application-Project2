package com.qualityhr.tests;

import com.qualityhr.pages.LoginPage;
import com.qualityhr.pages.EmployeePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    // Data Driven approach for adding multiple employees
    @DataProvider(name = "employeeData")
    public Object[][] getEmployeeData() {
        return new Object[][] {
            // Format: {FirstName, MiddleName, LastName, NewUserName, NewPassword}
            { "Dhathri", "QA", "Putty", "dhathri_user_" + System.currentTimeMillis(), "Pass12345!" }
        };
    }

    @Test(dataProvider = "employeeData")
    public void testAddEmployeeWithFullDetails(String fn, String mn, String ln, String un, String pw) {
        // Step 1: Login using credentials from config.properties
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        // Step 2: Navigate to PIM and add employee
        EmployeePage empPage = new EmployeePage(driver);
        empPage.navigateToPIM();
        
        // Step 3: Fill all columns including the toggle-based login details
        empPage.fillFullEmployeeDetails(fn, mn, ln, un, pw);
        
        // Step 4: Verify Success
        Assert.assertTrue(empPage.isEmployeeAdded(), "FAILED: Employee record was not saved successfully!");
    }
}