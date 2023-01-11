package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest extends AbstractTest {

    @DataProvider
    public static Object[][] multCorrectData() {
        return new Object[][]{
                {0, 115.15, 0},
                {-10.0, 2.0, -20.0}
        };
    }

    @Test(groups = {"group2"}, dataProvider = "multCorrectData")
    public void multTest(double a, double b, double expected) {
        var actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
