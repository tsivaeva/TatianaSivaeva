package com.epam.tc.hw7.tests;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.SiteJdi;
import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;
import com.epam.tc.hw7.steps.StepsHW7;
import com.epam.tc.hw7.utils.MetalColorsDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Feature("Metals & Colors page feature")
@Story("Metals & Colors page story")
public class JdiTest {

    @BeforeTest(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(SiteJdi.class);
        StepsHW7.loginJDI();
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "json", dataProviderClass = MetalColorsDataProvider.class)
    public void testMetalsColors(MetalsColorsJsonDTO dto) {
        StepsHW7.navigateToMetalsColorsPage();
        StepsHW7.fillMetalsColorsFormStep(dto);
        StepsHW7.checkMetalsColorsFormStep(dto);
    }
}
