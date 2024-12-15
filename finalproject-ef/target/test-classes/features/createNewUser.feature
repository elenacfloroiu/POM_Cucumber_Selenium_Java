Feature: Test Create New User functionalities

  Background: Login with an user
    Given Login Page
    When Fill the user name field
    And Fill the password field
    And Click Submit button
    And Assert that the user successfully login into its account
    And Expand menu
    And Scroll down the menu
    And Hover on "Administration" module
    And Click on "Users, Groups and Roles" page
    And Click on "New" button

  @Cleanup
  Scenario Outline: Create a new user and set a default language
    When Fill the new username "<newUsername>"
    And Set default language to "<defaultLanguage>"
    And Press on Save button
    And Search new user "<newUsername>"
    Then Assert that the selected language is "<defaultLanguage>"

    Examples:
      | newUsername | defaultLanguage |
      | EFTest      | English         |

  Scenario Outline: Generate an activation link for a new user
    When Fill the new username "<newUsername>"
    And Press on Save button
    And Search new user "<newUsername>"
    And Generate "Activation Link"
    Then Assert that the activation link has been successfully generated

    Examples:
      | newUsername |
      | EFTest      |

  @Cleanup
  Scenario Outline: Validate that cannot be created 2 users with the same username
    When Fill the new username "<newUsername>"
    And Press on Save button
    Then Assert error validation snack bar for the already created user "<newUsername>"

    Examples:
      | newUsername |
      | EFTest      |




