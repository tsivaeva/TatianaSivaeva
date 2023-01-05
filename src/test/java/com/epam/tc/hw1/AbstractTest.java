package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {

    protected Calculator calculator;

    @BeforeMethod //(groups = {"group1", "group2"})
    public void before() {
        calculator = new Calculator();
    }

    @AfterMethod //(groups = {"group1", "group2"})
    public void after() {
        calculator = null;
    }
}
