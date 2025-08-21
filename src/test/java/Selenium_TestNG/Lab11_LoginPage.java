package Selenium_TestNG;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lab11_LoginPage {
    WebDriver driver;

    // Locators using PageFactory
    @FindBy(id="username")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="loginBtn")
    WebElement loginBtn;

    public Lab11_LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String uname) {
        usernameField.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        passwordField.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }
}
