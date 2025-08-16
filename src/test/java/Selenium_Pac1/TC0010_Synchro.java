package Selenium_Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration; 

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0010_Synchro {

    public static void main(String[] args) {
        // Setup Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        username.sendKeys("Admin");

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        password.sendKeys("admin123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();

        // Optional: Verify successful login
        if(driver.getPageSource().contains("Dashboard")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        driver.quit();
    }
}
