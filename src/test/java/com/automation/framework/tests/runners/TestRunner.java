package com.automation.framework.tests.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "com.automation.framework.tests.stepdefinitions",
                "com.automation.framework.tests.hooks"
        },
        tags = "@smoke",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	  @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
