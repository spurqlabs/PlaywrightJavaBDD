Feature: AskChatgpt feature

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


  Scenario: Same Question to NuComply AI and Groq client and verify the answer using semantic similarity
    When user ask a question to nucomply AI
    Then capture the answer from nucomply AI
    When user ask same question to groq client
    Then capture the answer from groq client
    Then verify both answers are similar using semantic similarity 0.75

  Scenario: Verify that the user can ask questions based on the following categorie US fedral

  Scenario: that the user can ask questions based on the following categorie Federal & State

  Scenario: Verify that the user can ask questions based on the following categorie Canada