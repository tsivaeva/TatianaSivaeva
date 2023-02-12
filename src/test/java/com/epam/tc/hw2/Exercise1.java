package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
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

public class Exercise1 {

    WebDriver driver;

    @BeforeMethod
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        SoftAssertions softly = new SoftAssertions();
        driver.manage().window().maximize();

        //Step1 - Open test site by URL
        driver.navigate().to(TestData.URL);

        //Step2 - Assert Browser title
        softly.assertThat(driver.getTitle()).isEqualTo(TestData.MAIN_PAGE_TITLE);
        driver.findElement(By.cssSelector("li[class='dropdown uui-profile-menu'] a.dropdown-toggle")).click();

        //Step3 - Perform login
        driver.findElement(By.id("name")).sendKeys(TestData.NAME);
        driver.findElement(By.id("password")).sendKeys(TestData.PASSWORD);
        driver.findElement(By.id("login-button")).click();

        //Step4 - Perform  Assert Username is loggined
        String innerTextUserName = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))))
                .getAttribute("innerText");

        softly.assertThat(innerTextUserName).isEqualTo(TestData.TEXTUSER_NAME);

        //Step5 - Assert that there are 4 items on the header
        //section are displayed and they have proper
        //texts
        final List<String> outerTextNavbar = driver.findElements(By
                        .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li"))
                .stream()
                .map(elem -> elem.getAttribute("innerText"))
                .collect(Collectors.toList());
        softly.assertThat(outerTextNavbar.size()).isEqualTo(4);
        TestData.HEADER_ITEMS.forEach(text -> softly.assertThat(text).isIn(outerTextNavbar));

        //Step6 -  Assert that there are 4 images on the Index
        //        Page and they are displayed
        List<WebElement> childrenbenefitImage = driver.findElements(By
                .cssSelector("div[class='row clerafix benefits']>div"));
        softly.assertThat(childrenbenefitImage.size()).isEqualTo(4);

        //Step7 - Assert that there are 4 texts on the Index
        //Page under icons and they have proper text
        final List<String> outerTextBenefitImages = driver.findElements(By
                        .cssSelector("div[class='benefit']"))
                .stream()
                .map(elem -> elem.getAttribute("outerText"))
                .collect(Collectors.toList());
        softly.assertThat(TestData.BENEFIT_ITEMS).isEqualTo(outerTextBenefitImages);

        //Step8 - Assert that there is the iframe with “Frame
        //Button” exist
        driver.switchTo().frame(driver.findElement(By.id("frame")));

        //Step9 - Switch to the iframe and check that there is
        //“Frame Button” in the iframe
        softly.assertThat(driver.findElement(By.id("frame-button")).isDisplayed()).isTrue();

        //Step10 - Switch to original window back
        driver.switchTo().defaultContent();
        softly.assertThat(driver.getTitle()).isEqualTo((TestData.MAIN_PAGE_TITLE));

        //Step11 - Assert that there are 5 items in the Left
        //Section are displayed and they have proper
        //text
        WebElement sidebarMenuLeft = driver.findElement(By.cssSelector("ul[class='sidebar-menu left']"));
        String sidebarMenuLeftChild = sidebarMenuLeft.getAttribute("childElementCount");
        softly.assertThat(sidebarMenuLeftChild).isEqualTo("5");
        softly.assertAll();

        //Step11 -  Close Browser
        driver.close();
    }
}
