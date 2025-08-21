 package Selenium_TestNG;

import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TC0017 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    static ExtentReports extent;   // make it static and global
    ExtentTest test;

    @BeforeSuite
    public void startReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(projectPath + "\\Augreport.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method Execution");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws Exception {
        test = extent.createTest("Verify login with user: " + username);

        String title = driver.getTitle();
        System.out.println("The Title is: " + title);

        if (title.contains("OrangeHRM")) {
            test.pass("Title matched successfully");
        } else {
            test.fail("Title did not match");
            captureScreenshot();
        }

        // Using Page Object Model
        login_pageobjects obj = new login_pageobjects(driver);
        obj.enterusername(username);
        obj.enterpassword(password);
        obj.clickonlogin();

        // verify after login (optional)
        Thread.sleep(2000);
        String newTitle = driver.getTitle();
        if (newTitle.contains("OrangeHRM")) {
            test.pass("Login successful with user: " + username);
        } else {
            test.fail("Login failed for user: " + username);
            captureScreenshot();
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method Execution");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        File file = new File(projectPath + "\\data.xlsx");
        FileInputStream fis = new FileInputStream(file);

        try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            String[][] data = new String[rowCount - 1][2];

            for (int i = 1; i < rowCount; i++) {
                data[i - 1][0] = sheet.getRow(i).getCell(0).getStringCellValue();
                data[i - 1][1] = sheet.getRow(i).getCell(1).getStringCellValue();
            }
            return data;
        }
    }

    public void captureScreenshot() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenshotDir = new File(projectPath + "\\screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }

        String dest = projectPath + "\\screenshots\\screenshot_" + timestamp + ".png";
        FileUtils.copyFile(scr, new File(dest));
        test.addScreenCaptureFromPath(dest);
    }
}

