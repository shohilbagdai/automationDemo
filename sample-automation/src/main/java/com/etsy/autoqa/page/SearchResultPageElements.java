package com.etsy.autoqa.page;

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
}
