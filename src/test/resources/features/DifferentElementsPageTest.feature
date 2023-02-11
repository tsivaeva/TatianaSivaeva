Feature: Verify different elements page

  Background:
    When User opens the website
    Then Page Title should be "Home Page"
    When User logins with login "Roman" and password "Jdi1234"
    Then User name "ROMAN IOVLEV" should be displayed

  Scenario: Verify different elements page
    When User navigates to different elements page
    Then Page Title should be "Different Elements"
    When User clicks on check box "Water"
    Then Check box "Water" should be selected
    When User clicks on check box "Wind"
    Then Check box "Wind" should be selected
    When User clicks on check box "Selen"
    Then Check box "Selen" should be selected
    When User selects color "Yellow"
    Then Color "Yellow" should be selected
    And Logs should be displayed

