package com.etsy.autoqa.stepDefs;

import java.text.MessageFormat;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import com.etsy.autoqa.commons.ETSYAssertionMessages;
import com.etsy.autoqa.commons.Utilities;
import com.etsy.autoqa.commons.WebDriverCommons;
import com.etsy.autoqa.commons.WebDriverFactory;
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

    Utilities utils = new Utilities();

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

    @Given("^I am on ETSY home page$")
    public void iAmOnETSYHomePage() {

        homePage.acceptCookiePopUp();

        Assert.assertTrue(MessageFormat.format(ETSYAssertionMessages.PAGE_NOT_LOADED, "ETSY Home Page"), homePage.isPageLoaded());
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchForGiveItem(String searchItem) {
        homePage.enterSearchParameterInSearchInput(searchItem);

    }

    @Then("^I should see search result populate as per entered search criteria \"([^\"]*)\"$")
    public void iShouldSeeSearchResultPopulateAsPerEnteredSearchCriteria(String SearchItem) {
    }

    @When("^I select first result from auto suggest result$")
    public void iSelectFirstResultFromAutoSuggestResult() {
        homePage.selectFirstResultFromAutoSuggestion();
    }

    @Then("^I should see search result page for \"([^\"]*)\"$")
    public void iShouldSeeSearchResultPageForGivenSearchItem(String searchedItem) {
        Assert.assertTrue(MessageFormat.format(ETSYAssertionMessages.PAGE_NOT_LOADED, "Search result page"), searchResultPage.isPageLoaded());
        Assert.assertTrue("", webDriverCommons.getText(searchResultPage.getPageElements().searchedItem)
                                              .equalsIgnoreCase(searchedItem));
    }

    @When("^I select \"([^\"]*)\" from sort by dropdown$")
    public void iSelectGivenValueFromSortByDropdown(String valueToSelect) {
        webDriverCommons.click(searchResultPage.getPageElements().sortByFunctionDropdown);
    WebDriverFactory.getWebDriver().findElement(By.linkText(valueToSelect)).click();    
    }

    @Then("^I should see products display as per \"([^\"]*)\" sort by option$")
    public void iShouldSeeProductsDisplayAsPerGivenSortByOption(String valueTOSelect) {
    }

    @When("^I grab price for first ten product$")
    public void iGrabPriceForFirstTenProduct() {
        searchResultPage.getPriceFromGivenNumberOfItem(10);
    }

    @Then("^I should be able to print collected price from first ten product$")
    public void iShouldBeAbleToPrintCollectedPriceFromFirstTenProduct() {
        searchResultPage.printCollectedPriceAsPerGivenNUmber(10);
    }
}
