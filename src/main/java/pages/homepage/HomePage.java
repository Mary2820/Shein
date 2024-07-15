package pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import services.DriverService;

public class HomePage extends BasePage {
    public Header header;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div[2]/div[2]/span")
    public WebElement closePopUpButton;

    public HomePage() {
        header = new Header();
    }

    public void acceptCookies() {
        DriverService.waitElement(acceptCookiesButton);
        acceptCookiesButton.click();
    }

    public void closePopUpWithAdvertising () {
        DriverService.waitElement(closePopUpButton);
        closePopUpButton.click();
    }

    public void openSite(String url) {
        DriverService.openSite(url);
    }

    public class Header {
        public Logo logo;
        public Search search;

        public Header() {
            DriverService.initPageElements(this);
            this.logo = new Logo();
            this.search = new Search();

        }

        public class Logo {
            @FindBy(xpath = "//*[@id=\"header_logo_icon\"]")
            public WebElement logo;

            public Logo() {
                DriverService.initPageElements(this);
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

        public class Search {
            @FindBy(xpath = "//div[2]/form/div[1]")
            public WebElement searchField;

            @FindBy(xpath = "//div[2]/form/div[2]")
            public WebElement searchButton;

            public Search() {
                DriverService.initPageElements(this);
            }

            public void searchFor(String text) {
                DriverService.waitElement(searchField);
                searchField.click();
                searchField.sendKeys(text);
                searchButton.click();
            }
        }
    }






}
