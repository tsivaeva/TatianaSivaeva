package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.utils.DriverManagerUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverSteps {

    @Before
    public static void setUp() {
        DriverManagerUtils.setupDriver();
    }

    @After
    public static void tearDownDriver() {
        DriverManagerUtils.tearDownDriver();
    }
}
