package com.etsy.autoqa.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.etsy.autoqa.commons.WebDriverCommons;
import com.etsy.autoqa.commons.WebDriverFactory;

/**
 * 
 * @author Auto QA team
 *
 */
public class SearchResultPage extends Page<SearchResultPageElements> {

    WebDriverCommons webDriverCommons = new WebDriverCommons();

    SearchResultPageElements searchResultPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(searchResultPageElements.sortByFunctionDropdown);
    }

    /**
     * 
     */
    @Override
    public void init() {
        searchResultPageElements = new SearchResultPageElements();
        super.initialiseElements(searchResultPageElements);

    }

    /**
     * 
     */
    @Override
    public SearchResultPageElements getPageElements() {

        return searchResultPageElements;
    }

    /**
     * Get price from given number of items.
     * 
     * @param numberOfItem
     */
    public List<String> getPriceFromGivenNumberOfItem(int numberOfItem) {
        List<WebElement> totalItems = searchResultPageElements.productPrice;
        List<String> price = new ArrayList<String>();
        for (int i = 0; i < numberOfItem; i++) {
            price.add(totalItems.get(i)
                                .getText());
        }
        return price;
    }

    /**
     * Print given number of collected price on Console.
     */
    public void printCollectedPriceAsPerGivenNUmber(int numberOfItem) {
        List<String> priceToPrint = getPriceFromGivenNumberOfItem(numberOfItem);

        System.out.println("Prices for top ten products are as below :");

        for (int i = 1; i <= numberOfItem; i++) {
            System.out.println("Price for item " + i + " is = " + priceToPrint.get(i - 1));
        }

    }

    /**
     * Click on given value from drop down
     * 
     * @param valueToSelect
     *            value to select from drop down
     */
    public void selectGivenOptionFromDropdown(String valueToSelect) {
        webDriverCommons.click(searchResultPageElements.sortByFunctionDropdown);

        WebDriverFactory.getWebDriver()
                        .findElement(By.linkText(valueToSelect))
                        .click();

    }

}
