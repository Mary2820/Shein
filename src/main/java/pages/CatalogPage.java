package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class CatalogPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"product-list-v2\"]/div/div[1]/div[2]/div/p")
    public WebElement topInfo;

    public boolean topInfoIsDisplayed() {
        DriverService.waitElement(topInfo);
        return topInfo.isDisplayed();
    }

}
