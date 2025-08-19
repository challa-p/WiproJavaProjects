package Selenium_Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TC0012_TestNg {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open OrangeHRM
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Print page title
            String title = driver.getTitle();
            System.out.println("The Title is: " + title);

            // Explicit wait for username field
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

            // Enter credentials
            username.sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");

            // Click Login
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Wait for dashboard
            wait.until(ExpectedConditions.urlContains("/dashboard"));
            System.out.println("Login Successful! Current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
