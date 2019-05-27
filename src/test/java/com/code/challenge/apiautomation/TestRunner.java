package com.code.challenge.apiautomation;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This class helps to run the cucumber Gherkin files
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src//test//resources//" }, 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/TestStatus/ExtentReport.html"}, 
		glue = "com.code.challenge.apiautomation", 
		monochrome = true
		)

public class TestRunner {

	@AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        //Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
        Reporter.setSystemInfo("Test User", "Sudharsan");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("API Automation", "Code Challenge");
        Reporter.setSystemInfo("Build version", "v1");
        Reporter.setTestRunnerOutput("Cucumber reporting using Extent Config");
    }
}
