package com.automation.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        WaitUtils.waitForClickable(element);
        element.click();
    }

    protected void type(WebElement element, String value) {
        WaitUtils.waitForVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }
}
