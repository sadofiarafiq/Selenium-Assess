
package com.qa;

import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
//import com.qa.LoginPage;

import java.io.File;
import java.io.IOException;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    /*
     * public void setup() {
     * 
     * System.setProperty("webdriver.chrome.driver",
     * "C://Users//srafiq//Downloads//chromedriver-win64//chromedriver.exe");
     * System.setProperty("webdriver.chrome.logfile", "chrome_logs.txt");
     * System.setProperty("webdriver.chrome.verboseLogging", "true");
     * // Now you can initialize the ChromeDriver without needing to manually set
     * the
     * // path
     * 
     * Proxy proxy = new Proxy();
     * proxy.setHttpProxy("proxyhost:proxyport");
     * ChromeOptions options = new ChromeOptions();
     * // options.addArguments("--headless");
     * options.setProxy(proxy);
     * options.addArguments("--remote-debugging-port=9227"); // Try another port if
     * 9222 is blocked
     * options.addArguments("--remote-allow-origins=*");
     * options.addArguments("--disable-dev-shm-usage"); // Disables the use of
     * /dev/shm, which can cause issues in some
     * // environments
     * 
     * options.addArguments("--no-sandbox");
     * options.addArguments("--disable-web-security");
     * options.addArguments("--disable-extensions");
     * options.addArguments("--ignore-certificate-errors");
     * options.addArguments("--log-level=0"); // Debug level logs
     * options.addArguments("user-data-dir=C:\\path\\to\\new\\chrome-profile");
     * 
     * driver = new ChromeDriver(options);
     * driver.get("https://the-internet.herokuapp.com/login");
     * loginPage = new LoginPage(driver);
     * }
     */

    // Test valid login scenario
    @Test
    public void testValidLogin() {
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            loginPage = new LoginPage(driver);
            // Enter valid credentials
            loginPage.enterUsername("tomsmith");
            loginPage.enterPassword("SuperSecretPassword!");
            loginPage.clickLoginButton();

            // Verify if login is successful (Check for the presence of the logout button)
            boolean isLoginSuccessful = loginPage.isLoginSuccessful();
            Assert.assertTrue(isLoginSuccessful, "Login failed! Logout button not found.");
            System.out.println("Valid login test passed!");
        } catch (Exception e) {
            captureScreenshot("testValidLogin");
            System.out.println("Valid login failed: " + e.getMessage());
        }
    }

    // Test invalid login scenario
    @Test
    public void testInvalidLogin() {
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            loginPage = new LoginPage(driver);
            // Enter invalid credentials
            loginPage.enterUsername("invalidUsername");
            loginPage.enterPassword("invalidPassword");
            loginPage.clickLoginButton();

            // Verify if error message is shown for invalid login
            String errorMessage = loginPage.getErrorMessage();
            Assert.assertTrue(errorMessage.contains("Your username is invalid!"), "Error message not found.");
            System.out.println("Invalid login test passed!");
        } catch (Exception e) {
            captureScreenshot("testInvalidLogin");
            System.out.println("Invalid login failed: " + e.getMessage());
        }
    }

    // Method to capture screenshot when login fails
    public void captureScreenshot(String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("screenshots/" + testName + ".png");
            FileHandler.copy(screenshot, destination);
            System.out.println("Screenshot captured for test: " + testName);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    // Method to close the browser
    public void tearDown() {
        driver.quit();
    }

    // Main method to execute tests
    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.setup();

        // Run valid login test
        test.testValidLogin();

        // Run invalid login test
        test.testInvalidLogin();

        test.tearDown();
    }
}