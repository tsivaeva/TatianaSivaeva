package com.epam.tc.hw6;

import com.epam.tc.hw4.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class TestSecond extends BaseTest {

    @Test
    @Description("Test different elements page")
    public void testDifferentElementsPage() {
        assertStep.assertTitle("Home Page");
        actionStep.login(USER_LOGIN, USER_PASSWORD);
        assertStep.assertLogin(USER_NAME);
        actionStep.navigateToDifferentElementsPage();
        assertStep.assertTitle("Different Elements");
        actionStep.clickOnCheckBox("Water");
        assertStep.assertCheckBoxIsSelected("Water", true);
        actionStep.clickOnCheckBox("Wind");
        assertStep.assertCheckBoxIsSelected("Wind", true);
        actionStep.clickOnCheckBox("Selen");
        assertStep.assertCheckBoxIsSelected("Selen", true);
        actionStep.selectColor("Yellow");
        assertStep.assertColor("Yellow");
        assertStep.assertLogs();
    }
}
