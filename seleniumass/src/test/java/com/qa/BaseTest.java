package com.qa;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver",
                "C://Users//srafiq//Downloads//chromedriver-win64//chromedriver.exe");
        System.setProperty("webdriver.chrome.logfile", "chrome_logs.txt");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("proxyhost:proxyport");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.setProxy(proxy);
        options.addArguments("--remote-debugging-port=9227"); // Try another port if 9222 is blocked
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage"); // Disables the use of /dev/shm, which can cause issues in some
                                                         // environments

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--log-level=0"); // Debug level logs
        options.addArguments("user-data-dir=C:\\path\\to\\new\\chrome-profile");
        options.addArguments("--disable-blink-features=AutomationControlled"); // Prevent bot detection

        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }
}
