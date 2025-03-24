package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;

public class DynamicTablePage {

    private WebDriver driver;

    // Locators for the table and its rows
    private By tableRows = By.xpath("//table[@id='table1']/tbody/tr");

    // Constructor
    public DynamicTablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the page
    public void open() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    // Extract all company names from the table
    public void printAllCompanyNames() {
        List<WebElement> rows = driver.findElements(tableRows);

        for (WebElement row : rows) {
            // Get the company name from the first column of each row
            String companyName = row.findElement(By.xpath("td[1]")).getText();
            System.out.println(companyName);
        }
    }

    // Verify if a specific company exists in the table
    public boolean isCompanyInTable(String companyName) {
        List<WebElement> rows = driver.findElements(tableRows);

        for (WebElement row : rows) {
            // Get the company name from the first column of each row
            String company = row.findElement(By.xpath("td[1]")).getText();
            if (company.equals(companyName)) {
                return true;
            }
        }
        return false;
    }

    // Generic method to extract data from any column in the table
    public List<String> getColumnData(int columnIndex) {
        List<String> columnData = new ArrayList<>();
        List<WebElement> rows = driver.findElements(tableRows);

        for (WebElement row : rows) {
            // Get the data from the specified column
            String data = row.findElement(By.xpath("td[" + columnIndex + "]")).getText();
            columnData.add(data);
        }
        return columnData;
    }
}