package com.epam.tc.hw4.utils;

import static com.epam.tc.hw4.tests.BaseTest.webDriver;

import com.epam.tc.hw3.pages.LoginPage;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertStep extends PageObjectInitialization {
    public AssertStep(WebDriver webDriver) {
        super(webDriver);
    }

    SoftAssertions softly = new SoftAssertions();

    @Step("Assert page title")
    public void assertTitle(String title) {
        softly.assertThat(webDriver.getTitle()).isEqualTo(title);
        softly.assertAll();
    }

    @Step("Assert login")
    public void assertLogin(String userName) {
        softly.assertThat(new LoginPage(webDriver).getUserName().getText()).isEqualTo(userName);
        softly.assertAll();
    }

    @Step("Assert headers")
    public void assertHeaders() {
        softly.assertThat(homePage.getHeaderMenuComponent().getNavigationBarHeaderElement()
                .size()).isEqualTo(4);
        softly.assertThat(homePage.getHeaderMenuComponent().getHomeHeaderElement().isDisplayed()).isTrue();
        softly.assertThat(homePage.getHeaderMenuComponent().getContactFormHeaderElement().isDisplayed()).isTrue();
        softly.assertThat(homePage.getHeaderMenuComponent().getServiceHeaderElement().isDisplayed()).isTrue();
        softly.assertThat(homePage.getHeaderMenuComponent().getMetalColorsHeaderElement().isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Step("Assert images")
    public void assertImages() {
        softly.assertThat(homePage.getListOfImages().size()).isEqualTo(4);
        for (WebElement webElement : homePage.getListOfImages()) {
            softly.assertThat(webElement.isDisplayed()).isTrue();
        }
        softly.assertAll();
    }

    @Step("Assert texts for images")
    public void assertTextsForImages() {
        List<String> actualText = new ArrayList<>();
        for (WebElement webElement : homePage.getListOfTests()) {
            actualText.add(webElement.getText());
        }

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
        softly.assertAll();
    }

    @Step("Assert iframe")
    public void assertIFrame() {
        softly.assertThat(homePage.getFrameButton().isDisplayed());
    }

    @Step("Assert items in the left section")
    public void assertLeftSection() {
        List<String> actualText = new ArrayList<>();
        for (WebElement webElement : homePage.getSideMenuComponent().getSideMenuItems()) {
            actualText.add(webElement.getText());
        }

        List<String> expectedText = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        softly.assertThat(actualText.size()).isEqualTo(5);
        softly.assertThat(actualText).isEqualTo(expectedText);
        softly.assertAll();
    }

    @Step("Assert that checkbox is selected")
    public void assertCheckBoxIsSelected(String checkBoxName, boolean bool) {
        WebElement checkBoxElement = othersElementsPage.findElement(checkBoxName);
        if (bool = true) {
            softly.assertThat(checkBoxElement.isSelected()).isTrue();
        } else {
            softly.assertThat(checkBoxElement.isSelected()).isFalse();
        }
        softly.assertAll();
    }

    @Step("Assert color")
    public void assertColor(String color) {
        softly.assertThat(othersElementsPage.getColorsDropDownComponent().findColor(color)
                .getText()).isEqualTo(color);
        softly.assertAll();
    }

    @Step("Assert logs")
    public void assertLogs() {
        softly.assertThat(othersElementsPage.getLogComponent().getLogs().size()).isEqualTo(4);
        softly.assertThat(othersElementsPage.getLogComponent()
                .isNatureElementDisplayed("Water", "true")).isTrue();
        softly.assertThat(othersElementsPage.getLogComponent()
                .isNatureElementDisplayed("Wind", "true")).isTrue();
        softly.assertThat(othersElementsPage.getLogComponent()
                .isMetalOrColorDisplayed("metal", "Selen")).isTrue();
        softly.assertThat(othersElementsPage.getLogComponent()
                .isMetalOrColorDisplayed("Colors", "Yellow")).isTrue();
        softly.assertAll();
    }
}
