package com.etsy.autoqa.domain.browsers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * @author Created by STA Automation QA Team
 *
 */
public class ChromeBrowser extends Browser {

    private static final String NAME = "Chrome";
    private static DesiredCapabilities capabilities;

    static {
        capabilities = new DesiredCapabilities();

        capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setVersion("54");
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("acceptSslCerts", true);
        capabilities.setCapability("rotatable", false);
        capabilities.setCapability("locationContextEnabled", true);
        capabilities.setCapability("cssSelectorsEnabled", true);
        capabilities.setCapability("databaseEnabled", true);
        capabilities.setCapability("handlesAlerts", true);
        capabilities.setCapability("nativeEvents", false);
        capabilities.setCapability("webStorageEnabled", true);
        capabilities.setCapability("applicationCacheEnabled", true);
        capabilities.setCapability("takesScreenshot", true);
    }

    /**
     * 
     */
    public ChromeBrowser() {

        super(NAME, capabilities);

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
