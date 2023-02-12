package com.epam.tc.hw5.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHW5 extends MainPageHW5 {

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

    public LoginPageHW5(WebDriver webDriver) {
        super(webDriver);
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
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(getUserName()));
    }

    public static LoginPageHW5 initLoginPage(WebDriver webDriver) {
        return new LoginPageHW5(webDriver);
    }

    public LoginPageHW5 clickUserIcon() {
        this.getUserIcon().click();
        return this;
    }

    public LoginPageHW5 setUserName(String name) {
        this.getNameField().sendKeys(name);
        return this;
    }

    public LoginPageHW5 setUserPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPageHW5 clickLoginButton() {
        this.getLoginButton().click();
        return this;
    }

    public void openMainPage() {
        webDriver.manage().window().maximize();
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }
}
