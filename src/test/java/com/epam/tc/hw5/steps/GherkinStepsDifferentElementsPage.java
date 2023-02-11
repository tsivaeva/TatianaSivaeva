package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.utils.PageObjectInitializationHW5;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GherkinStepsDifferentElementsPage extends PageObjectInitializationHW5 {

    @When("User opens the website")
    public void user_opens_the_website() {
        loginPage.openMainPage();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String pageTitle) {
        assertThat(homePage.getTitle()).isEqualTo(pageTitle);
    }

    @When("User logins with login {string} and password {string}")
    public void user_logins_with_login_and_password(String login, String password) {
        loginPage.clickUserIcon().setUserName(login).setUserPassword(password).clickLoginButton();
    }

    @Then("User name {string} should be displayed")
    public void user_name_should_be_displayed(String userName) {
        assertThat(loginPage.getUserName().getText()).isEqualTo(userName);
    }

    @When("User navigates to different elements page")
    public void user_navigates_to_different_elements_page() {
        homePage.getHeaderMenuComponent().getServiceHeaderElement().click();
        homePage.getDifferentElements().click();
    }

    @When("User clicks on check box {string}")
    public void user_clicks_on_check_box(String checkBox) {
        othersElementsPageHW5.findElementFromList(checkBox).click();
    }

    @Then("Check box {string} should be selected")
    public void check_box_should_be_selected(String checkBox) {
        assertThat(othersElementsPageHW5.findElementFromList(checkBox).isEnabled()).isTrue();
    }

    @When("User selects color {string}")
    public void user_selects_color(String color) {
        othersElementsPageHW5.getColorsDropDownComponent().selectColorFromList(color);
    }

    @Then("Color {string} should be selected")
    public void color_should_be_selected(String color) {
        assertThat(othersElementsPageHW5.getColorsDropDownComponent().isColorDisplayed(color)).isTrue();
    }

    @Then("Logs should be displayed")
    public void logs_are_displayed() {
        assertThat(othersElementsPageHW5.getLogComponent().getLogs().size()).isEqualTo(4);
        assertThat(othersElementsPageHW5.getLogComponent()
                .isNatureElementDisplayed("Water", "true")).isTrue();
        assertThat(othersElementsPageHW5.getLogComponent()
                .isNatureElementDisplayed("Wind", "true")).isTrue();
        assertThat(othersElementsPageHW5.getLogComponent()
                .isMetalOrColorDisplayed("metal", "Selen")).isTrue();
        assertThat(othersElementsPageHW5.getLogComponent()
                .isMetalOrColorDisplayed("Colors", "Yellow")).isTrue();
    }

    @When("User clicks on {string} button in Service dropdown")
    public void user_clicks_on_button_in_service_dropdown(String item) {
        homePage.getHeaderMenuComponent().clickOnServiceItem();
        homePage.clickServiceMenuItem(item);
    }
}
