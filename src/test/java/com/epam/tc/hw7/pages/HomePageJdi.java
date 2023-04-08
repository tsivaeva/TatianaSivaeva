package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.HeaderMenuJdi;
import com.epam.tc.hw7.forms.LoginFormJdi;

public class HomePageJdi extends WebPage {

    public LoginFormJdi loginFormJdi;
    public HeaderMenuJdi headerMenuJdi;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(id = "user-name")
    public Label userName;

    public void login(User user) {
        userIcon.click();
        loginFormJdi.login(user);
    }

    public void checkUserLoggedIn(User user) {
        userName.is().text(user.getFullName());
    }

    public void openMetalsColorsPage() {
        headerMenuJdi.selectMetalsColorsMenu();
    }
}
