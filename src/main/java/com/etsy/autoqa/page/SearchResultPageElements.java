package com.etsy.autoqa.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Auto QA team
 *
 */
public class SearchResultPageElements extends PageElements {

    @FindBy(xpath = "//div[@id='sortby']//button")
    public WebElement sortByFunctionDropdown;

    @FindBy(xpath = ".//h1[@class='display-inline text-smaller']")
    public WebElement searchedItem;
    
    @FindBy(css = "div.hide-lg:not([data-behat-search-results-ads-xl]):not(.prolist-row) p > span.currency-value, div.hide-lg:not([data-behat-search-results-ads-xl]):not(.prolist-row) p > span > span.currency-value")
    public List<WebElement> productPrice;
}
