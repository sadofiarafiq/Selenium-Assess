package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadPage {
    WebDriver driver;

    // Locators
    private By uploadButton = By.id("file-upload");
    private By submitButton = By.id("file-submit");
    private By uploadedFileName = By.id("uploaded-files");

    // Constructor
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the file upload page
    public void open() {
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    // Method to upload a file using Robot class (without sendKeys)
    public void uploadFile(String filePath) throws AWTException, InterruptedException {
        driver.findElement(uploadButton).click(); // Click on the upload button

        Thread.sleep(20000); // Wait for file upload dialog to open

        Robot robot = new Robot();

        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Press Control + V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    // Method to submit the file after uploading
    public void clickUploadButton() {
        driver.findElement(submitButton).click();
    }

    // Method to get the uploaded file name
    public String getUploadedFileName() {
        return driver.findElement(uploadedFileName).getText();
    }
}
