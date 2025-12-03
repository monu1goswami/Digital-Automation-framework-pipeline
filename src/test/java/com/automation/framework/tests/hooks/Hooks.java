package com.automation.framework.tests.hooks;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.framework.config.ConfigReader;
import com.automation.framework.driver.DriverFactory;
import com.automation.framework.utils.ScreenshotUtil;

import com.aventstack.extentreports.*;
import com.automation.framework.utils.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static ExtentReports extent;
	private static ExtentTest test;

	@Before
	public void launchBrowser(Scenario scenario) {
	    extent = ReportManager.getReporter();
	    test = extent.createTest(scenario.getName());

	    String browser = System.getProperty("browser", ConfigReader.get("browser"));
	    DriverFactory.initDriver(browser);
	}

	@After
	public void tearDown(Scenario scenario) {

	    if (scenario.isFailed()) {
	        String screenshot = ScreenshotUtil.captureScreenshot(scenario.getName());
	        test.fail("Failed").addScreenCaptureFromPath(screenshot);
	    } else {
	        test.pass("Passed");
	    }

	    DriverFactory.quitDriver();
	    extent.flush();
	}
}
