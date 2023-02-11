package com.epam.tc.hw5.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SideMenuComponentHW5 {

    @FindBy(css = ".sidebar-menu > li")

    private List<WebElement> sideMenuItems;

    public List<WebElement> getSideMenuItems() {
        return sideMenuItems;
    }
}
