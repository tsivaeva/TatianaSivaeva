Feature: User Table Page Test

  Background:
    When User opens the website
    Then Page Title should be "Home Page"
    When User logins with login "Roman" and password "Jdi1234"
    Then User name "ROMAN IOVLEV" should be displayed

    Scenario: User Table Page test
      When User clicks on "User Table" button in Service dropdown
      Then Page Title should be "User Table"
      Then 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
      And 6 Usernames should be displayed on Users Table on User Table Page
      And 6 Description texts under images should be displayed on Users Table on User Table Page
      And 6 checkboxes should be displayed on Users Table on User Table Page
      And User table should contain following values:
        | Number | User             | Description                      |
        | 1      | Roman            | Wolverine                        |
        | 2      | Sergey Ivan      | Spider Man                       |
        | 3      | Vladzimir        | Punisher                         |
        | 4      | Helen Bennett    | Captain America some description |
        | 5      | Yoshi Tannamuri  | Cyclope some description         |
        | 6      | Giovanni Rovelli | Hulk some description            |
      And Droplist should contain values in column Type for user Roman
        | Admin           |
        | User            |
        | Manager         |

    Scenario: User selects VIP checkbox
      When User clicks on "User Table" button in Service dropdown
      Then Page Title should be "User Table"
      When User selects vip checkbox for "Sergey Ivan"
      Then 1 log row has "Vip: condition changed to true" text in log section
