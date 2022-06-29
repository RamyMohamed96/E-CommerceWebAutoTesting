Feature: users will be search for products with different parameters


  Scenario: user search using valid product name
    Given user click on search bar
    When user search for product "Nokia"
    And user click on search Button
    Then user search successfully and go to search page


  Scenario: user search using SKU
    Given   user click on search bar
    When    user search for product "AP_MBP_13"
    And     user click on search Button
    Then    user search successfully with SKU


  Scenario: user search using invalid product name
    Given   user click on search bar
    When    user search for product "Xiaomi"
    And     user click on search Button
    Then    user not search