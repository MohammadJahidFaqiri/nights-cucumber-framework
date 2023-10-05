@SMOKE
Feature: Validate Account Table
  @US_09
  Scenario: Validate account table rows
    Given Login with username as "supervisor" and password as "tek_supervisor"
    When Click on "Accounts" Link
    When Wait 60 Second
    Then Validate accounts table have 10 rows

    @US_10
    Scenario: Validate Change Item per page
      Given Login with username as "supervisor" and password as "tek_supervisor"
      When Click on "Accounts" Link
      When Wait 60 Second
      Then Validate accounts table have 10 rows
      When change item per page to "25"

