package homePage;

import base.BaseTest;
import constants.Configuration;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HomePage;

public class TestOfHeaders extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();

        homePage.openSite(Configuration.URL);
        homePage.acceptCookies();
        homePage.closePopUpWithAdvertising();
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

}
