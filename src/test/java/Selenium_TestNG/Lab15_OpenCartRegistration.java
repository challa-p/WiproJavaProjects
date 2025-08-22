package Selenium_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab15_OpenCartRegistration {
    public static void main(String[] args) throws IOException {
        // Path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();  
        WebDriver driver = new ChromeDriver();

        // Open URL
        driver.get("http://demo.opencart.com/");
        driver.manage().window().maximize();

        // Verify title
        if (driver.getTitle().equals("Your Store")) {
            System.out.println("Title Verified: " + driver.getTitle());
        } else {
            System.out.println("Title Mismatch!");
        }

        // Read CSV File
        String csvFile = "UserDetails.csv"; // change path
        String line;
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        // Skip Header Line
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] user = line.split(splitBy);

            String firstName = user[0];
            String lastName = user[1];
            String email = user[2];
            String phone = user[3];
            String password = user[4];
            String confirmPass = user[5];

            // Click My Account → Register
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            driver.findElement(By.linkText("Register")).click();

            // Verify Register Page
            WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
            if (heading.isDisplayed()) {
                System.out.println("On Register Page");
            }

            // Fill details
            driver.findElement(By.id("input-firstname")).sendKeys(firstName);
            driver.findElement(By.id("input-lastname")).sendKeys(lastName);
            driver.findElement(By.id("input-email")).sendKeys(email);
            driver.findElement(By.id("input-telephone")).sendKeys(phone);
            driver.findElement(By.id("input-password")).sendKeys(password);
            driver.findElement(By.id("input-confirm")).sendKeys(confirmPass);

            // Select checkbox
            driver.findElement(By.name("agree")).click();

            // Click Continue
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Verify success message
            WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
            if (successMsg.isDisplayed()) {
                System.out.println("Account created successfully for: " + firstName + " " + lastName);
            } else {
                System.out.println("Account creation failed for: " + firstName + " " + lastName);
            }

            // Go back to home before next registration
            driver.get("http://demo.opencart.com/");
        }

        driver.quit();
    }
}
