package Selenium_TestNG;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
 
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12_TutorialsNinjaRegisterTest {
    WebDriver driver;
    Lab12_RegisterPage registerPage;
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        registerPage = new Lab12_RegisterPage(driver);
    }

    @Test
    public void registerNewUser() {
        registerPage.openRegisterPage();
        String uniqueEmail = "john.doe" + System.currentTimeMillis() + "@test.com";

        registerPage.fillForm("John", "Doe", uniqueEmail,
                              "9876543210", "Pass@123", "Pass@123");
        registerPage.acceptPrivacyPolicy();
        registerPage.submit();

        Assert.assertTrue(registerPage.isRegistrationSuccessful(),
                          "❌ Registration failed – Success message not displayed!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
