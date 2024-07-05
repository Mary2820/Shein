package homePage;

import base.BaseTest;
import constants.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestOfHeaders extends BaseTest {
    HomePage homePage;

    @BeforeTest
    public void setUp() {
        homePage = new HomePage();
        homePage.open(Configuration.URL);
    }

    @Test
    public void logoIsDisplayed() {
        Assert.assertTrue(homePage.logoisDisplayed());
    }

    @Test
    public void clickLogo() {
        Assert.assertTrue(homePage.clickLogo());
    }
}
