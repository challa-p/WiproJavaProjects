package Selenium_TestNG;

 

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class Lab9_4 extends BaseTest {

    @Test
    public void testBing() {
    	driver.get("https://www.bing.com");
        System.out.println("Title in Lab9_4: " + driver.getTitle());
    }
}
