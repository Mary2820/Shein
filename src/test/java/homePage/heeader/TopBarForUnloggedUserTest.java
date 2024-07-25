package homePage.heeader;

import base.BaseTest;
import constants.Configuration;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TopBarForUnloggedUserTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        openSite(Configuration.URL_HOME_PAGE);

        homePage = new HomePage();
        homePage.acceptCookies();
        homePage.closePopUpWithAdvertising();
        homePage.closeQuickViewAd();
    }

    @Feature("Profile menu")
    @Test
    public void whenProfileMenuIconClickedLoginPageIsOpened() {
        LoginPage loginPage = new LoginPage();
        homePage.header.profileMenu.clickProfileMenuIcon();

        Assert.assertTrue(loginPage.titleIsDisplayed());
    }

    @Feature("Profile menu")
    @Test
    public void whenCursorHoveredOverProfileMenuIconUserDropDownIsDisplayed() {
        homePage.header.profileMenu.profileMenuIsDisplayed();

        homePage.header.profileMenu.hoverOverProfileMenuIcon();

        Assert.assertTrue(homePage.header.profileMenu.userDropdownIsDisplayed());
    }

    @DataProvider(name = "userDropdownItems")
    public Object[][] userDropdownItemsForUnloggedUser() {
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
    public void whenUserDropDownMenuDisplayedElementIsDisplayedAndCorrect(String itemNumber, String itemText) {
        homePage.header.profileMenu.hoverOverProfileMenuIcon();
        Assert.assertTrue(homePage.header.profileMenu.userDropdownIsDisplayed());

        Assert.assertTrue(homePage.header.profileMenu.userDropdownItemIsDisplayed(itemNumber));
        Assert.assertTrue(homePage.header.profileMenu.userDropdownItemTextIsCorrect(itemNumber, itemText));
    }

    @Feature("Profile menu")
    @Test(dataProvider = "userDropdownItems")
    public void whenProfileMenuItemClickedLoginPageIsOpened(String itemNumber, String itemText) {
        LoginPage loginPage = new LoginPage();
        homePage.header.profileMenu.hoverOverProfileMenuIcon();
        homePage.header.profileMenu.clickUserDropdownItem(itemNumber);
        Assert.assertTrue(loginPage.titleIsDisplayed());
    }
}
