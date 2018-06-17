package com.etsy.autoqa.commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.etsy.autoqa.domain.browsers.Browser;
import com.etsy.autoqa.domain.browsers.FireFoxBrowser;

/**
 * 
 * @author Auto QA team
 *
 */
public final class WebDriverFactory {

    private static final Logger LOGGER = Logger.getLogger(WebDriverFactory.class);

    private static final String SESSION_NOT_REACHABLE_EXCEPTION_MESSAGE = "Not able to retrieve the web driver session";

    private static WebDriver webDriver;

    /**
     * 
     */
    private WebDriverFactory() {

    }

    /**
     * 
     * @param browser
     *            browser to open
     * @param url
     *            url to enter
     * @return WebDriver instance
     */
    public static WebDriver startBrowser(String browser, String url) {
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            LOGGER.info("starting local firefox...");
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            LOGGER.info("starting local chrome...");
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "src/main/resources/InternetExplorerDriver.exe");
            LOGGER.info("starting local IE...");
            webDriver = new InternetExplorerDriver();
        }

        webDriver.manage()
                 .window()
                 .maximize();

        webDriver.get(url);

        return webDriver;
    }

    /**
     * Checks if the session is active.
     * 
     * @return true if the session is active, false otherwise
     */
    private static boolean isSessionActive() {

        try {
            return webDriver.findElements(By.tagName("body"))
                            .size() > 0;

        } catch (Exception ex) {

            LOGGER.error(SESSION_NOT_REACHABLE_EXCEPTION_MESSAGE, ex);
            return false;
        }

    }

    /**
     * 
     * @param browser
     *            browser to open
     * @param url
     *            url to enter
     * @return WebDriver instance
     */
    public static WebDriver startRemoteWebBrowser(String browser, String URL) {

        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            LOGGER.info("starting local firefox...");
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            LOGGER.info("starting local chrome...");
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "src/main/resources/InternetExplorerDriver.exe");
            LOGGER.info("starting local IE...");
            webDriver = new InternetExplorerDriver();
        }

        webDriver.manage()
                 .window()
                 .maximize();

        webDriver.get(URL);

        return webDriver;
    }

    /**
     * @return the webDriver
     */
    public static WebDriver getWebDriver() {

        return webDriver;
    }

    /**
     * Shut down the WebDriver.
     * 
     */
    public static void quitWebDriver() {

        if (webDriver != null) {

            webDriver.quit();

        }
    }
}
