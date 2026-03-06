Feature: Nucomply Login feature

  Scenario: TC-03 verify that user login into application using valid credentials
    Given User is on nucomply page
   # Then verify login required screen is displayed
    When User click on login button
    Then user is redirected to login page
    When User enter following credentails
      | username               | password   |
      | Trupti.Natu@Nuarca.com | Trupti@123 |
    And  User click on Logins Buttons
    Then log-ing is successful displayed
    And homepage is visible to user
    When user clicks on menu icon

  Scenario:TC-04 verify that user can logout application successfully
    Given User is on nucomply page
   # Then verify login required screen is displayed
    When User click on login button
    Then user is redirected to login page
    When User enter following credentails
      | username               | password   |
      | Trupti.Natu@Nuarca.com | Trupti@123 |
    When User click on Logins Buttons
    Then log-ing is successful displayed
    And homepage is visible to user
    When User click on user profile icon
    And  User click on logout button
   #Then verify login required screen is dispalyed after logout


  Scenario:TC-44 verify that user forgot password functionality works properly
    Given User is on nucomply page
    #Then verify login required screen is displayed
    When User click on login button
    Then user is redirected to login page
    When User click on forgot password link
    Then verify reset password screen is displayed
    When User enter registered email id
    Then verify email id is entered successfully
    When User click on send button
    Then verify password reset mail is sent to registered email id





