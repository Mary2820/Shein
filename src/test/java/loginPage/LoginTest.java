package loginPage;

import base.BaseTest;
import constants.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();

        openSite(Configuration.URL_LOGIN_PAGE);
    }

    @Test
    public void enterEmailAndClickContinue () {
        Assert.assertTrue(loginPage.titleIsDisplayed());

        loginPage.clickToEmailField();
        loginPage.enterEmail(Configuration.EMAIL);
        loginPage.clickToContinueButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Test passed");
    }
}
