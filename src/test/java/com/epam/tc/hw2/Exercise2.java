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
import org.openqa.selenium.support.ui.Select;
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

        //Step1 - Open test site by URL
        driver1.navigate().to(url);

        //Step2 - Assert Browser title
        softly.assertThat(driver1.getTitle()).isEqualTo("Home Page");

        //Step3 - Perform login
        WebElement dropdownMenu = driver1.findElement(By
                .cssSelector("li[class='dropdown uui-profile-menu'] a.dropdown-toggle"));
        dropdownMenu.click();
        driver1.findElement(By.id("name")).sendKeys("Roman");
        driver1.findElement(By.id("password")).sendKeys("Jdi1234");
        driver1.findElement(By.id("login-button")).click();

        WebElement userName = (new WebDriverWait(driver1, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))));

        //Step4 - Assert User name in the left-top side of screen that
        //user is loggined
        softly.assertThat(userName.getAttribute("innerText")).isEqualTo("ROMAN IOVLEV");

        //Step5 - Open through the header menu Service -> Different
        //Elements Page
        driver1.findElement(By
                .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8'] span[class='caret']")).click();

        WebElement menuDifferentElements = driver1.findElement(By
                .xpath("//li[@class='dropdown open']//a[text()='Different elements']"));

        //or change to "ul[class='dropdown-menu']>li"
        //li[@class='dropdown open']//a[text()='Different elements']
        menuDifferentElements.click();

        //Step6  - Select checkboxes
        List<WebElement> checkboxRadioButtonInput = driver1.findElements(By
                .cssSelector("div[class='checkbox-row']>label input"));

        WebElement checkboxeWater = checkboxRadioButtonInput.get(0);
        driver1.findElement(By.xpath("//label[contains(., 'Water')]")).click();
        softly.assertThat(checkboxeWater.isSelected()).isEqualTo(true);

        WebElement checkboxeWind = checkboxRadioButtonInput.get(2);
        driver1.findElement(By.xpath("//label[contains(., 'Wind')]")).click();
        softly.assertThat(checkboxeWind.isSelected()).isEqualTo(true);


        //Step7  - Select radio
        WebElement radioSelen = checkboxRadioButtonInput.get(7);
        driver1.findElement(By.xpath("//label[contains(., 'Selen')]")).click();
        softly.assertThat(radioSelen.isSelected()).isEqualTo(true);

        //Step8  - Select in dropdown
        Select drpColors = new Select(driver1.findElement(By.cssSelector("div[class='colors'] select")));
        drpColors.selectByVisibleText("Yellow");
        WebElement colorsSelected = driver1.findElement(By.cssSelector("div[class='colors'] select"));
        softly.assertThat(colorsSelected.getAttribute("value")).isEqualTo("Yellow");

        //Step9 - Assert that
        //• for each checkbox there is an individual log
        //row and value is corresponded to the status
        //of checkbox
        //• for radio button there is a log row and value
        //is corresponded to the status of radio button
        //• for dropdown there is a log row and value is
        //corresponded to the selected value.
        List<WebElement> listLogs = driver1.findElements(By.cssSelector("ul[class='panel-body-list logs'] li"));
        String waterLog = listLogs.get(3).getAttribute("outerText");
        softly.assertThat(waterLog).contains("Water", "true");
        String selenLog = listLogs.get(1).getAttribute("outerText");
        softly.assertThat(selenLog).contains("Selen");
        String coloreLog = listLogs.get(0).getAttribute("outerText");
        softly.assertThat(coloreLog).contains("Yellow");
        softly.assertAll();

        //Step10 - Close Browser
        driver1.close();
    }
}
