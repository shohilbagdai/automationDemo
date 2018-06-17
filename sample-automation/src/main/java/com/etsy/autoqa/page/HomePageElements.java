package com.etsy.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Auto QA team
 *
 */
public class HomePageElements extends PageElements{

    @FindBy(id = "sign-in")
    public WebElement singInButton;
    
    @FindBy(id = "search-query")
    public WebElement searchInput;

    @FindBy(xpath = "/html//div[@id='search-suggestions']/ul/li[1]/div/div/div[1]/span")
    public WebElement firstItemFromSearchSuggection;
    
    @FindBy(xpath = ".//button[contains(text(),'Accept')]")
    public WebElement acceptButtonOnCookiePopup;
}
