package Selenium_TestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab9_3 extends BaseTest {

	 @Test
	    public void testGoogle() {
	        driver.get("https://www.google.com");
	        System.out.println("Title in Lab9_3: " + driver.getTitle());
}
}
