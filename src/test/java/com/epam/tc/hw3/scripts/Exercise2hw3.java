package com.epam.tc.hw3.scripts;

import com.epam.tc.TestDatahw3;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import com.epam.tc.hw3.pages.OthersElementsPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class Exercise2hw3 extends TestDatahw3 {

    LoginPage loginPage;
    HomePage homePage;
    OthersElementsPage othersElementsPage;

    SoftAssertions softAssertions = new SoftAssertions();

    //Step2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
    }

    //Step3 Perform login
    //Step4 Assert User name in the left-top side of screen that user is loggined
    @Test(priority = 2)
    public void testLogin() {
        loginPage.initLoginPage(webDriver)
                .clickUserIcon().setUserName(USER_LOGIN).setUserPassword(USER_PASSWORD).clickLoginButton();
        softAssertions.assertThat(loginPage.initLoginPage(webDriver).getUserName().getText()).isEqualTo(USER_NAME);
    }

    //Step5 Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void goToDifferentElementsPage() {
        homePage = new HomePage(webDriver);
        homePage.getHeaderMenuComponent().getServiceHeaderElement().click();
        homePage.getDifferentElements().click();
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
    }

    //Step6 Select checkboxes
    @Test(priority = 4)
    public void testCheckBoxes() {
        othersElementsPage = new OthersElementsPage(webDriver);
        othersElementsPage.getWaterCheckBox().click();
        othersElementsPage.getWindCheckBox().click();
        softAssertions.assertThat(othersElementsPage.getWaterCheckBox().isSelected()).isTrue();
        softAssertions.assertThat(othersElementsPage.getWindCheckBox().isSelected()).isTrue();
    }

    //Step7 Select radio
    @Test(priority = 5)
    public void testRadio() {
        othersElementsPage = new OthersElementsPage(webDriver);
        othersElementsPage.getRadioSelen().click();
        softAssertions.assertThat(othersElementsPage.getRadioSelen().isSelected()).isTrue();
    }

    //Step8 Select in dropdown
    @Test(priority = 6)
    public void testDropDown() {
        othersElementsPage = new OthersElementsPage(webDriver);
        othersElementsPage.getColorsDropDownComponent().clickOnDropDownColor();
        othersElementsPage.getColorsDropDownComponent().getYellowColor().click();
        softAssertions.assertThat(othersElementsPage.getColorsDropDownComponent().getYellowColor()
                .getText()).isEqualTo("Yellow");
    }

    //Step9 - Assert that
    //• for each checkbox there is an individual log
    //row and value is corresponded to the status
    //of checkbox
    //• for radio button there is a log row and value
    //is corresponded to the status of radio button
    //• for dropdown there is a log row and value is
    //corresponded to the selected value.
    @Test(priority = 7)
    public void testLogger() {
        othersElementsPage = new OthersElementsPage(webDriver);
        softAssertions.assertThat(othersElementsPage.getLogComponent().getLogs().size()).isEqualTo(4);
        softAssertions.assertThat(othersElementsPage.getLogComponent()
                .isNatureElementDisplayed("Water", "true")).isTrue();
        softAssertions.assertThat(othersElementsPage.getLogComponent()
                .isNatureElementDisplayed("Wind", "true")).isTrue();
        softAssertions.assertThat(othersElementsPage.getLogComponent()
                .isMetalOrColorDisplayed("metal", "Selen")).isTrue();
        softAssertions.assertThat(othersElementsPage.getLogComponent()
                .isMetalOrColorDisplayed("Colors", "Yellow")).isTrue();
        softAssertions.assertAll();
    }
}
