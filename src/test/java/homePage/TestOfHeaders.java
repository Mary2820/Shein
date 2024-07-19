package homePage;

import base.BaseTest;
import constants.Configuration;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HomePage;
import pages.LoginPage;

public class TestOfHeaders extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();

        homePage.openSite(Configuration.URL);
        homePage.acceptCookies();
        homePage.closePopUpWithAdvertising();
        homePage.closeQuickViewAd();
    }

    @Feature("Logo")
    @Test
    public void logoIsDisplayed() {
        Assert.assertTrue(homePage.header.logo.logoisDisplayed());
    }

    @Feature("Logo")
    @Test
    public void whenClickLogoHomePageOpens() {
        CatalogPage catalogPage = new CatalogPage();
        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");
        homePage.header.search.clickSearchButton();
        Assert.assertTrue(catalogPage.topInfoIsDisplayed());

        homePage.header.logo.clickLogo();

        Assert.assertTrue(homePage.homePageIsOpened());
    }

    @Feature("Search")
    @Test
    public void whenClickSearchAndEnterRequestCatalogPageIsOpened() {
        CatalogPage catalogPage = new CatalogPage();

        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");
        homePage.header.search.clickSearchButton();

        Assert.assertTrue(catalogPage.topInfoIsDisplayed());
    }

    @Feature("Search")
    @Test
    public void whenClickCancelButtonOfSearchFieldSearchFieldIsCleared() {
        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");

        homePage.header.search.clickCancelButton();

        Assert.assertTrue(homePage.header.search.searchFieldIsEmpty());
    }

    @Feature("Search")
    @Test
    public void clickSearchByEnterIsSukcessful() {
        CatalogPage catalogPage = new CatalogPage();

        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");
        homePage.header.search.submitSearch();

        Assert.assertTrue(catalogPage.topInfoIsDisplayed());
    }

    @Feature("Search")
    @Test
    public void whenClickSearchFieldListWithHotWordsAppears() {
        homePage.header.search.clickSearchField();

        Assert.assertTrue(homePage.header.search.searchContentListIsDisplayed());
        Assert.assertTrue(homePage.header.search.hotWordsTitleIsDisplayed());
        Assert.assertTrue(homePage.header.search.hotWordsItemsListIsDisplayed());
    }

    @Feature("Search")
    @Test
    public void whenEnterRequestToAppearAssociationWords() {
        homePage.header.search.clickSearchField();

        homePage.header.search.enterTextToSearchField("pink jeans");

        Assert.assertTrue(homePage.header.search.listOfAssociationWordsIsDisplayed());
        Assert.assertTrue(homePage.header.search.associationWordsContainEnteredText("Pink Jeans"));
    }

    @Feature("Profile menu")
    @Test
    public void whenHoverOverProfileMenuIconToDisplayUserDropDown() {
        homePage.header.profileMenu.profileMenuIsDisplayed();

        homePage.header.profileMenu.hoverOverProfileMenuIcon();

        Assert.assertTrue(homePage.header.profileMenu.userDropdownIsDisplayed());
    }

    @DataProvider(name = "userDropdownItems")
    public Object[][] userDropdownItems() {
        return new Object[][]{
                {"1", "Sign In / Register"},
                {"2", "My Orders"},
                {"3", "My Message"},
                {"4", "My Coupons"},
                {"5", "My Points"},
                {"6", "Recently Viewed"},
                {"7", "More Services"}
        };
    }

    @Feature("Profile menu")
    @Test(dataProvider = "userDropdownItems")
    public void whenUserDropDownMenuIsDisplayedElementIsDisplayedAndCorrect(String itemNumber, String itemText) {
        homePage.header.profileMenu.hoverOverProfileMenuIcon();
        Assert.assertTrue(homePage.header.profileMenu.userDropdownIsDisplayed());

        Assert.assertTrue(homePage.header.profileMenu.userDropdownItemIsDisplayed(itemNumber));
        Assert.assertTrue(homePage.header.profileMenu.userDropdownItemTextIsCorrect(itemNumber, itemText));
    }

    @Feature("Profile menu")
    @Test
    public void whenClickSignInRegisterPageIsOpened() {
        LoginPage loginPage = new LoginPage();
        homePage.header.profileMenu.hoverOverProfileMenuIcon();
        homePage.header.profileMenu.clickUserDropdownItem("1");

        Assert.assertTrue(loginPage.titleIsDisplayed());
    }

}
