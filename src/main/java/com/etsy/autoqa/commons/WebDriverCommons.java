package com.etsy.autoqa.commons;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Auto QA team
 *
 */
public class WebDriverCommons {

    private static final Logger LOGGER = Logger.getLogger(WebDriverCommons.class);

    private static final int WEBDRIVER_PAUSE_TIME = 60;

    public static final int TIMEOUT_FOR_HIGHLIGHT_ELEMENT = 100;

    public static final String FAILED_TO_DISPLAY_ELEMENT_MESSAGE = "Failed to display element";

    public static final String FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE = "Failed to enter given value to given element";

    public static final String FAILED_TO_CLICK_ON_GIVEN_ELEMENT_MESSAGE = "Failed to click on given element";

    public static final String FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE = "Failed to highlight element for given time";

    /**
     * Pauses the WebDriver process for a specific time.
     * 
     * @param element
     *            element to wait for
     */
    public void waitForElementToBeVisible(final WebElement element) {

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), WEBDRIVER_PAUSE_TIME);

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Highlight element with yellow colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementYellowColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid yellow;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Highlight element with red colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementWithRedColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Highlight element with blue colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementWithBlueColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid blue;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Scrolls the driver to the element given.
     * 
     * @param element
     *            element to scroll to
     */
    public void scrollTo(final WebElement element) {

        waitForElementToBeVisible(element);

        JavascriptExecutor jse = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        jse.executeScript("arguments[0].scrollIntoView();", element);

    }

    /**
     * to check is element displayed or not by by.
     * 
     * @param by
     *            by
     * @return true if element display else false
     */
    public boolean isDisplayed(final By by) {

        try {

            return WebDriverFactory.getWebDriver()
                                   .findElement(by)
                                   .isDisplayed();

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_DISPLAY_ELEMENT_MESSAGE, by), nsee);
            return false;

        }
    }

    /**
     * to check is element displayed or not by element.
     * 
     * @param element
     *            element
     * @return true if element display else false
     */
    public boolean isDisplayed(final WebElement element) {
        scrollTo(element);

        try {

            getHighlightElementWithRedColour(element);
            return element.isDisplayed();

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_DISPLAY_ELEMENT_MESSAGE, element), nsee);
            return false;
        }
    }

    /**
     * click on given element.
     * 
     * @param element
     *            element
     */
    public void click(final WebElement element) {

        try {

            scrollTo(element);
            getHighlightElementWithBlueColour(element);
            element.click();

        } catch (Exception e) {
            LOGGER.info(MessageFormat.format(FAILED_TO_CLICK_ON_GIVEN_ELEMENT_MESSAGE, element), e);
        }
    }

    /**
     * enter value to given element.
     * 
     * @param element
     *            element
     * @param value
     *            value
     */
    public void sendKeys(final WebElement element, final String value) {

        try {

            scrollTo(element);
            element.sendKeys(value);

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE, element), nsee);
        }
    }

    /**
     * Switch to given window.
     * 
     * @param windowToSwitch
     *            window to switch
     */
    public void switchToWindow(String windowToSwitch) {
        WebDriverFactory.getWebDriver()
                        .switchTo()
                        .window(windowToSwitch);

    }
    
    /**
     * 
     * @param element
     *            element
     * @return text as string from given element otherwise null if no text found;
     */
    public String getText(final WebElement element) {

        try {
            scrollTo(element);
            getHighlightElementYellowColour(element);
            return element.getText()
                          .trim();
        } catch (NoSuchElementException nsee) {

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());

        }
        return null;
    }


}
