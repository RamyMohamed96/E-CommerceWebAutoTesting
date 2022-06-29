Feature: user switch between currencies ($, €)


  Scenario: guest user can choose € currency
    When    user select “Euro” from currency dropdown list
    Then    all $ sign change to € sign

