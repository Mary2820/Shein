package driver;

import constants.Configuration;
import enums.PlatformName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class DriverInitializer {
    private static WebDriver driver;

    public DriverInitializer() {
        driver = getDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                if(Configuration.PLATFORM == PlatformName.Chrome){
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    System.out.println("Driver initialized");
                }else if(Configuration.PLATFORM == PlatformName.Opera){
                    System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver2.exe");
//                    driver = new OperaDriver();
                }else{
                    Assert.fail("Incorrect platform name: " + Configuration.PLATFORM);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}

