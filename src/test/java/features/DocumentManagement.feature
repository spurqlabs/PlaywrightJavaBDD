Feature: Document Management feature

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
    When user clicks on profile icon

  Scenario:TC-50 verify that Document_Manager is able to edit document details
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on add document button
    And user upload a documents file
    When user click on add document button
    Then verify document is uploaded successfully message is displayed
    When User clicks on three dots of uploaded document
    And User click on edit document option
    Then verify edit document details page is displayed
    When user update the document details

  Scenario:TC51 verify that Document_Manager is able to edit the module details
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on document to modify
    Then verify document details page is displayed
    When user click on update module details button
    Then verify update module details page is displayed
    When user update the module details
    And  user click on apply button
    Then verify module details is updated successfully message is displayed

  Scenario: TC-52 verify that Document_Manager is able to add a new document
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on add document button
    And user upload a documents file
    When user click on add document button
    Then verify document is uploaded successfully message is displayed

  Scenario:TC-53 verify that document_manager is able to add existing document.
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on add document button
    And user upload a document file which is already exist in document management page
    When user click on add document button
    Then verify duplicate file detected popup message is displayed
    When user click on accept duplicate button
    And user click on add document button
    Then verify document is uploaded successfully message is displayed

  Scenario: TC-54 verify that Document_Manager is able to delete a document
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on add document button
    And user upload a documents file
    When user click on add document button
    #Then verify document is uploaded successfully message is displayed
    When User clicks on three dots of uploaded document
    And User click on delete document option
    When user click on delete document button
    Then verify document is deleted successfully message is displayed



  Scenario: TC-54 Document_Manager is able to filter the documents based on Newest first filter option.
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on filter option
    Then verify filter options are displayed
    When user select filter option as Newest First
    Then verify documents are filtered based on Newest first filter option successfully

  Scenario: TC-55 Document_Manager is able to filter the documents based on Oldest first filter option.
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on filter option
    Then verify filter options are displayed
    When user select filter option as Oldest First
    Then verify documents are filtered based on Oldest first filter option successfully

  Scenario:TC-56 Document Manager is able to filter a document based on document type
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on filters option
    Then verify differnt filter sections are displayed
    When user click on document type filter option
    And user select document type option from dropdown
    Then verify documents are filtered based on selected document type.

  Scenario:TC-57 Document_Manager is able to filter a document based on module flag
    When User clicks on document management link
    Then verify document management page is displayed
    When user click on filters option
    When user click on module type filter option
    When user select module type option from dropdown
    And user clicks on cross icon
    Then verify documents are filtered based on selected module type.
   #removed this filter option as per new changes in document management page
  Scenario: Tc-58 Document_Manager is filter a document based on file type
    When User clicks on document management link
    When user click on filters option
    When user click on file type filter option
    When user select file type option from dropdown
    And user clicks on cross icon
    Then verify documents are filtered based on selected file type.

  Scenario: TC-59 Document_Manager is able to search a document using document title
    When User clicks on document management link
    When user enter document title in search box
    Then verify document is searched successfully based on document title

  Scenario: TC-60 Document_Manager is verify default item display per page in document management page
    When User clicks on document management link
    Then verify document management page is displayed
    And  verify default item display per page is ten item in document management page



  Scenario Outline: TC-61 - Verify item display per page dropdown options in document management page
    When User clicks on document management link
    Then verify document management page is displayed
    When User selects "<ItemsPerPage>" from items per page dropdown
    Then Verify "<ItemsPerPage>" items are displayed per page

    Examples:
      | ItemsPerPage |
      | 10           |
      | 20           |
      | 50           |
      | 100          |




  Scenario:TC-62 Document_Manager is able to navigate to next and previous page in document management page
    When User clicks on document management link
    When user navigate to next page
    #Then verify user is navigated to next page successfully
    When user navigate to previous page
    #Then verify user is navigated to previous page successfully