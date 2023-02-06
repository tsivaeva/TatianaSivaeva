package com.epam.tc.hw3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public WebDriver setupDriver(String url) {
        setupChromeDriver();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);
        return webDriver;
    }
    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
