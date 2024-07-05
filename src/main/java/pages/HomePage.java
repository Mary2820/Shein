package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"header_logo_icon\"]")
    public WebElement logo;

    public HomePage open(String url) {
        driver.get(url);
        return this;
    }

    public boolean clickLogo() {
        DriverService.waitElement(logo);
        logo.click();
        return true;
    }
    public boolean logoisDisplayed() {
        DriverService.waitElement(logo);
        return logo.isDisplayed();
    }




}
