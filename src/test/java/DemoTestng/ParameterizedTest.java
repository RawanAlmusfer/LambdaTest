package DemoTestng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ParameterizedTest {

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

    @Parameters({"URL"})
    @BeforeMethod
    public void beforeMethod(String url) {
        driver.get(url);
    }

    @Test
    @Parameters({"Task", "TestResult"})
    public void testFileDownload(String task, String testResult) {
        driver.findElement(By.linkText("File Download")).click();

        WebElement textArea = driver.findElement(
                By.cssSelector("#textbox"));
        wait.until(driver -> textArea.isDisplayed());

        textArea.sendKeys(task + "Execution: " + testResult);

        driver.findElement(By.id("create")).click();
        driver.findElement(By.id("link-to-download")).click();

//        Assert.assertTrue(msg.contains("Checked"), "\n Incorrect \n");

    }

}
