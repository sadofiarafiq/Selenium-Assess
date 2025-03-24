package com.qa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    private WebDriver driver;

    // Locators for the alert buttons
    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result"); // Result message after handling alert

    // Constructor
    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the page
    public void open() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    // Click JS Alert button and accept it
    public void clickJsAlert() {
        driver.findElement(jsAlertButton).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Message: " + alert.getText());
        alert.accept();
    }

    // Click JS Confirm button and accept/dismiss
    public void clickJsConfirm(boolean accept) {
        driver.findElement(jsConfirmButton).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Confirm Message: " + alert.getText());
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    // Click JS Prompt button, enter text, and accept
    public void clickJsPrompt(String inputText) {
        driver.findElement(jsPromptButton).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Prompt Message: " + alert.getText());
        alert.sendKeys(inputText);
        alert.accept();
    }

    // Generic method to handle alerts
    public void handleAlert(String action, String text) {
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Message: " + alert.getText());

        switch (action.toLowerCase()) {
            case "accept":
                alert.accept();
                break;
            case "dismiss":
                alert.dismiss();
                break;
            case "sendkeys":
                alert.sendKeys(text);
                alert.accept();
                break;
            default:
                throw new IllegalArgumentException("Invalid action: " + action);
        }
    }

    // Get the result message displayed after handling the alert
    public String getResultMessage() {
        return driver.findElement(resultText).getText();
    }
}
