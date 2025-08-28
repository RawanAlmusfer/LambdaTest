package DemoTestng;

import org.testng.annotations.*;

public class ConfigurationAnnotations_1_DatePickers {

    @Test(groups = "Smoke")
    public void test1_BootstrapDatePicker() {
     System.out.println("Test Method 1");
    }

    @Test(groups = {"Regression", "Smoke"})
    public void test2_JQueryDatePicker() {
        System.out.println("Test Method 2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }
}
