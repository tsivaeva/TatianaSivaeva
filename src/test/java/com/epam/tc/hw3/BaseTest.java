package com.epam.tc.hw3;

import com.epam.tc.hw3.utils.DriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver webDriver;
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static String USER_LOGIN = null;
    protected static String USER_PASSWORD = null;
    protected static final String USER_NAME = "ROMAN IOVLEV";

    @BeforeClass
    public static void preparetoTest() {
        webDriver = new DriverManager().setupDriver(URL);
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
