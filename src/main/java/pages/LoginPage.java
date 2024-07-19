package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[text() = 'Sign In/Register']")
    public WebElement title;

    public boolean titleIsDisplayed() {
        return title.isDisplayed();
    }
}
