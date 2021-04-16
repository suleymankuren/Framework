Feature: Open Mrs Patient Register

  Background:
    Given User navigates to open Mrs home page
    And User logs in with username and password

  @patientRegister @smoke @regression
  Scenario: Positive test to register a patient in Open Mrs system
    When User registers a new patient with following information:
      | givenName | familyName | gender | birthday | birthmonth | birthyear | address           | city    | state | country       | postal code | phoneNumber | relative name   |
      | David     | Techtorial | Male   | 19       | 9          | 1998      | 2012 S America St | Chicago | IL    | United States | 53683       | 2223336655  | John Techtorial |
    Then New patient is registered

  @patientRegisterNegative1 @regression
  Scenario: Negative test to register a patient in Open Mrs system
    When User clicks Gender Label without filling required information
    Then User is not able to process

  @patientRegisterNegative2 @regression
  Scenario: Negative test 2 to register a patient in Open Mrs system
    When User provides Given Name and Family Name
    And User navigates to Gender section
    And User clicks confirm button
    Then User is not able to confirm
