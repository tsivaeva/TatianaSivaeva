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
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        driver.manage().window().maximize();

        //Step1 - Open test site by URL
        driver.navigate().to(url);

        //Step2 - Assert Browser title
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");
        driver.findElement(By.cssSelector("li[class='dropdown uui-profile-menu'] a.dropdown-toggle")).click();

        //Step3 - Perform login
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        WebElement userName = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))));
        String innerTextUserName = userName.getAttribute("innerText");
        String expectedTextUserName = "ROMAN IOVLEV";

        //Step4 - Perform  Assert Username is loggined
        softly.assertThat(innerTextUserName).isEqualTo(expectedTextUserName);


        String childrenNavbar = driver.findElement(By
                .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']")).getAttribute("childElementCount");
        String expectedChildrenNavbar = "4";

        //Step5 - Assert that there are 4 items on the header
        //section are displayed and they have proper
        //texts
        softly.assertThat(childrenNavbar).isEqualTo(expectedChildrenNavbar);
        WebElement navbarChild1 = driver.findElement(By
                .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li:nth-child(1)"));
        String navbarChild1Name = navbarChild1.getAttribute("innerText");
        String expectedNavbarChild1Name = "HOME";
        softly.assertThat(navbarChild1Name).isEqualTo(expectedNavbarChild1Name);
        WebElement navbarChild2 = driver.findElement(By
                .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li:nth-child(2)"));
        String navbarChild2Name = navbarChild2.getAttribute("innerText");
        String expectedNavbarChild2Name = "CONTACT FORM";
        softly.assertThat(navbarChild2Name).isEqualTo(expectedNavbarChild2Name);
        WebElement navbarChild3 = driver.findElement(By
                .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li:nth-child(3)"));
        String navbarChild3Name = navbarChild3.getAttribute("innerText");
        String expectedNavbarChild3Name = "SERVICE ";
        softly.assertThat(navbarChild3Name).isEqualTo(expectedNavbarChild3Name);
        WebElement navbarChild4 = driver.findElement(By
                .cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li:nth-child(4)"));
        String navbarChild4Name = navbarChild4.getAttribute("innerText");
        String expectedNavbarChild4Name = "METALS & COLORS";
        softly.assertThat(navbarChild4Name).isEqualTo(expectedNavbarChild4Name);

        //Step6 -  Assert that there are 4 images on the Index
        //        Page and they are displayed
        String childrenbenefitImage = driver.findElement(By
                .cssSelector("div[class='row clerafix benefits']")).getAttribute("childElementCount");
        softly.assertThat(childrenbenefitImage).isEqualTo("4");

        //Step7 - Assert that there are 4 texts on the Index
        //Page under icons and they have proper text
        List<WebElement> benefitImages = driver.findElements(By
                .cssSelector("div[class='benefit']"));
        String benefitImage0 = benefitImages.get(0).getAttribute("outerText");
        String expectedbenefitImage0 = "To include good practices\nand ideas from successful\nEPAM project";
        softly.assertThat(benefitImage0).isEqualTo(expectedbenefitImage0);
        String benefitImage1 = benefitImages.get(1).getAttribute("outerText");
        String expectedbenefitImage1 = "To be flexible and\ncustomizable";
        softly.assertThat(benefitImage1).isEqualTo(expectedbenefitImage1);
        String benefitImage2 = benefitImages.get(2).getAttribute("outerText");
        String expectedbenefitImage2 = "To be multiplatform";
        softly.assertThat(benefitImage2).isEqualTo(expectedbenefitImage2);
        String benefitImage3 = benefitImages.get(3).getAttribute("outerText");
        String expectedbenefitImage3 =
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";
        softly.assertThat(benefitImage3).isEqualTo(expectedbenefitImage3);

        //Step8 - Assert that there is the iframe with “Frame
        //Button” exist
        driver.switchTo().frame(driver.findElement(By.id("frame")));

        //Step9 - Switch to the iframe and check that there is
        //“Frame Button” in the iframe
        softly.assertThat(driver.findElement(By.id("frame-button")).isDisplayed()).isTrue();

        //Step10 - Switch to original window back
        driver.switchTo().defaultContent();
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");

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
