package DemoTestng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeFailedScreenshots {
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(300);
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterMethod
    public void takeSSForFailure(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot ss = (TakesScreenshot) driver;
            File source = ss.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/Screenshots/" + testResult.getName() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSimpleFormDemo() {
        driver.findElement(By.linkText("Simple Form Demo")).click();

        WebElement inputField = driver.findElement(By.xpath("//input[@id='user-message']"));
        wait.until(driver -> inputField.isDisplayed());

        inputField.sendKeys("Rawan");

        driver.findElement(By.id("showInput")).click();

        String msg = driver.findElement(By.
                id("message")).getText();

        Assert.assertTrue(msg.contains("Rawan"), "\n Incorrect \n");
    }

}
