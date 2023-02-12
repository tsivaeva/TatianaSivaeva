package com.epam.tc.hw2;

import java.util.List;

public class TestData {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String MAIN_PAGE_TITLE = "Home Page";
    public static final String NAME = "Roman";
    public static final String PASSWORD = "Jdi1234";
    public static final String TEXTUSER_NAME = "ROMAN IOVLEV";
    public static final List HEADER_ITEMS = List
            .of("HOME", "CONTACT FORM", "SERVICE ", "METALS & COLORS");
    public static final List BENEFIT_ITEMS = List
            .of("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable", "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    public static final List LOGS_ITEMS = List.of("Water: condition changed to true", "Wind: condition changed to true",
            "metal: value changed to Selen", "Colors: value changed to Yellow");
}
