Feature: Policy Generator

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
    When user clicks on menu icon

  Scenario: TC-43 Verify that User can generate the policy by uploading the policy template and providing required details
    When User clicks on soutlion tab
    And  user clicks on policy Generator
    Then verify policy generator screen is displayed
    When user select policy type from dropdown
    #Then verify selected policy type is displayed
    When user upload a file
    When user clicks on generate button
    When user enter the answer of asked question
    Then verify policy is generated successfully


   Scenario:TC-64 verify that user is able to copy the generated policy content
     When User clicks on soutlion tab
     And  user clicks on policy Generator
     Then verify policy generator screen is displayed
     When user select policy type from dropdown
     Then verify selected policy type is displayed
     When user upload a file
     When user clicks on generate button
     When user enter the answer of asked question
     Then verify policy is generated successfully
     When user click on copy button of generated policy content
     Then verify policy content is copied successfully message is displayed

     Scenario:TC-65 verify that user is able to reset the generated policy content
     When User clicks on soutlion tab
     And  user clicks on policy Generator
     Then verify policy generator screen is displayed
     When user select policy type from dropdown
     Then verify selected policy type is displayed
     When user upload a file
     When user clicks on generate button
     When user enter the answer of asked question
     Then verify policy is generated successfully
     When user click on reset button of generated policy content
     Then verify generated policy content is reset successfully