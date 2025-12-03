package com.automation.framework.tests.stepdefinitions;

import com.automation.framework.config.ConfigReader;
import com.automation.framework.driver.DriverFactory;
import com.automation.framework.pages.DashboardPage;
import com.automation.framework.pages.LoginPage;
import com.automation.framework.utils.AssertionsUtil;

import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("I open the login page")
    public void i_open_the_login_page() {
    	 DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @When("I login using username {string} and password {string}")
    public void i_login_using_username_and_password(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("I should be navigated to the dashboard")
    public void i_should_be_navigated_to_the_dashboard() {
        DashboardPage dashboardPage = new DashboardPage();
        String message = dashboardPage.getSuccessMessage();
        AssertionsUtil.assertTextContains(message, "You logged into a secure area!");
    }
}
