package com.epam;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class AbstractTest {

    protected Calculator calculator;
    protected SoftAssert softAssert;

    @BeforeTest
    public void before() {
        calculator = new Calculator();
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void after() {
        calculator = null;
    }
}
