package com.qualityhr.pages;

import com.qualityhr.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    // Private Locators - Strict POM
    private By adminModule = By.xpath("//span[text()='Admin']");
    private By addButton = By.xpath("//button[text()=' Add ']");
    private By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By essOption = By.xpath("//div[@role='listbox']//span[text()='ESS']");
    private By statusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    private By enabledOption = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By employeeHint = By.xpath("//div[@role='listbox']//span");
    private By usernameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By passwordInput = By.xpath("(//input[@type='password'])[1]");
    private By confirmPasswordInput = By.xpath("(//input[@type='password'])[2]");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By successToast = By.xpath("//p[text()='Successfully Saved']");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAdmin() {
        click(adminModule);
    }

    public void createSystemUser(String empName, String user, String pass) {
        click(addButton);
        
        // Select User Role
        click(userRoleDropdown);
        click(essOption);
        
        // Select Status
        click(statusDropdown);
        click(enabledOption);
        
        // Type Employee Name and wait for hints to appear
        sendKeys(employeeNameInput, empName);
        click(employeeHint); // Selects the first hint that appears
        
        // Fill credentials
        sendKeys(usernameInput, user);
        sendKeys(passwordInput, pass);
        sendKeys(confirmPasswordInput, pass);
        
        click(saveButton);
    }

    public boolean isUserCreated() {
        return waitForElementVisible(successToast).isDisplayed();
    }
}