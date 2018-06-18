package com.etsy.autoqa.stepDefs;

import java.text.MessageFormat;
import org.junit.Assert;
import org.junit.runner.RunWith;
import com.etsy.autoqa.commons.ETSYAssertionMessages;
import com.etsy.autoqa.commons.WebDriverCommons;
import com.etsy.autoqa.page.HomePage;
import com.etsy.autoqa.page.SearchResultPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author Auto QA team
 *
 */
@RunWith(Cucumber.class)
public class SearchFunctionStepDefs {

    WebDriverCommons webDriverCommons = new WebDriverCommons();

    HomePage homePage = new HomePage();

    SearchResultPage searchResultPage = new SearchResultPage();

    /**
     * Before method.
     */
    @Before
    public void init() {
        homePage.init();
        searchResultPage.init();
    }

    /**
     * 
     */
    @Given("^I am on ETSY home page$")
    public void iAmOnETSYHomePage() {

        homePage.acceptCookiePopUp();

        Assert.assertTrue(MessageFormat.format(ETSYAssertionMessages.PAGE_NOT_LOADED, ETSYAssertionMessages.ETSY_HOME_PAGE), homePage.isPageLoaded());
    }

    /**
     * 
     * @param searchItem
     *            item to search
     */
    @When("^I search for \"([^\"]*)\"$")
    public void iSearchForGiveItem(String searchItem) {
        homePage.enterSearchParameterInSearchInput(searchItem);

    }

    /**
     * 
     */
    @When("^I select first result from auto suggest result$")
    public void iSelectFirstResultFromAutoSuggestResult() {
        homePage.selectFirstResultFromAutoSuggestion();
    }

    /**
     * 
     * @param searchedItem
     *            searched item
     */
    @Then("^I should see search result page for \"([^\"]*)\"$")
    public void iShouldSeeSearchResultPageForGivenSearchItem(String searchedItem) {
        Assert.assertTrue(MessageFormat.format(ETSYAssertionMessages.PAGE_NOT_LOADED, ETSYAssertionMessages.SEARCH_RESULT_PAGE),
                searchResultPage.isPageLoaded());
        Assert.assertTrue("", webDriverCommons.getText(searchResultPage.getPageElements().searchedItem)
                                                     .equalsIgnoreCase(searchedItem));
    }

    /**
     * 
     * @param valueToSelect
     *            value to select from sort by drop down
     */
    @When("^I select \"([^\"]*)\" option from sort by dropdown$")
    public void iSelectGivenOptionFromSortByDropdown(String valueToSelect) {
        searchResultPage.selectGivenOptionFromDropdown(valueToSelect);
    }

    /**
     * 
     */
    @When("^I collect price for first ten product$")
    public void iCollectPriceForFirstTenProduct() {
        searchResultPage.getPriceFromGivenNumberOfItem(10);
    }

    /**
     * 
     */
    @Then("^I should be able to print collected price from first ten product$")
    public void iShouldBeAbleToPrintCollectedPriceFromFirstTenProduct() {
        searchResultPage.printCollectedPriceAsPerGivenNUmber(10);
    }
}
