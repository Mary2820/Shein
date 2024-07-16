package base;

import driver.DriverInitializer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @AfterMethod
    public void teardown() {
        DriverInitializer.closeDriver();
    }

    @BeforeMethod
    public void startDriver () {

        DriverInitializer.getDriver();
    }
}