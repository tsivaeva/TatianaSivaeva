package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class HeaderMenuJdi extends WebPage {

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] > li")
    public Menu headerBar;

    public void selectMetalsColorsMenu() {
        headerBar.select("Metals & Colors");
    }
}
