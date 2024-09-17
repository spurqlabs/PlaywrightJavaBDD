@Basic
Feature: Verify Calculator Operations

  Scenario Outline: Verify addition of two numbers
    #Given line states that the User is on the Calculator home page and Calculator page is displayed.
    Given I am on Calculator page
    #When step describes an action that User enters/clicks on a number
    When I enter number <number>
    #And step indicates clicking on a specific operator (like addition, subtraction, etc.) on the calculator
    And I click on operator '<operator>'
    #And Step follows the operator click by entering another number into the calculator.
    And I enter number <number1>
    #Then is the verification step where the test checks if the result displayed
    Then I verify the result as <expectedResult>
    Examples:
      | number | operator | number1 | expectedResult |
      | 5      | +        | 2       | 7              |
      | 9      | -        | 3       | 6              |
      | 6      | *        | 4       | 24             |
      | 2      | /        | 2       | 1              |