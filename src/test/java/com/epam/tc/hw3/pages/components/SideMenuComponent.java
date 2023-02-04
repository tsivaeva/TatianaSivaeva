package com.epam.tc.hw3.pages.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SideMenuComponent {

    @FindBy(css = ".sidebar-menu > li")

    private List<WebElement> sideMenuItems;

    public List<WebElement> getSideMenuItems() {
        return sideMenuItems;
    }
}
