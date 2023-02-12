package com.epam.tc.hw5.pages.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SideMenuComponentHW5 {

    @FindBy(css = ".sidebar-menu > li")

    private List<WebElement> sideMenuItems;

    public List<WebElement> getSideMenuItems() {
        return sideMenuItems;
    }
}
