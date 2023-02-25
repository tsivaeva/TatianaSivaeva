package com.epam.tc.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.HomePageJdi;
import com.epam.tc.hw7.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    @Url("index.html")
    public static HomePageJdi homePageJdi;

    @Url("metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;

    public static void openHomePage() {
        homePageJdi.open();
    }

    public static void login(User user) {
        homePageJdi.login(user);
    }

}
