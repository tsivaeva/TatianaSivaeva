package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgTest extends AbstractTest {

    @DataProvider
    public static Object[][] tgCorrectData() {
        return new Object[][]{
                {1.0, 1.557},
                {1.5, 14.101}
        };
    }

    @Test(dataProvider = "tgCorrectData")
    public void tgTest(double a, double expected) {
        var actual = calculator.tg(a);
        assertThat(actual).isEqualTo(expected);
    }
}
