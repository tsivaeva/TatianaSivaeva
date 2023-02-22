package com.epam.tc.hw3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public WebDriver setupDriver(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.get(url);
        return webDriver;
    }

    public WebDriver setupDriverChromium(String url) {
        System.setProperty("webdriver.chrome.driver", "/snap/bin/chromium");
        ChromeOptions options = new ChromeOptions().setBinary("/snap/bin/chromium");
        options.addArguments("--remote-debugging-port=9225"); //"--remote-debugging-port=9225"
        options.addArguments("--no-sandbox"); // Bypass OS security model
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.get(url);
        return webDriver;
    }

    private void setupChromeDriver() {
        WebDriverManager.chromiumdriver().setup();
    }
}
