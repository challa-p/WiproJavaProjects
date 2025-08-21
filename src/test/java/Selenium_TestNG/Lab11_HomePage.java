package Selenium_TestNG;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lab11_HomePage {
    WebDriver driver;

    @FindBy(id="logoutBtn")
    WebElement logoutBtn;

    public Lab11_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoutDisplayed() {
        return logoutBtn.isDisplayed();
    }

    public void clickLogout() {
        logoutBtn.click();
    }
}

