package services;

import driver.DriverInitializer;
import enums.FindType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
    public static WebElement findElementBy(FindType findType, String path) {
        By by = null;
        if (findType == FindType.xpath) {
            by = By.xpath(path);
        } else if (findType == FindType.id) {
            by = By.id(path);
        }
        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (Exception e) {
            System.out.println("element doesn't found");
            System.out.println(e.getMessage());
        }
        return element;
    }

    public static void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}