 package Selenium_TestNG;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab14 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
         
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void registerUser() throws Exception {
        // ✅ Load Excel file
        FileInputStream fis = new FileInputStream(new File("UserDetails.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        // ✅ Reading second row (first row = headers)
        Row row = sheet.getRow(1);

        String fname = row.getCell(0).getStringCellValue();
        String lname = row.getCell(1).getStringCellValue();
        String email = row.getCell(2).getStringCellValue();
        String telephone = row.getCell(3).getStringCellValue();
        String password = row.getCell(4).getStringCellValue();
        String confirmPassword = row.getCell(5).getStringCellValue();

        workbook.close();

         driver.get("https://demo.opencart.com/");

         Assert.assertEquals(driver.getTitle(), "Your Store", "Title mismatch!");

         driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

         WebElement registerHeading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertTrue(registerHeading.isDisplayed(), "Register Account page not displayed!");

         driver.findElement(By.id("input-firstname")).sendKeys(fname);
        driver.findElement(By.id("input-lastname")).sendKeys(lname);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

         driver.findElement(By.name("agree")).click();

         driver.findElement(By.xpath("//input[@value='Continue']")).click();

         WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertTrue(successMsg.isDisplayed(), "Account creation failed!");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ Browser closed successfully!");
        }
    }
}

