package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPageHW5 {
    public WebDriver webDriver;

    public MainPageHW5(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
