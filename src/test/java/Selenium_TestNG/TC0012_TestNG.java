package Selenium_TestNG;
 

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC0012_TestNG {
	WebDriver driver;
	WebDriverWait wait;
  @Test(dataProvider = "dp")
//it is major testcase
  public void f(String username, String password) throws InterruptedException {
	 
		String title=driver.getTitle();
		System.out.println("The title is:"+title);
		Thread.sleep(3000);
//		WebElement username=driver.findElement(By.name("username"));
//		username.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
  }
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.out.println("Before Method");
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  System.out.println("After Method");

	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
	  
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      
      new Object[] { "user", "user123" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}