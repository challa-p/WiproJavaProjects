package Selenium_Pac1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_SelectDropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://tutorialsninja.com/demo/index.php?");
        
        // Hover over Desktops menu
        WebElement desktopsMenu = driver.findElement(By.linkText("Desktops"));
        Actions action = new Actions(driver);
        action.moveToElement(desktopsMenu).perform();
        
        Thread.sleep(2000); // wait for submenu to appear
        
        // Click on Mac under Desktops
        WebElement macOption = driver.findElement(By.linkText("Mac"));
        macOption.click();
        
        System.out.println("Navigated to Mac category successfully!");
        
        driver.quit();
    }

}
