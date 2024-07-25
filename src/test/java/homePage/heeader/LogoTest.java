package homePage.heeader;

import base.BaseTest;
import constants.Configuration;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HomePage;

public class LogoTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();

        openSite(Configuration.URL_HOME_PAGE);

        homePage.acceptCookies();
        homePage.closePopUpWithAdvertising();
        homePage.closeQuickViewAd();
    }

    @Feature("Logo")
    @Test
    public void whenHomePageOpenedLogoIsDisplayed() {
        Assert.assertTrue(homePage.header.logo.logoisDisplayed());
    }

    @Feature("Logo")
    @Test
    public void whenLogoClickedHomePageIsOpened() {
        CatalogPage catalogPage = new CatalogPage();
        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");
        homePage.header.search.clickSearchButton();
        Assert.assertTrue(catalogPage.topInfoIsDisplayed());

        homePage.header.logo.clickLogo();

        Assert.assertTrue(homePage.homePageIsOpened());
    }
}
