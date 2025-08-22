package Selenium_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab16_OpenCartRegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demo.opencart.com/");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "userData")
    public void registerTest(String firstName, String lastName, String email, String phone, String password, String confirmPass) {
        // Verify Title
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Your Store"), "Title mismatch! Got: " + title);

        // My Account -> Register
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Verify Register Page
        WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertTrue(heading.isDisplayed(), "Register page not opened!");

        // Fill form
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(phone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPass);

        // Accept policy
        driver.findElement(By.name("agree")).click();

        // Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify Success
        WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertTrue(successMsg.isDisplayed(), "Account creation failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        String excelPath = "UserDetails.xls"; // place your Excel file here
        return ExcelUtils.getTableArray(excelPath, "Sheet1");
    }
}

