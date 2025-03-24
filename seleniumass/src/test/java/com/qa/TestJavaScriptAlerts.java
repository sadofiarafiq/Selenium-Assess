package com.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJavaScriptAlerts extends BaseTest {
    JavaScriptAlertsPage jsAlertsPage;

    @Test
    public void testJsAlert() {
        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.open();
        jsAlertsPage.clickJsAlert();
        Assert.assertEquals(jsAlertsPage.getResultMessage(), "You successfully clicked an alert", "JS Alert failed!");
        System.out.println("JS Alert Test Passed!");
    }

    @Test
    public void testJsConfirmAccept() {
        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.open();
        jsAlertsPage.clickJsConfirm(true);
        Assert.assertEquals(jsAlertsPage.getResultMessage(), "You clicked: Ok", "JS Confirm Accept failed!");
        System.out.println("JS Confirm Accept Test Passed!");
    }

    @Test
    public void testJsConfirmDismiss() {
        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.open();
        jsAlertsPage.clickJsConfirm(false);
        Assert.assertEquals(jsAlertsPage.getResultMessage(), "You clicked: Cancel", "JS Confirm Dismiss failed!");
        System.out.println("JS Confirm Dismiss Test Passed!");
    }

    @Test
    public void testJsPrompt() {
        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.open();
        String inputText = "Selenium Test";
        jsAlertsPage.clickJsPrompt(inputText);
        Assert.assertEquals(jsAlertsPage.getResultMessage(), "You entered: " + inputText, "JS Prompt failed!");
        System.out.println("JS Prompt Test Passed!");
    }
}
