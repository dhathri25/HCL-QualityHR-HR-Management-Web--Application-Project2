package com.qualityhr.pages;

import com.qualityhr.base.BasePage;
import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) { super(driver); }

    public void login(String user, String pass) {
        System.out.println("[Dhathri-Log] Initiating Login...");
        sendKeys(usernameField, user);
        sendKeys(passwordField, pass);
        click(loginBtn);
    }
}