package Selenium_TestNG;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0013_TestNGParllelTesting {
  @Test
  public void test1() {
	  System.out.println("This is test 1");
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.amazon.com/");
  }
}
