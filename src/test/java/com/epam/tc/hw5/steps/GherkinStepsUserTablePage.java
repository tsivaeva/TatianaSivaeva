package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.utils.PageObjectInitializationHW5;
import org.assertj.core.api.SoftAssertions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class GherkinStepsUserTablePage extends PageObjectInitializationHW5 {
    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void number_type_dropdowns_should_be_displayed_on_users_table_on_user_table_page(Integer number) {
        assertThat(userTable.getlistTypeDropdowns().size()).isEqualTo(number);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernames_should_be_displayed_on_users_table_on_user_table_page(Integer number) {
        assertThat(userTable.getListUsers().size()).isEqualTo(number);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void images_should_be_displayed_on_users_table_on_user_table_page(Integer number) {
        assertThat(userTable.getListImages().size()).isEqualTo(number);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxes_should_be_displayed_on_users_table_on_user_table_page(Integer number) {
        assertThat(userTable.getListCheckboxes().size()).isEqualTo(number);
    }

    @Then("Droplist should contain values in column Type for user Roman")
    public void droplist_should_contain_values_in_column_Type_for_user_Roman(DataTable dataTable) {
        List<String> typeUserValues = dataTable.asList();
        for (int i = 1; i < typeUserValues.size(); i++) {
            userTable.userRightsDropdown(typeUserValues.get(i));
        }
    }

    @When("User selects vip checkbox for {string}")
    public void user_selects_vip_checkbox(String checkbox) {
        if (checkbox.toLowerCase().contains("ivan")) {
            userTable.selectVipCheckBox("ivan");
        }
    }

    @Then("{int} log row has {string} text in log section")
    public void log_row_has_text_in_log_section(Integer number, String text) {
        userTable.assertNumberOfLogItems(number);
        userTable.assertLogText(text);
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(DataTable dataTable) {
        SoftAssertions softly = new SoftAssertions();
        List<List<String>> listOfUsers = dataTable.cells().subList(1, 7);
        List<String> numbers = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        listOfUsers.forEach(els -> {
            numbers.add(els.get(0));
            names.add(els.get(1));
            descriptions.add(els.get(2));
        });
        softly.assertThat(userTable.getNumberInTableValues()).isEqualTo(numbers);
        softly.assertThat(userTable.getUserInTableValues()).isEqualTo(names);
        softly.assertThat(userTable.getDescInTableValues()).isEqualTo(descriptions);
        softly.assertAll();
    }
}
