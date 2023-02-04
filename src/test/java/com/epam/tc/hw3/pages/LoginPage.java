package com.epam.tc.hw3.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUserName() {
        return userName;
    }


    public void login(String name, String password, WebDriver webDriver) {
        getUserIcon().click();
        getNameField().sendKeys(name);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(getUserName()));
    }

    public static LoginPage initLoginPage(WebDriver webDriver) {
        return new LoginPage(webDriver);
    }

    public LoginPage clickUserIcon() {
        this.getUserIcon().click();
        return this;
    }

    public LoginPage setUserName(String name) {
        this.getNameField().sendKeys(name);
        return this;
    }

    public LoginPage setUserPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        this.getLoginButton().click();
        return this;
    }
}
