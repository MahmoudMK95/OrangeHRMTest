Feature: OrangeHRM Admin User Management

  Scenario: Add and delete user, verifying record count
    Given user navigates to OrangeHRM login page
    When user logs in with username "Admin" and password "admin123"
    And user clicks on Admin tab
    Then system gets the current number of records
    When user adds a new user
    Then system verifies number of records increased by 1
    When user searches for the new username
    And deletes the user
    Then system verifies number of records decreased by 1
