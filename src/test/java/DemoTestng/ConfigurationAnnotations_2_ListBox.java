package DemoTestng;

import org.testng.annotations.*;

@Test(groups = "Smoke")
public class ConfigurationAnnotations_2_ListBox {

    public void test3_BootstrapListBox() {
        System.out.println("Test Method 3");
    }

    public void test4_JQueryListBox() {
        System.out.println("Test Method 4");
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

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }

    @BeforeGroups(groups = {"Smoke"})
    public void beforeGroups() {
        System.out.println("before smoke group");
    }

    @AfterGroups(groups = {"Smoke"})
    public void afterGroups() {
        System.out.println("after smoke group");
    }
}
