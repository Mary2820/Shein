package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class HomePage extends BasePage {
    public Header header;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//div[@class = 'sui-dialog__body']//span[contains(@class,'sui-icon-common__wrap')]")
    public WebElement closePopUpButton;

    @FindBy(xpath = "//span[@class = 'sui-popup-parent__hidden']")
    public WebElement closePopUpButton2;

    @FindBy(xpath = "//div[@class = 'one-third-wrapper']")
    public WebElement promoBar;

    public HomePage() {
        header = new Header();
    }

    public void acceptCookies() {
        DriverService.waitElement(acceptCookiesButton);
        acceptCookiesButton.click();
    }

    public void closePopUpWithAdvertising () {
        try {
            DriverService.waitElement(closePopUpButton);
            if (closePopUpButton.isDisplayed()) {
                closePopUpButton.click();
            }
        } catch (Exception ignored) {
        }
        try {
            DriverService.waitElement(closePopUpButton2);
            if (closePopUpButton2.isDisplayed()) {
                closePopUpButton2.click();
            }
        } catch (Exception ignored) {
        }
    }

    public void openSite(String url) {
        DriverService.openSite(url);
    }

    public boolean homePageIsOpened() {
        DriverService.waitElement(promoBar);
        return promoBar.isDisplayed();
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
            @FindBy(xpath = "//div[contains(@class, 'search-input')]")
            public WebElement searchField;

            @FindBy(xpath = "//input[@name='header-search']")
            public WebElement searchInput;

            @FindBy(xpath = "//div[@class = 'search-btn she-btn-black j-search-btn not-fsp-element']")
            public WebElement searchButton;

            @FindBy(xpath = "//div[@class='cancel-wrap']/span")
            public WebElement cancelButton;

            public Search() {
                DriverService.initPageElements(this);
            }

            public void searchFor(String text) {
                DriverService.waitElement(searchField);
                searchField.click();
                DriverService.waitElement(searchInput);
                searchInput.sendKeys(text);
                searchButton.click();
            }

            public void cancelSearchFor(String text) {
                DriverService.waitElement(searchField);
                searchField.click();
                DriverService.waitElement(searchInput);
                searchInput.sendKeys(text);
                DriverService.waitElement(cancelButton);
                cancelButton.click();
            }

            public boolean searchForEmpty() {
                String value = searchInput.getAttribute("value");
                return value.isEmpty();
            }
        }
    }
}
