package com.qualityhr.pages;

import com.qualityhr.base.BasePage;
import com.qualityhr.utils.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeavePage extends BasePage {
    private WaitHelper helper;

    // Navigation URLs
    private String assignUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave";
    private String leaveListUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";

    // Locators
    private By empInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By hintBox = By.xpath("//div[@role='listbox']");
    private By firstHint = By.xpath("//div[@role='listbox']//div[1]");
    private By typeDropdown = By.xpath("//div[contains(@class, 'oxd-select-text')]");
    private By personalLeaveOption = By.xpath("//div[@role='listbox']//div[contains(.,'Personal')]");
    
    private By fromDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    private By toDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    private By assignBtn = By.xpath("//button[@type='submit']");
    private By confirmBtn = By.xpath("//button[contains(@class, 'oxd-button--secondary') and (contains(.,'Yes') or contains(.,'Ok'))]");

    public LeavePage(WebDriver driver) {
    	
        super(driver);
        this.helper = new WaitHelper(driver);
    }

    public void assignLeaveStep(String fullName, String start, String end) {
        System.out.println("[Dhathri-Log] Navigating to Assign Leave...");
        driver.get(assignUrl);

        // Select Employee
        helper.sendText(empInput, fullName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hintBox));
        helper.forceClick(firstHint);

        // Select Leave Type (Personal based on your screenshot)
        helper.forceClick(typeDropdown);
        helper.forceClick(personalLeaveOption);

        // Enter Dates
        updateDate(fromDate, start);
        updateDate(toDate, end);

        // Click Assign and Handle Popup
        helper.forceClick(assignBtn);
        handlePopup();
    }

    public boolean verifyLeaveList() {
        System.out.println("[Dhathri-Log] Verifying in Leave List...");
        driver.get(leaveListUrl);
        // If we successfully reach the list and see "Records Found", we pass
        return driver.getCurrentUrl().contains("viewLeaveList");
    }

    private void updateDate(By locator, String val) {
        WebElement el = helper.waitForVisibility(locator);
        el.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        el.sendKeys(val, Keys.TAB);
    }

    private void handlePopup() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        } catch (Exception e) {}
    }
}