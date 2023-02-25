package com.epam.tc.hw7.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.TestData;
import com.epam.tc.hw7.SiteJdi;
import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;
import java.util.Arrays;
import java.util.List;

public class StepsHW7 {

    public static void loginJDI() {
        SiteJdi.openHomePage();
        SiteJdi.login(TestData.ROMAN);
        SiteJdi.homePageJdi.checkUserLoggedIn(TestData.ROMAN);
    }

    public static void navigateToMetalsColorsPage() {
        SiteJdi.homePageJdi.openMetalsColorsPage();
    }

    public static void fillMetalsColorsFormStep(MetalsColorsJsonDTO dto) {
        SiteJdi.metalsColorsPage.metalsColorsForm.fill(dto);
    }

    public static void checkMetalsColorsFormStep(MetalsColorsJsonDTO dto) {
        checkResultSection(dto, SiteJdi.metalsColorsPage.metalsColorsLogForm.getLogList());
    }

    public static void checkResultSection(MetalsColorsJsonDTO dto, List<String> logLost) {
        final String expectedSummary = "Summary: " + String.valueOf(dto.getSummary()
                .get(0) + dto.getSummary().get(1));
        String expectedElements = "Elements: ";
        final String expectedColor = "Color: " + dto.getColor();
        final String expectedMetal = "Metal: " + dto.getMetals();
        String expectedVegetables = "Vegetables: ";

        for (String str : dto.getElements()) {
            expectedElements += str + ", ";
        }
        expectedElements = expectedElements.substring(0, expectedElements.length() - 2);

        for (String str : dto.getVegetables()) {
            expectedVegetables += str + ", ";
        }
        expectedVegetables = expectedVegetables.substring(0, expectedVegetables.length() - 2);

        List<String> expectedList =
                Arrays.asList(expectedSummary, expectedElements, expectedColor, expectedMetal, expectedVegetables);
        List<String> actualList =
                Arrays.asList(logLost.get(0), logLost.get(1), logLost.get(2), logLost.get(3), logLost.get(4));

        assertThat(actualList).isEqualTo(expectedList);
    }
}
