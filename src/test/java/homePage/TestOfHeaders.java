package homePage;

import base.BaseTest;
import constants.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HomePage;

public class TestOfHeaders extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        homePage.openSite(Configuration.URL);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.acceptCookies();
        homePage.closePopUpWithAdvertising();
    }

    @Test
    public void logoIsDisplayed() {
        Assert.assertTrue(homePage.header.logo.logoisDisplayed());
    }

    @Test
    public void whenClickLogoHomePageOpens() {
        whenClickSearchAndEnterRequestCatalogPageIsOpened();

        homePage.header.logo.clickLogo();

        Assert.assertTrue(homePage.homePageIsOpened());
    }

    @Test
    public void whenClickSearchAndEnterRequestCatalogPageIsOpened() {
        CatalogPage catalogPage = new CatalogPage();

        homePage.header.search.searchFor("dress");
        Assert.assertTrue(catalogPage.topInfoIsDisplayed());
    }

    @Test
    public void whenClickCancelButtonOfSearchFieldSearchFieldIsCleared() {
        homePage.header.search.cancelSearchFor("dress");

        Assert.assertTrue(homePage.header.search.searchForEmpty());
    }

}
