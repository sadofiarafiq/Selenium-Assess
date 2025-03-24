package com.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class FileUploadTest extends BaseTest {
    FileUploadPage fileUploadPage;

    @Test
    public void testFileUpload() throws AWTException, InterruptedException {
        fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.open();

        // Path to the file to be uploaded (change this to an actual file on your
        // system)
        String filePath = "C:\\Users\\srafiq\\Documents\\Selenium Assessment\\testfile.txt";

        // Upload the file using Robot class
        fileUploadPage.uploadFile(filePath);

        // Click upload button
        fileUploadPage.clickUploadButton();

        // Verify that the uploaded file name appears
        String uploadedFileName = fileUploadPage.getUploadedFileName();
        Assert.assertEquals(uploadedFileName, "testfile.txt", "Uploaded file name does not match!");
        System.out.println("File uploaded successfully: " + uploadedFileName);
    }
}
