package com.epam.tc.hw3.scripts;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Exercise1hw3 extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    SoftAssertions softly = new SoftAssertions();

    //Step2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
    }

    //Step3 Perform login
    //Step4 Assert Username is loggined
    @Test(priority = 2)
    public void testLogin() {
        new LoginPage(webDriver)
                .clickUserIcon().setUserName(USER_LOGIN).setUserPassword(USER_PASSWORD).clickLoginButton();
        softly.assertThat(new LoginPage(webDriver).getUserName().getText()).isEqualTo(USER_NAME);
        softly.assertAll();
    }

    //Step5 Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 3)
    public void testHeaders() {
        homePage = new HomePage(webDriver);
        softly.assertThat(homePage.getHeaderMenuComponent().getNavigationBarHeaderElement()
                .size()).isEqualTo(4);
        softly.assertThat(homePage.getHeaderMenuComponent().getHomeHeaderElement().isDisplayed()).isTrue();
        softly.assertThat(homePage.getHeaderMenuComponent().getContactFormHeaderElement().isDisplayed()).isTrue();
        softly.assertThat(homePage.getHeaderMenuComponent().getServiceHeaderElement().isDisplayed()).isTrue();
        softly.assertThat(homePage.getHeaderMenuComponent().getMetalColorsHeaderElement().isDisplayed()).isTrue();
        softly.assertAll();
    }

    //Step6 Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 4)
    public void testImages() {
        softly.assertThat(homePage.getListOfImages().size()).isEqualTo(4);
        homePage.getListOfImages().forEach(webElement -> softly.assertThat(webElement.isDisplayed()).isTrue());
        softly.assertAll();
    }

    //Step7 Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 5)
    public void testTextForImages() {
        List<String> actualText = homePage.getListOfTests().stream()
                .map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedText = Arrays.asList("To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "To be flexible and\n"
                        + "customizable",
                "To be multiplatform",
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…");

        softly.assertThat(actualText.size()).isEqualTo(4);
        softly.assertThat(actualText).isEqualTo(expectedText);
    }

    //Step8 Assert that there is the iframe with “Frame Button” exist
    //Step9 Switch to the iframe and check that there is “Frame Button” in the iframe
    //Step10 Switch to original window back
    @Test(priority = 6)
    public void testIframe() {
        webDriver.switchTo().frame("frame");
        softly.assertThat(homePage.getFrameButton().isDisplayed()).isTrue();
        webDriver.switchTo().defaultContent();
    }

    //Step11 Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 7)
    public void testSideMenu() {
        List<String> actualText = homePage.getSideMenuComponent()
                .getSideMenuItems().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedText = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softly.assertThat(actualText.size()).isEqualTo(5);
        softly.assertThat(actualText).isEqualTo(expectedText);
        softly.assertAll();
    }
}
