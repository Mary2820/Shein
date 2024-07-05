package pages;

import driver.DriverInitializer;
import org.openqa.selenium.WebDriver;
import services.DriverService;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        this.driver = DriverInitializer.getDriver();
        DriverService.initPageElements(this);
    }
}
