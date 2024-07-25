package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[text() = 'Sign In/Register']")
    public WebElement title;

    @FindBy(xpath = "//input [contains(@aria-label, 'Email Address:')]")
    public WebElement emailField;

    @FindBy(xpath = "//div[@class = 'login-point_button']")
    public WebElement continueButton;

    public boolean titleIsDisplayed() {
        return title.isDisplayed();
    }

    public void clickToEmailField() {
        DriverService.waitElement(emailField);
        emailField.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickToContinueButton() {
        DriverService.waitElement(continueButton);
        continueButton.click();
    }



    
}
