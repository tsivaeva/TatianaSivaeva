package com.epam.tc.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getWebDriver(final boolean isLocal, final String hub, @NonNull final String browser) {

        WebDriver webDriver;
        switch (browser.toUpperCase(Locale.ROOT)) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "CHROME":
            default:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }
        return webDriver;
    }
}
