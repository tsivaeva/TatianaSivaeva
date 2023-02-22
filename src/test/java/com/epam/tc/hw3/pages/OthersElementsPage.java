package com.epam.tc.hw3.pages;

import static com.epam.tc.hw4.tests.BaseTest.webDriver;

import com.epam.tc.hw3.pages.components.ColorsDropDownComponent;
import com.epam.tc.hw3.pages.components.LogComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OthersElementsPage {

    private ColorsDropDownComponent colorsDropDownComponent;

    private LogComponent logComponent;

    @FindBy(xpath = "//label[text()[contains(.,' Water')]]/input")
    private WebElement waterCheckBox;

    @FindBy(xpath = "//label[text()[contains(.,' Wind')]]/input")
    private WebElement windCheckBox;

    @FindBy(xpath = "//label[text()[contains(.,' Selen')]]/input")
    private WebElement radioSelen;

    public OthersElementsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        colorsDropDownComponent = new ColorsDropDownComponent();
        logComponent = new LogComponent();
        PageFactory.initElements(webDriver, colorsDropDownComponent);
        PageFactory.initElements(webDriver, logComponent);
    }

    public ColorsDropDownComponent getColorsDropDownComponent() {
        return colorsDropDownComponent;
    }

    public LogComponent getLogComponent() {
        return logComponent;
    }

    public WebElement getWaterCheckBox() {
        return waterCheckBox;
    }

    public WebElement getWindCheckBox() {
        return windCheckBox;
    }

    public WebElement getRadioSelen() {
        return radioSelen;
    }

    public WebElement findElement(String checkBoxName) {
        String xpath = String.format("//label[text()[contains(.,' %s')]]/input", checkBoxName);
        return webDriver.findElement(By.xpath(xpath));
    }
}
