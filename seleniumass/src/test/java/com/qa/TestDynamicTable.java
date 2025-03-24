package com.qa;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.Thread;
import java.util.List;
import com.qa.DynamicTablePage;

public class TestDynamicTable extends BaseTest {

    // WebDriver driver;
    DynamicTablePage dynamicTablePage;

    /*
     * @BeforeMethod
     * public void setUp() {
     * // Initialize WebDriver (use WebDriverManager to automatically manage driver)
     * WebDriverManager.chromedriver().setup();
     * driver = new ChromeDriver();
     * dynamicTablePage = new DynamicTablePage(driver);
     * }
     */

    @Test
    public void testPrintAllCompanyNames() {
        dynamicTablePage = new DynamicTablePage(driver);
        dynamicTablePage.open();
        dynamicTablePage.printAllCompanyNames(); // This will print all company names in the table
    }

    @Test
    public void testIsCompanyInTable() throws Exception {
        dynamicTablePage = new DynamicTablePage(driver);
        dynamicTablePage.open();

        // Verify if the company "Jason Doe" exists in the table
        boolean isCompanyFound = dynamicTablePage.isCompanyInTable("Jason Doe");
        Assert.assertTrue(isCompanyFound, "Company 'Jason Doe' not found in the table.");
        Thread.sleep(100000);
    }

    @Test
    public void testGetColumnData() {
        dynamicTablePage = new DynamicTablePage(driver);
        dynamicTablePage.open();

        // Extract the column data for the 'Position' column (index 2)
        List<String> positions = dynamicTablePage.getColumnData(2);
        System.out.println("Positions in the table: " + positions);

    }

}
