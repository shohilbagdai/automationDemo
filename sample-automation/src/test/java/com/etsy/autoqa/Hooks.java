package com.etsy.autoqa;

import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.etsy.autoqa.commons.AutomationConstants;
import com.etsy.autoqa.commons.WebDriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * @author AutoQA Demo
 *
 */
public class Hooks {

    /**
     * Before each feature scenario starts the WebDriver.
     * 
     */
    @Before(order = 1)
    public void start() {

        WebDriverFactory.startBrowser(AutomationConstants.BROWSER, AutomationConstants.BASE_URL);

    }

    /**
     * After each feature scenario shuts down the WebDriver and take screen shot if scenario fails.
     * 
     * @param scenario
     *            scenario
     */
    @After
    public void closeBrowser(final Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        // WebDriverFactory.quitWebDriver();
    }
}
