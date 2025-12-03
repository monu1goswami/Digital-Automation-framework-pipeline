package com.automation.framework.pages;

import com.automation.framework.base.BasePage;
import com.automation.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    private WebDriver driver;

    public DashboardPage() {
        super(DriverFactory.getDriver());
        this.driver = DriverFactory.getDriver();
    }

    @FindBy(css = "div.flash.success")
    private WebElement successMessage;

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}
