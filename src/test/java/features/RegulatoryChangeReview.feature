Feature: Regualatory Change Review

  Background:
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
    When user clicks on menu icon
    When User clicks on soutlion tab

  Scenario:TC-23 Verify that user can view the Regulatory Change Review data in the form of graph on the dashboard based on types
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    And user can see different type of dashboard on regualtory change review screen

  Scenario:TC-24 Verify that the User can sort the regulatory change review data based on filter option 'Newest first'
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks newest first dropdown
    Then verify the filter options are displayed
    When user select newest first option
    Then verify the regulatory change review data is sorted based on newest first option


  Scenario:TC-25 Verify that the User can sort the regulatory change review data based on filter option 'Oldest first'
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks newest first dropdown
    Then verify the filter options are displayed
    When user select Oldest first option
    Then verify the regulatory change review data is sorted based on Oldest first option

  Scenario:TC-26 Verify that the User can sort the regulatory change review data based on filter option 'Most Impactful'
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks newest first dropdown
    Then verify the filter options are displayed
    When user select Most Impactful option
    Then verify the regulatory change review data is sorted based on Most Impactful option

  Scenario:TC-27 Verify that the User can sort the regulatory change review data based on filter option 'Least Impactful'
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks newest first dropdown
    Then verify the filter options are displayed
    When user select least Impactful option
    Then verify the regulatory change review data is sorted based on least Impactful option


  Scenario:TC-28 Verify that the User can filter the regulatory change review data based on date range by selection FromDate and Todate
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on filter option
    Then verify specific filter section are presented
    When user enter following from and todate
      | from     | Todate     |
      | 1/1/2025 | 12/12/2025 |
    And user clicks on cross icon
    Then verify the regulatory change review data is filtered based on selected date range

  Scenario:TC-29 Verify that the User can filter the regulatory change review data based on selected 'Jurisdiction' options
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on filter option
   # Then verify specific filter section are presented
    When user select dropdown option from jurisdiction dropdown
    And  user clicks on cross icon
    Then verify the regulatory change review data is filtered based on selected Jurisdiction options


  Scenario: TC-30 Verify that the User can filter the regulatory change review data based on selected 'Regulator' options
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on filter option
    Then verify specific filter section are presented
    When user select dropdown option from regulator dropdown
    And  user clicks on cross icon
    Then verify the regulatory change review data is filtered based on selected Regulator options

  Scenario: TC-31 Verify that the User can filter the regulatory change review data based on selected 'Impact' option
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on filter option
    Then verify specific filter section are presented
    When user select impact option
    And  user clicks on cross icon
    Then verify the regulatory change review data is filtered based on selected Impact option

  Scenario Outline: TC-31 Verify Impact filter functionality
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on filter option
    #Then verify specific filter section are presented
    When user selects "<impact>" impact option
    And user clicks on cross icon
    Then verify the regulatory change review data is filtered based on "<impact>"

    Examples:
      | impact |
      | High   |
      | Medium |
      | Low    |
      | All    |


  Scenario Outline:TC-32 Verify that the User can filter the regulatory change review data based on selected 'Type' option
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on filter option
    #Then verify specific filter section are presented
    When user selects "<type>" type option
    And user clicks on cross icon
    Then verify the regulatory change review data is filtered based on "<type>" is displayed

    Examples:
      | type               |
      | Rules              |
      | Proposed Rules     |
      | Enforcement Action |
      | Announcement       |
      | Other              |
      | All                |


  Scenario:TC-32 Verify that the User can filter the regulatory change review data based on selected 'Type' option
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on filter option
    Then verify specific filter section are presented
    When user select type option
    And  user clicks on cross icon
    Then verify the regulatory change review data is filtered based on selected 'Type' option

  Scenario: TC-33 Verify that the user can search the policy details for Regulatory Change Review using the search bar
    When user clicks on regulatory change review
    #Then verify regulatory change review page is displayed
    When user enter following text into search input field
    Then verify the regulatory change review data is searched based on entered text.

  Scenario:TC-34 Verify that the user can clear all the filters on regulatory change review data using the Clear All button on that page
    When user clicks on regulatory change review
   #Then verify regulatory change review page is displayed
    When user clicks on filter option
    #Then verify specific filter section are presented
    When user select impact option
    And user clicks on cross icon
    When user clicks on clear all button
    Then verify all the applied filters are cleared successfully

  Scenario:TC-35 Verify that the user can export all the regulatory change review policy data using the Export button on that page
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on Export button
    Then verify excel file is downloaded successfully

  Scenario:TC-36 Verify that the user can navigate through the Regulatory Change Review data displayed across multiple pages using the pagination
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on per page dropdown
    Then verify the per page options are displayed
    When user select the per item
    Then verify the regulatory change review data is displayed based on selected per item option


  Scenario:TC-37 Verify that the user can view the policy change document when user clicks on document name
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on any document name from the list
    Then verify the policy change summary and impact details are displayed on drill down page

  Scenario:TC-38 Verify that the user can ask questions based on the change summary and document from drill down page
    When user clicks on regulatory change review
    Then verify regulatory change review page is displayed
    When user clicks on any document name from the list
    Then verify the policy change summary and impact details are displayed on drill down page
    When user enter question into ask question input field related to document
    And user click on send button
    Then verify answer is displayed for the asked question

