package com.epam.tc.hw1.tests;

import com.epam.tc.hw1.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest extends AbstractTest {

    @DataProvider
    public static Object[][] divCorrectData() {
        return new Object[][]{
                {10.0, 2.0, 5.0},
                {-10.0, 2.0, -5.0}
        };
    }

    @Test(dataProvider = "divCorrectData")
    public void divTest(double a, double b, double expected) {
        var actual = calculator.div(a, b);
        //Assert.assertEquals(actual, expected, 0.001);
        softAssert.assertEquals(actual, expected, 0.001);
    }
}
