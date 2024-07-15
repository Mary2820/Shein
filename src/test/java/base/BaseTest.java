package base;

import driver.DriverInitializer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

//    @AfterTest
//    public void teardown() {
//        DriverInitializer.getDriver().quit();
//    }

    @BeforeTest
    public void startDriver () {
        DriverInitializer.getDriver();
    }
}