package Selenium_TestNG;
 
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class Lab11_LoginTest {
    WebDriver driver;
    Lab11_LoginPage login;
    Lab11_HomePage home;

    @Before
    public void setUp() {
        // WebDriverManager automatically downloads & sets ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");

        login = new Lab11_LoginPage(driver);
        home = new Lab11_HomePage(driver);
    }

    @Test
    public void testValidLogin() {
        login.setUsername("admin");
        login.setPassword("admin123");
        login.clickLogin();

        // Validate successful login
        assertTrue(home.isLogoutDisplayed());

        home.clickLogout();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
