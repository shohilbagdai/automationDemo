package com.etsy.autoqa.page;

import com.etsy.autoqa.commons.WebDriverCommons;

/**
 * 
 * @author Auto QA team
 *
 */
public class HomePage extends Page<HomePageElements> {

    WebDriverCommons webDriverCommons = new WebDriverCommons();

    HomePageElements homePageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {
        return webDriverCommons.isDisplayed(homePageElements.singInButton);
    }

    /**
     * 
     */
    @Override
    public void init() {
        homePageElements = new HomePageElements();
        super.initialiseElements(homePageElements);

    }

    /**
     * 
     */
    @Override
    public HomePageElements getPageElements() {
        return homePageElements;
    }

    /***
     * 
     * @param searchItem
     *            item to search for
     */
    public void enterSearchParameterInSearchInput(String searchItem) {
        webDriverCommons.sendKeys(homePageElements.searchInput, searchItem);
    }

    /**
     * Accept cookie pop up on Home page.
     */
    public void acceptCookiePopUp() {

        if (webDriverCommons.isDisplayed(homePageElements.acceptButtonOnCookiePopup)) {
            webDriverCommons.click(homePageElements.acceptButtonOnCookiePopup);
        }

    }

    /**
     * First item to select from search result.
     */
    public void selectFirstResultFromAutoSuggestion() {
        webDriverCommons.click(homePageElements.firstItemFromSearchSuggection);

    }
}
