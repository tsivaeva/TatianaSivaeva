package com.epam.tc.hw5.pages.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogComponentHW5 {

    @FindBy(css = "ul[class='panel-body-list logs'] > li")
    private List<WebElement> logs;

    public List<WebElement> getLogs() {
        return logs;
    }

    public boolean isNatureElementDisplayed(String elem, String status) {
        return logs.stream().anyMatch(log -> log.getText().contains(elem + ": condition changed to " + status));
    }

    public boolean isMetalOrColorDisplayed(String elem, String status) {
        return logs.stream().anyMatch(log -> log.getText().contains(elem + ": value changed to " + status));
    }
}
