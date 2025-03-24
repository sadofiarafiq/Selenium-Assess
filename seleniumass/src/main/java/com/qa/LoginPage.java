package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    // Locators for the username, password, login button, and logout button
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By errorMessage = By.id("flash");
    By logoutButton = By.cssSelector("a[href='/logout']");
    By pageTitle = By.tagName("h2"); // Assuming the page title is in an h2 element.

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to check if login is successful by looking for logout button
    public boolean isLoginSuccessful() {
        try {
            WebElement logoutBtn = driver.findElement(logoutButton);
            return logoutBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to get the error message for invalid login
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Method to get the page title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}