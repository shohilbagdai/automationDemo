package com.etsy.autoqa.page;

import org.openqa.selenium.support.PageFactory;

import com.etsy.autoqa.commons.WebDriverFactory;

/**
 * 
 * @author STA Development Team
 *
 * @param <T>
 *            Page Elements class
 */
public abstract class Page<T extends PageElements> {

    /**
     * Checks if page has been loaded.
     * 
     * @return true in case of page has been loaded, false otherwise
     */
    public abstract boolean isPageLoaded();

    /**
     * Initialise the child Page class.
     */
    public abstract void init();

    /**
     * Initialise page elements.
     * 
     * @param page
     *            to initialise elements
     */
    protected void initialiseElements(final T page) {

        PageFactory.initElements(WebDriverFactory.getWebDriver(), page);
    }

    /**
     * Get Page Elements.
     * 
     * @return instance of Page Elements
     */
    public abstract T getPageElements();

}
