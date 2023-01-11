package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest extends AbstractTest {

    @DataProvider
    public static Object[][] subCorrectData() {
        return new Object[][]{
                {10.0, 2.0, 8.0},
                {-10.0, 2.0, -12.0}};
    }

    @Test(groups = {"group1"}, dataProvider = "subCorrectData")
    public void subTest(double a, double b, double expected) {

        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
