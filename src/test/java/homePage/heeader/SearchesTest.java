package homePage.heeader;

import base.BaseTest;
import constants.Configuration;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HomePage;

public class SearchesTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();

        openSite(Configuration.URL_HOME_PAGE);

        homePage.acceptCookies();
        homePage.closePopUpWithAdvertising();
        homePage.closeQuickViewAd();
    }

    @Feature("Search")
    @Test
    public void whenRequestEnteredAndSearchClickedCatalogPageIsOpened() {
        CatalogPage catalogPage = new CatalogPage();

        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");
        homePage.header.search.clickSearchButton();

        Assert.assertTrue(catalogPage.topInfoIsDisplayed());
    }

    @Feature("Search")
    @Test
    public void whenCancelButtonOfSearchFieldClickedSearchFieldIsCleared() {
        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");

        homePage.header.search.clickCancelButton();

        Assert.assertTrue(homePage.header.search.searchFieldIsEmpty());
    }

    @Feature("Search")
    @Test
    public void whenSearchByEnterClickedSearchResultPageIsOpened() {
        CatalogPage catalogPage = new CatalogPage();

        homePage.header.search.clickSearchField();
        homePage.header.search.enterTextToSearchField("dress");
        homePage.header.search.submitSearch();

        Assert.assertTrue(catalogPage.topInfoIsDisplayed());
    }

    @Feature("Search")
    @Test
    public void whenSearchFieldClickedListWithHotWordsIsAppeared() {
        homePage.header.search.clickSearchField();

        Assert.assertTrue(homePage.header.search.searchContentListIsDisplayed());
        Assert.assertTrue(homePage.header.search.hotWordsTitleIsDisplayed());
        Assert.assertTrue(homePage.header.search.hotWordsItemsListIsDisplayed());
    }

    @Feature("Search")
    @Test
    public void whenRequestEnteredAssociationWordsAreDisplayed() {
        homePage.header.search.clickSearchField();

        homePage.header.search.enterTextToSearchField("pink jeans");

        Assert.assertTrue(homePage.header.search.listOfAssociationWordsIsDisplayed());
        Assert.assertTrue(homePage.header.search.associationWordsContainEnteredText("Pink Jeans"));
    }
}
