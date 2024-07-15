package homePage;

import base.BaseTest;
import constants.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.homepage.HomePage;

public class TestOfHeaders extends BaseTest {
    HomePage homePage;

    @BeforeTest
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
    public void clickLogo() {
        Assert.assertTrue(homePage.header.logo.clickLogo());
    }

    @Test
    public void search() {
        homePage.header.search.searchFor("dress");
    }

}
