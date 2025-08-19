package Selenium_Pac1;

 

import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class TC0013_TestNg {
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		Thread.sleep(3000);
		//WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }
 
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }
 
 
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "pooja", "admin123" },
      new Object[] { "geeta", "welcome" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
	  
  }
 
  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
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
 
 