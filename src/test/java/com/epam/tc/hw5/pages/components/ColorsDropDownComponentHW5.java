package com.epam.tc.hw5.pages.components;

import com.epam.tc.hw5.pages.MainPageHW5;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ColorsDropDownComponentHW5 extends MainPageHW5 {

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement colorsDropDown;

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']//option[text() = 'Yellow']")
    private WebElement yellowColor;

    @FindBy(css = "div [class='uui-form-element'] > option")
    private List<WebElement> colorsList;

    public ColorsDropDownComponentHW5(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getColorsList() {
        return colorsList;
    }

    public void selectColorFromList(String colorName) {
        getColorsList().stream().filter(webElement -> webElement
                .getText().equals(colorName)).forEach(WebElement::click);
    }

    public boolean isColorDisplayed(String colorName) {
        boolean isDisplayed = false;
        for (WebElement webElement : getColorsList()) {
            if (webElement.getText().equals(colorName) & webElement.isDisplayed()) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }
}
