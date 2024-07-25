package pages;

import enums.FindType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import services.DriverService;

import java.util.List;

public class HomePage extends BasePage {
    public Header header;

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//div[@class = 'sui-dialog__body']//span[contains(@class,'sui-icon-common__wrap')]")
    public WebElement closePopUpButton;

    @FindBy(xpath = "//*[@class = 'btn-new']")
    public WebElement closePopUpButton2;

    @FindBy(xpath = "//div[@class = 'quickg-outside']")
    public WebElement quickViewAd;

    @FindBy(xpath = "//div[@class = 'one-third-wrapper']")
    public WebElement promoBar;

    public HomePage() {
        header = new Header();
    }

    public void acceptCookies() {
        try {
            DriverService.waitElement(acceptCookiesButton);
        } catch (Exception ignored) {;
        }
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
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

    public void closeQuickViewAd() {
        try {
            DriverService.waitElement(quickViewAd);
            if (quickViewAd.isDisplayed()) {
                quickViewAd.click();
            }
        } catch (Exception ignored) {
        }
    }

    public boolean homePageIsOpened() {
        DriverService.waitElement(promoBar);
        return promoBar.isDisplayed();
    }

    public class Header {
        public Logo logo;
        public Search search;
        public ProfileMenu profileMenu;

        public Header() {
            DriverService.initPageElements(this);
            this.logo = new Logo();
            this.search = new Search();
            this.profileMenu = new ProfileMenu();


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

            @FindBy(xpath = "//div[@class = 'search-content' ]")
            public WebElement searchContentList;

            @FindBy(xpath = "//div[@class = 'hot-words-title' ]")
            public WebElement hotWordsTitle;

            @FindBy(xpath = "//div[contains(@class, 'hotwords-item')]")
            public WebElement hotWordsItemsList;

            @FindBy(xpath = "//div[@class = 'association-words']")
            public WebElement listOfAssociationWords;

            public Search() {
                DriverService.initPageElements(this);
            }

            public void clickSearchField() {
                DriverService.waitElement(searchField);
                searchField.click();
            }

            public void enterTextToSearchField(String text) {
                DriverService.waitElement(searchInput);
                searchInput.sendKeys(text);
            }

            public void clickSearchButton() {
                DriverService.waitElement(searchButton);
                searchButton.click();
            }

            public void submitSearch() {
                DriverService.waitElement(searchInput);
                searchInput.submit();
            }

            public void clickCancelButton() {
                DriverService.waitElement(cancelButton);
                cancelButton.click();
            }

            public boolean searchFieldIsEmpty() {
                String value = searchInput.getAttribute("value");
                return value.isEmpty();
            }

            public boolean searchContentListIsDisplayed() {
                return searchContentList.isDisplayed();
            }

            public boolean hotWordsTitleIsDisplayed() {
                return hotWordsTitle.isDisplayed();
            }

            public boolean hotWordsItemsListIsDisplayed() {
                return hotWordsItemsList.isDisplayed();
            }

            public boolean listOfAssociationWordsIsDisplayed() {
                return listOfAssociationWords.isDisplayed();
            }

            public boolean associationWordsContainEnteredText(String enteredText) {
                List<WebElement> elements = driver.findElements(By.className("match-text"));

                if (elements.isEmpty()) {
                    return false;
                }

                for (WebElement element : elements) {
                    if (!element.getText().contains(enteredText)) {
                        return false;
                    }
                }
                return true;
            }
        }

        public class ProfileMenu {
            @FindBy(xpath = "//div[@class = 'header-right-dropdown-ctn j-header-right-dropdown-ctn new']")
            public WebElement profileMenuIcon;

            @FindBy(xpath = "//div[@class = 'user-dropdown']")
            public WebElement userDropdown;

            public ProfileMenu() {
                DriverService.initPageElements(this);
            }

            public WebElement findMenuElement(String index) {
                String xpathElement = "//div[@class = 'user-dropdown']//a[" + index + "]/em";
                return DriverService.findElementBy(FindType.xpath, xpathElement);
            }

            public boolean profileMenuIsDisplayed() {
                return profileMenuIcon.isDisplayed();
            }

            public void hoverOverProfileMenuIcon() {
                DriverService.hoverOverElement(profileMenuIcon);
            }

            public void clickProfileMenuIcon() {
                DriverService.waitElement(profileMenuIcon);
                profileMenuIcon.click();
            }

            public boolean userDropdownIsDisplayed() {
                return userDropdown.isDisplayed();
            }

            public boolean userDropdownItemIsDisplayed(String index) {
                WebElement element = findMenuElement(index);
                return element.isDisplayed();
            }

            public boolean userDropdownItemTextIsCorrect(String index, String text) {
                WebElement element = findMenuElement(index);
                return element.getText().equals(text);
            }

            public void clickUserDropdownItem(String index) {
                WebElement element = findMenuElement(index);
                element.click();
            }

        }
    }
}
