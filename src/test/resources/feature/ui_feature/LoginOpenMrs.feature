Feature: Open Mrs login test

  @negativeLogin @regression
  Scenario Outline: Negative test to sign in Open Mrs
    Given User navigated to openMRS login page with the link "https://demo.openmrs.org/openmrs/login.htm"
    When User uses provides "<username>" and "<password>" to log in
    Then User has "<error message>" message

    Examples:
      | username   | password | error message                                |
      | adminnn    | Admin123 | Invalid username/password. Please try again. |
      | admin      |          | Invalid username/password. Please try again. |
      |            | Admin123 | Invalid username/password. Please try again. |
      | techtorial | techno   | Invalid username/password. Please try again. |
      |            |          | Invalid username/password. Please try again. |
      | a          | 12345    | Invalid username/password. Please try again. |

  @positiveLogin @smoke @regression
  Scenario: Positive test to sign in Open Mrs
    When User navigates to open Mrs home page
    And User logs in with username and password
    Then User is logged in correctly

