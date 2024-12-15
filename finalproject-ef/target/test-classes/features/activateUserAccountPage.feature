Feature: Test Activation Link functionalities

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

  Scenario Outline: Test case when userName is not valid
    When Fill the new username "<newUsername>"
    And Press on Save button
    And Search new user "<newUsername>"
    And Generate "Activation Link"
    And Assert that the activation link has been successfully generated
    And Open the Activation link in new tab
    And Enter the new username "<InvalidNewUsername>"
    And Enter the new password field "<newPassword>"
    And Enter the new repeat password field "<newRepeatPassword>"
    And Select a secure question with index <secureQuestionIndex> from the dropdown
    And Fill the secure answer "<secureAnswer>"
    And Press on Submit button
    Then Redirect to the expired link.

    Examples:
      | newUsername | InvalidNewUsername | newPassword | newRepeatPassword | secureQuestionIndex | secureAnswer |
      | EFTest      | invalidUsr         | qwerty01009 | qwerty01009       | 1                   | 1234         |

  Scenario Outline: Test case when repeat password is different than password
    When Fill the new username "<newUsername>"
    And Press on Save button
    And Search new user "<newUsername>"
    And Generate "Activation Link"
    And Assert that the activation link has been successfully generated
    And Open the Activation link in new tab
    And Enter the new username "<newUsername>"
    And Enter the new password field "<newPassword>"
    And Enter the new repeat password field "<newRepeatPassword>"
    And Select a secure question with index <secureQuestionIndex> from the dropdown
    And Fill the secure answer "<secureAnswer>"
    And Press on Submit button
    Then Display error validation message when repeat password is not equal

    Examples:
      | newUsername | newPassword | newRepeatPassword | secureQuestionIndex | secureAnswer |
      | EFTest2     | qwerty01009 | qwerty019         | 1                   | 1234         |


  Scenario Outline: Test case when password have less than 10 characters
    When Fill the new username "<newUsername>"
    And Press on Save button
    And Search new user "<newUsername>"
    And Generate "Activation Link"
    And Assert that the activation link has been successfully generated
    And Open the Activation link in new tab
    And Enter the new username "<newUsername>"
    And Enter the new password field "<newPassword>"
    And Enter the new repeat password field "<newRepeatPassword>"
    And Select a secure question with index <secureQuestionIndex> from the dropdown
    And Fill the secure answer "<secureAnswer>"
    And Press on Submit button
    Then Display error validation message when password have less than 10 characters

    Examples:
      | newUsername | newPassword | newRepeatPassword | secureQuestionIndex | secureAnswer |
      | EFTest3     | qwerty019   | qwerty019         | 1                   | 1234         |


  Scenario Outline: Test case activate user account
    When Fill the new username "<newUsername>"
    And Press on Save button
    And Search new user "<newUsername>"
    And Generate "Activation Link"
    And Assert that the activation link has been successfully generated
    And Open the Activation link in new tab
    And Enter the new username "<newUsername>"
    And Enter the new password field "<newPassword>"
    And Enter the new repeat password field "<newRepeatPassword>"
    And Select a secure question with index <secureQuestionIndex> from the dropdown
    And Fill the secure answer "<secureAnswer>"
    And Press on Submit button
    Then Assert that the user has been redirected to the login page

    Examples:
      | newUsername | newPassword | newRepeatPassword | secureQuestionIndex | secureAnswer |
      | EFTest4     | qwerty0109  | qwerty0109        | 1                   | 1234         |


  Scenario Outline: Activate user account and verify that the account language coincides with the one set at the moment of account creation
    When Fill the new username "<newUsername>"
    And Set default language to "<defaultLanguage>"
    And Press on Save button
    And Search new user "<newUsername>"
    And Assign the new account to a Role in order to have access to the app
    And Navigate back to the Details tab
    And Generate "Activation Link"
    And Assert that the activation link has been successfully generated
    And Open the Activation link in new tab
    And Enter the new username "<newUsername>"
    And Enter the new password field "<newPassword>"
    And Enter the new repeat password field "<newRepeatPassword>"
    And Select a secure question with index <secureQuestionIndex> from the dropdown
    And Fill the secure answer "<secureAnswer>"
    And Press on Submit button
    And Login into the app with the new account: "<newUsername>", "<newPassword>"
    And Assert that the user successfully login into its account
    Then Assert the language is the same as the one set at the moment off user creation

    Examples:
      | newUsername | newPassword | newRepeatPassword | secureQuestionIndex | secureAnswer | defaultLanguage |
      | EFTest5     | qwerty0109  | qwerty0109        | 1                   | 1234         | English         |



