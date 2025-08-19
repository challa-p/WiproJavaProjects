package Selenium_JUnit;
 

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Lab8_Test {

    WebDriver driver;

    @Before
    public void setUp() {
        // WebDriverManager will download & setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        assertEquals("Google", title);   
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

