package Selenium_Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExam_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		
		  
        driver.get("https://www.google.com/");
        System.out.println("Opened Google successfully");
        
        WebElement search = driver.findElement(By.id("APjFqb")); // Google search box
        search.sendKeys("Automation Tools");
        
        search.submit(); 
		
			

	}

}
