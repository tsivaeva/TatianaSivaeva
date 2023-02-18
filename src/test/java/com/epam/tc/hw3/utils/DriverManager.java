package com.epam.tc.hw3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public WebDriver setupDriver(String url) {
        setupChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.get(url);
        return webDriver;
    }

    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
