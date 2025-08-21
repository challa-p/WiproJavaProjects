 
package Selenium_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login_pageobjects {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public login_pageobjects(WebDriver driver2) {
        this.driver = driver2;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By uname = By.name("username");
    By pword = By.name("password");
    By loginbutton = By.xpath("//button[@type='submit']");

    // Username
    public void enterusername(String username) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(uname));
        userField.sendKeys(username);
    }

    // Password
    public void enterpassword(String password) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(pword));
        passField.sendKeys(password);
    }

    // Click login
    public void clickonlogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
        loginBtn.click();
    }
}
