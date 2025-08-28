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

public class AssertionsTest {

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
    public void tearDown() {
//        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void testSingleCheckbox() {
        driver.findElement(By.linkText("Checkbox Demo")).click();

        WebElement checkBox = driver.findElement(
                By.xpath("//label[text()='Click on check box']/input"));
        wait.until(driver -> checkBox.isDisplayed());

        checkBox.click();

        String msg = driver.findElement(By.
                xpath("//label[text()='Click on check box']//following-sibling::p")).getText();

        Assert.assertTrue(msg.contains("Checked"), "\n Incorrect \n");

    }


    @Test
    public void testRadioButtons() {
        driver.findElement(By.linkText("Radio Buttons Demo")).click();

        WebElement gender = driver.findElement(
                By.xpath("//input[@value='Other']"));
        wait.until(driver -> gender.isDisplayed());

        gender.click();

        driver.findElement(
                By.xpath("//input[@value='5 - 15']")).click();
        driver.findElement(
                By.xpath("//button[text()='Get values']")).click();


        String genderMsg = driver.findElement(By.
                xpath("//span[@class='genderbutton']")).getText();
        String ageMsg = driver.findElement(By.
                xpath("//span[@class='groupradiobutton']")).getText();

        softAssert.assertEquals(genderMsg, "Other", "\n Incorrect gender \n");
        softAssert.assertTrue(ageMsg.contains("5 - 15"), "\n Incorrect age \n");
        softAssert.assertAll("\n Soft assert");

    }

}
