package com.epam.tc.hw4.tests;

import com.epam.tc.hw3.utils.DriverManager;
import com.epam.tc.hw4.utils.ActionStep;
import com.epam.tc.hw4.utils.AssertStep;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    public static WebDriver webDriver;
    protected ActionStep actionStep;
    protected AssertStep assertStep;
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static String USER_LOGIN = null;
    protected static String USER_PASSWORD = null;
    protected static final String USER_NAME = "ROMAN IOVLEV";

    @BeforeClass
    public void preparetoTest(ITestContext testContext) {
        webDriver = new DriverManager().setupDriver(URL);
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\"" +
                ",\"--disable-extensions\",\"disable-infobars\",\"--disable-gpu\"");
        testContext.setAttribute("driver", webDriver);
        actionStep = new ActionStep(webDriver);
        assertStep = new AssertStep(webDriver);
    }

    @BeforeClass
    public void readProperties() {
        try (InputStream input = new FileInputStream(
                "/home/tatiana_sivaeva/IdeaProjects/TatianaSivaeva/src/test/resources/config.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            USER_LOGIN = prop.getProperty("USER_LOGIN");
            USER_PASSWORD = prop.getProperty("USER_PASSWORD");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
