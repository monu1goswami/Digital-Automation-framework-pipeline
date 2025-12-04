package com.automation.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.automation.framework.utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BasePage.class);


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        WaitUtils.waitForClickable(element);
        element.click();
        logger.info("Clicked on element: " + element);
    }

    protected void type(WebElement element, String value) {
        WaitUtils.waitForVisible(element);
        element.clear();
        element.sendKeys(value);
        logger.info("Typing text: " + value);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }
}
