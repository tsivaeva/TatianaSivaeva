package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;

public class LoginFormJdi extends Form<User> {

    @FindBy(id = "name")
    public TextField name;

    @FindBy(id = "password")
    public TextField password;
}
