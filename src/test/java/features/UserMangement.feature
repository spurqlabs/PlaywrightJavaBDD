Feature: User Management

  Background:
    Given User is on nucomply page
    Then verify Login page is displayed
    When User click on login button
    Then user is redirected to login page
    When User enter following credentails
      | username               | password   |
      | Trupti.Natu@Nuarca.com | Trupti@123 |
    When User click on Logins Buttons
    Then log-ing is successful displayed
    Then homepage is visible to user

  Scenario Outline: TC39 Verify that Search functionality for User is working (by entering the name or email of any particular user to search)
    When user clicks on profile icon
    And user clicks on user management
    When user searches "<searchValue>"
    Then verify search result "<expectedValue>" using "<type>"

    Examples:
      | searchValue                 | expectedValue               | type     |
      | Shekhar                     | Shekhar                     | username |
      | lurlean.devin@mailmagnet.co | lurlean.devin@mailmagnet.co | email    |


  Scenario:TC40 verfiy that admin can edit profile of any particular user
    When user clicks on profile icon
    And user clicks on user management
    Then user mangement page is displayed
    When user search by following email or name details
      | name     | email               |
      | fivoruda | fivoruda@denipl.com |
    When user cilicks on three dots of searched user
    Then verify edit profile and deactivate user options are displayed
    When user clicks on edit profile
    Then verify that edit user name ,email and role fields are displayed
    When user update the role to a different role than the existing one
    Then updated role is displayed in role dropdown
    When user clicks on update button
    And user clicks on confirm button
    Then verify user profile is updated successfully message is displayed

  Scenario:TC-41 Verify that admin can deactivate any particular user
    When user clicks on profile icon
    And User clicks on Manage users
    Then user mangement page is displayed
    When user search by following email or name details
      | name   | email             |
      | Test18 | test18@nuarca.com |
    When user cilicks on three dots of searched user
    Then verify edit profile and deactivate user options are displayed
    When user clicks on deactivate button
    And user perform click on deactivate account button
    Then verify deactivate confirmation popup is displayed
    When user clicks on confirm button of deactivate popup
    Then verify user account status


  Scenario:TC-42 verify that admin can reactivate any particular deactivated user
    When user clicks on profile icon
    And User clicks on Manage users
    Then user mangement page is displayed
    When user search by following email or name details
      | name   | email                |
      | Test18 | racivu@polkaroad.net |
    When user cilicks on three dots of searched user
    Then verify reactivate user option is displayed
    When user clicks on reactivate Account buttonuser
    When user clicks on reactivate button
    When user click on confirm button
    Then verify user is reactivated successfully message is displayed


  Scenario: Verify that admin can invite new user
    When user clicks on profile icon
    And user clicks on user management
    Then user mangement page is displayed
    When user clicks on invite user button
    Then verify invite user popup is displayed
    When user enter following details to invite new user
    When user clicks on send invite button
    And user clicks on confirm button
    Then verify invite sent successfully message is displayed





