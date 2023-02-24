package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.ColorsDropDownComponentHW5;
import com.epam.tc.hw5.pages.components.LogComponentHW5;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OthersElementsPageHW5 extends MainPageHW5 {

    private final ColorsDropDownComponentHW5 colorsDropDownComponent;

    private final LogComponentHW5 logComponent;

    public OthersElementsPageHW5(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        colorsDropDownComponent = new ColorsDropDownComponentHW5(webDriver);
        logComponent = new LogComponentHW5();
        PageFactory.initElements(webDriver, colorsDropDownComponent);
        PageFactory.initElements(webDriver, logComponent);
    }

    public ColorsDropDownComponentHW5 getColorsDropDownComponent() {
        return colorsDropDownComponent;
    }

    public LogComponentHW5 getLogComponent() {
        return logComponent;
    }

    @FindBy(css = "div [class='checkbox-row'] > label")
    private List<WebElement> checkboxList;

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    public WebElement findElementFromList(String checkboxName) {

        return getCheckboxList().stream().filter(elem -> elem.getText().equals(checkboxName)).findAny().orElseThrow(()
                -> new NoSuchElementException("I can not to finde element  with checkboxName" + checkboxName));
    }
}
