package com.epam.tc;

import com.epam.tc.hw3.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestDatahw3 {
    public static WebDriver webDriver;
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String USER_LOGIN = "Roman";
    protected static final String USER_PASSWORD = "Jdi1234";
    protected static final String USER_NAME = "ROMAN IOVLEV";

    @BeforeClass
    public static void preparetoTest() {
        webDriver = new DriverManager().setupDriver(URL);
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
