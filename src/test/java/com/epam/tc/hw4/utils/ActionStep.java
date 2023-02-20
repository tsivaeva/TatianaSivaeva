package com.epam.tc.hw4.utils;

import static com.epam.tc.hw4.tests.BaseTest.webDriver;

import com.epam.tc.hw3.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends PageObjectInitialization {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Login")
    public void login(String login, String password) {
        new LoginPage(webDriver).clickUserIcon().setUserName(login).setUserPassword(password).clickLoginButton();
    }

    @Step("Switch to iframe")
    public void switchToIFrame() {
        webDriver.switchTo().frame("frame");
    }

    @Step("Switch to original window back from iframe")
    public void switchToOriginalWindow() {
        webDriver.switchTo().defaultContent();
    }

    @Step("Navigate to Different elements page")
    public void navigateToDifferentElementsPage() {
        homePage.getHeaderMenuComponent().getServiceHeaderElement().click();
        homePage.getDifferentElements().click();
    }

    @Step("Click on check box")
    public void clickOnCheckBox(String checkBoxName) {
        othersElementsPage.findElement(checkBoxName).click();
    }

    @Step("Select color")
    public void selectColor(String color) {
        othersElementsPage.getColorsDropDownComponent().clickOnDropDownColor();
        othersElementsPage.getColorsDropDownComponent().findColor("Yellow").click();
    }
}
