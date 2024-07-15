package services;

import driver.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverService {
    private static WebDriver driver;

    public static void initPageElements(Object page) {
        PageFactory.initElements(DriverInitializer.getDriver(), page);
        driver = DriverInitializer.getDriver();
    }

    public static void waitElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    public static void openSite(String url) {
        driver.get(url);
    }

}