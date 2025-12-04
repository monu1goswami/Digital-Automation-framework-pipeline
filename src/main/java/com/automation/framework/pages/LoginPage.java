package com.automation.framework.pages;

import com.automation.framework.base.BasePage;
import com.automation.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginPage extends BasePage {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);


    public LoginPage() {
        super(DriverFactory.getDriver());
        this.driver = DriverFactory.getDriver();
    }

    // Locators
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button.radius")
    private WebElement loginButton;

    // Actions
    public void enterUsername(String username) {
    	logger.info("Entering username: " + username);
        type(usernameField, username);
    }

    public void enterPassword(String password) {
    	logger.info("Entering password");
        type(passwordField, password);
    }

    public void clickLoginButton() {
    	  logger.info("Clicking login button");
        click(loginButton);
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
    }
}
