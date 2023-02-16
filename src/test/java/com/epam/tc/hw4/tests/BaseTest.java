package com.epam.tc.hw4.tests;

import com.epam.tc.hw3.utils.DriverManager;
import com.epam.tc.hw4.utils.ActionStep;
import com.epam.tc.hw4.utils.AssertStep;
import com.epam.tc.hw6.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    public static WebDriver webDriver;
    protected ActionStep actionStep;
    protected AssertStep assertStep;
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String USER_LOGIN = "Roman";
    protected static final String USER_PASSWORD = "Jdi1234";
    protected static final String USER_NAME = "ROMAN IOVLEV";

    @BeforeClass
    @Parameters({"isLocal", "hub", "browser"})
    public void prepareToTest(ITestContext testContext,
                              @Optional("false") final boolean isLocal, final String hub, final String browser) {
        webDriver = DriverFactory.getWebDriver(isLocal, hub, browser);
        testContext.setAttribute("driver", webDriver);
        webDriver.manage().window().maximize();
        webDriver.get(URL);
//        actionSteps = new ActionSteps(webDriver);
//        assertSteps = new AssertSteps(webDriver);
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
