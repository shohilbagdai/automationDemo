package com.etsy.autoqa;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * s
 * 
 * @author Auto QA Team
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html.report", "json:target/json.report" }, tags = {
        "@test" }, features = "src/test/resources/feature", dryRun = false, monochrome = true, strict = true)

public class CucumberRunner {
}
