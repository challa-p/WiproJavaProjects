package Selenium_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Lab12_RegisterPage {
    WebDriver driver;

    // Locators
    private By myAccount = By.xpath("//span[text()='My Account']");
    private By registerOption = By.linkText("Register");
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacyPolicy = By.name("agree");
    private By continueBtn = By.xpath("//input[@value='Continue']");
    private By successMsg = By.xpath("//h1[text()='Your Account Has Been Created!']");

    // Constructor
    public Lab12_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openRegisterPage() {
        driver.findElement(myAccount).click();
        driver.findElement(registerOption).click();
    }

    public void fillForm(String fName, String lName, String emailAddr, String phone, String pwd, String confirmPwd) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(emailAddr);
        driver.findElement(telephone).sendKeys(phone);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }

    public void acceptPrivacyPolicy() {
        driver.findElement(privacyPolicy).click();
    }

    public void submit() {
        driver.findElement(continueBtn).click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.findElements(successMsg).size() > 0;
    }
}
