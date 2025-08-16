package Selenium_Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class OpenCartRegisterTest {
    public static void main(String[] args) {
        // Setup Firefox
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Part 1: Launch Application
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        
        // Verify title
        String expectedTitle = "Your Store";
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Title Verified: " + expectedTitle);
        } else {
            System.out.println("Title Mismatch! Found: " + driver.getTitle());
        }

        // Click My Account dropdown and Register
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Verify heading
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Register Account']")));
        System.out.println("Heading Verified: " + heading.getText());

        // Click Continue without filling details
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
        System.out.println("Warning: " + warning.getText());

        // Part 2: Your Personal Details
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"); // 33 chars

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        // Capture error if any
        if (driver.findElements(By.cssSelector(".text-danger")).size() > 0) {
            System.out.println("First Name Error: " + driver.findElement(By.cssSelector(".text-danger")).getText());
        }

        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("John");
        driver.findElement(By.id("input-lastname")).sendKeys("Doe");
        driver.findElement(By.id("input-email")).sendKeys("test" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

        // Part 3: Your Address
        driver.findElement(By.id("input-address-1")).sendKeys("123 Main Street");
        driver.findElement(By.id("input-city")).sendKeys("Hyderabad");
        driver.findElement(By.id("input-postcode")).sendKeys("500001");
        driver.findElement(By.id("input-country")).sendKeys("India");
        driver.findElement(By.id("input-zone")).sendKeys("Andhra Pradesh");

        // Part 4: Password
        driver.findElement(By.id("input-password")).sendKeys("test1234");
        driver.findElement(By.id("input-confirm")).sendKeys("test1234");

        // Newsletter and Privacy Policy
        driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
        driver.findElement(By.name("agree")).click();

        // Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify account creation
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your Account Has Been Created!']")));
        System.out.println("Account Creation: " + success.getText());

        driver.quit();
    }
}
