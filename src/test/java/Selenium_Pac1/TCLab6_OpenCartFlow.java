package Selenium_Pac1;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class TCLab6_OpenCartFlow {

    public static void main(String[] args) throws InterruptedException {
        // Setup Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1. Open URL
        driver.get("");
        driver.manage().window().maximize();

        // 2. Login with credentials created in Lab 1
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("testmail@gmail.com"); // Replace with your email
        driver.findElement(By.id("input-password")).sendKeys("password");       // Replace with your password
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // 3. Go to 'Components' -> 'Monitors'
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();

        // 4. Select 25 from 'Show' dropdown
        WebElement showDropdown = driver.findElement(By.id("input-limit"));
        Select showSelect = new Select(showDropdown);
        showSelect.selectByVisibleText("25");

        // 5. Click on 'Add to cart' for the first item
        driver.findElement(By.xpath("(//button[@data-original-title='Add to Cart'])[1]")).click();

        // 6. Click on 'Specification' tab of Apple Cinema
        driver.findElement(By.linkText("Apple Cinema 30\"")).click();
        driver.findElement(By.xpath("//a[text()='Specification']")).click();

        // 7. Verify details present on the page
        if(driver.getPageSource().contains("Specification")) {
            System.out.println("Specification details are displayed.");
        }

        // 8. Click on 'Add to Wish list' button
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();

        // 9. Verify success message
        if(driver.getPageSource().contains("Success: You have added Apple Cinema 30")) {
            System.out.println("Apple Cinema added to Wish List successfully.");
        }

        // 10. Enter 'Mobile' in Search box and Search
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        // 11. Search in product descriptions
        driver.findElement(By.name("description")).click();
        driver.findElement(By.id("button-search")).click();

        // 12. Click on 'HTC Touch HD'
        driver.findElement(By.linkText("HTC Touch HD")).click();

        // 13. Update Qty to 3
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");

        // 14. Add to Cart
        driver.findElement(By.id("button-cart")).click();

        // 15. Verify success message
        if(driver.getPageSource().contains("Success: You have added HTC Touch HD to your shopping cart!")) {
            System.out.println("HTC Touch HD added to cart successfully.");
        }

        // 16. View cart
        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

        // 17. Verify mobile name in cart
        if(driver.getPageSource().contains("HTC Touch HD")) {
            System.out.println("HTC Touch HD is present in the shopping cart.");
        }

        // 18. Click Checkout
        driver.findElement(By.linkText("Checkout")).click();

        // 19. Logout
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Logout")).click();

        // 20. Verify 'Account Logout' heading
        if(driver.getPageSource().contains("Account Logout")) {
            System.out.println("Logout successful.");
        }

        // 21. Click Continue
        driver.findElement(By.linkText("Continue")).click();

        // Close browser
        driver.quit();
    }
}
