package com.epam.tc.hw3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public WebDriver setupDriver(String url) {
        setupChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.get(url);
        return webDriver;
    }

    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
