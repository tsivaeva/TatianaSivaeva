package com.epam.tc.hw5.utils;

import com.epam.tc.hw5.pages.HomePageHW5;
import com.epam.tc.hw5.pages.LoginPageHW5;
import com.epam.tc.hw5.pages.OthersElementsPageHW5;
import com.epam.tc.hw5.pages.UserTablePageHW5;
import org.openqa.selenium.WebDriver;

public class PageObjectInitializationHW5 {
    protected WebDriver webDriver;

    protected OthersElementsPageHW5 othersElementsPageHW5;
    protected HomePageHW5 homePage;
    protected LoginPageHW5 loginPage;
    protected UserTablePageHW5 userTable;

    public PageObjectInitializationHW5() {
        webDriver = new DriverManagerUtils().setupDriver();

        othersElementsPageHW5 = new OthersElementsPageHW5(webDriver);
        homePage = new HomePageHW5(webDriver);
        loginPage = new LoginPageHW5(webDriver);
        userTable = new UserTablePageHW5(webDriver);
    }
}
