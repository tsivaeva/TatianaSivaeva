package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise2 {
    WebDriver driver1;

    @BeforeMethod
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setup() {
        driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    void teardown() {
        driver1.quit();
    }

    @Test
    void test() {
        SoftAssertions softly = new SoftAssertions();
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        driver1.manage().window().maximize();
        driver1.navigate().to(url);
        softly.assertThat(driver1.getTitle()).isEqualTo("Home Page");
        WebElement dropdownMenu = driver1.findElement(By
                .cssSelector("li[class='dropdown uui-profile-menu'] a.dropdown-toggle"));
        dropdownMenu.click();
        WebElement clickNameField = driver1.findElement(By.id("name"));
        clickNameField.click();
        clickNameField.sendKeys("Roman");
        WebElement clickPasswordField = driver1.findElement(By.id("password"));
        clickPasswordField.click();
        clickPasswordField.sendKeys("Jdi1234");
        WebElement elementEntere = driver1.findElement(By.id("login-button"));
        elementEntere.click();
        WebElement userName = (new WebDriverWait(driver1, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))));
        String innerTextUserName = userName.getAttribute("innerText");
        String expectedTextUserName = "ROMAN IOVLEV";
        softly.assertThat(innerTextUserName).isEqualTo(expectedTextUserName);

        WebElement buttonService = driver1.findElement(By
                .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8'] span[class='caret']"));
        buttonService.click();
        WebElement menuDifferentElements = driver1.findElement(By
                .xpath("/html/body/header/div/nav/ul[1]/li[3]/ul/li[8]"));
        //or change to "ul[class='dropdown-menu']>li"
        menuDifferentElements.click();
        List<WebElement> checkboxRadioButtonInput = driver1.findElements(By
                .cssSelector("div[class='checkbox-row']>label input"));
        WebElement checkboxeWater = checkboxRadioButtonInput.get(0);
        checkboxeWater.click();
        softly.assertThat(checkboxeWater.isSelected()).isEqualTo(true);
        WebElement checkboxeWind = checkboxRadioButtonInput.get(3);
        checkboxeWind.click();
        softly.assertThat(checkboxeWind.isSelected()).isEqualTo(true);
        ;
        WebElement radioSelen = checkboxRadioButtonInput.get(7);
        radioSelen.click();
        softly.assertThat(radioSelen.isSelected()).isEqualTo(true);

        List<WebElement> dropdownColors = driver1.findElements(By.cssSelector("div[class='colors'] option"));
        dropdownColors.get(3).click();
        WebElement colorsSelected = driver1.findElement(By.cssSelector("div[class='colors'] select"));
        String expectedColorsSelected = "Yellow";
        softly.assertThat(colorsSelected.getAttribute("value")).isEqualTo(expectedColorsSelected);

        List<WebElement> listLogs = driver1.findElements(By.cssSelector("ul[class='panel-body-list logs'] li"));
        String waterLog = listLogs.get(3).getAttribute("outerText");
        softly.assertThat(waterLog).contains("Water", "true");
        String selenLog = listLogs.get(1).getAttribute("outerText");
        softly.assertThat(selenLog).contains("Selen");
        String coloreLog = listLogs.get(0).getAttribute("outerText");
        softly.assertThat(coloreLog).contains("Yellow");
        softly.assertAll();
        driver1.close();
    }
}
