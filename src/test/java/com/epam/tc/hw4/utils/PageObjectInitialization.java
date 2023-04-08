package com.epam.tc.hw4.utils;

import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import com.epam.tc.hw3.pages.OthersElementsPage;
import org.openqa.selenium.WebDriver;

public class PageObjectInitialization {
    protected OthersElementsPage othersElementsPage;
    protected HomePage homePage;
    protected LoginPage loginPage;

    protected PageObjectInitialization(WebDriver webDriver) {
        othersElementsPage = new OthersElementsPage(webDriver);
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
    }
}
