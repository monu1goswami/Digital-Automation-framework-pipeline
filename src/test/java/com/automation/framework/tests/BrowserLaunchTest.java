package com.automation.framework.tests;

import com.automation.framework.driver.DriverFactory;
import com.automation.framework.pages.LoginPage;
import org.testng.annotations.Test;

public class BrowserLaunchTest {

    @Test
    public void testLogin() {
       
        DriverFactory.getDriver().get("https://www.google.com");

        LoginPage lp = new LoginPage();
        lp.login("admin", "admin123");

      
    }
}
