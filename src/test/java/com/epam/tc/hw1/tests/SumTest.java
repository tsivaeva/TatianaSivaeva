package com.epam.tc.hw1.tests;

import com.epam.tc.hw1.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends AbstractTest {

    @DataProvider
    public static Object[][] sumCorrectData() {
        return new Object[][]{
                {1.0, 2.0, 3.0},
                {-1.0, 0.0, -1.0}
        };
    }

    @Test(dataProvider = "sumCorrectData")
    public void sumTest(double a, double b, double expected) {
        var actual = calculator.sum(a, b);
        softAssert.assertEquals(actual, expected, 0.001);
    }
}
