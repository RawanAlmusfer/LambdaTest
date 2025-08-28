package DemoTestng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class First_Automated_Test {

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
    public void tearDown() {
//        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test(priority = 2)
    public void testTableSortAndSearch() {
        driver.findElement(By.linkText("Table Sort & Search")).click();

        WebElement searchBox = driver.findElement(
                By.xpath("//div[@id='example_filter']//input[@type='search']"));
        wait.until(driver -> searchBox.isDisplayed());

        searchBox.sendKeys("Chicago");

    }

    @Test(priority = 1)
    public void testBootstrapDatePicker() {

        driver.findElement(By.linkText("Bootstrap Date Picker")).click();

        WebElement datePicker = driver.findElement(By.id("birthday"));
        wait.until(driver -> datePicker.isDisplayed());
        datePicker.sendKeys("10/09/2000");
    }

}
