package com.automation.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // ThreadLocal prevents driver clash in parallel execution
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // private constructor so no one can create object from outside
    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void initDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        } else if (browser.equalsIgnoreCase("headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            tlDriver.set(new ChromeDriver(options));
        }

        getDriver().manage().window().maximize();
    }


    public static void quitDriver() {
        if (tlDriver.get() != null) {
            getDriver().quit();
            tlDriver.remove();
        }
    }
}
