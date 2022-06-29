Feature: user must be create new account


  Scenario: user register with valid data

    Given   user navigate to register page
    And     user choose male or female
    When    user enter valid data
    Then    user click on register button
    And     user Register Successfully