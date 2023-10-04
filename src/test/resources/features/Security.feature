Feature: Application Security Functions

  @US_03
  Scenario: Validate login section Title
    Then Validate the header title is "TEK Insurance Portal"
    Then Validate login section title "Customer Service Portal"

  @US_04
  Scenario: Validate login button disable and enable
    Then Validate login button is "disabled"
    When Enter username as "supervisor"
    When Enter password as "tek_supervisor"
    Then Validate login button is "enabled"

  @US_05
  Scenario: Validate Login with valid username and password
    When Enter username as "supervisor"
    When Enter password as "tek_supervisor"
    When Click on login button
    Then Validate the header title is "Tek Insurance App"
    Then Validate logged in username is "Supervisor"

    @US_06
    Scenario: Validate negative data to login
      When Enter username as "wrong username"
      When Enter password as "tek_supervisor"
      When Click on login button
      Then Validate error message "User not found"

    @US_07
      Scenario Outline: Validate negative data to login
        When Enter username as "<username>"
        When Enter password as "<password>"
        When Click on login button
        Then Validate error message "<errorMessage>"

        Examples:
        |username|password|errorMessage|
        |supervisor|wrong password|Password Not Matched|
        |wrongUsername|tek_supervisor|User not found|
        |Mohammad|tek_supervisor|Password Not Matched|
        |Mike|Wrong pass|User not found|






