Feature: Signup

  Background:
    Given User is on nucomply page


  Scenario: TC-01 verify that user can sign up for application using google
    When user clicks on sign in with google link

  Scenario: TC-02 verfify that the user can sign up for the application sucessfully using an email address
    When User click on login button
    Then user can see the login tab and sign up tab
    When user clicks on signup link
    Then user is redirected to signup page

    When I fill the registration form with:
      | password     | myPass123    |
      | fullName     | John Doe     |
      | organization | Example Corp |
      | title        | Developer    |
      |phonenumber   | 65646667890  |
    And I click the Sign Up button
    Then check user will recive a verification email




