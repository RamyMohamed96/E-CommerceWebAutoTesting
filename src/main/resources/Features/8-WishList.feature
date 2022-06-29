Feature: guest user add products to wishlist

  Background: user login first
    When      user navigate to login page
    And       user enter "ramorionly96@gmail.com" and "Password"
    Then      user click on login button
    And       user login successfully and go to home page


  Scenario: success message will visible after adding item to wishlist
    When    user add item to wishlist
    Then    wishlist notification success will visible


  Scenario: number of wishlist items in home page will increased
    When    user add item to wishlist
    Then    wishlist notification success will visible
    And     user get the number of wishlist items after adding item
    Then    the number of wishlist increased


  Scenario: added items are display on wishlist
    When    user add item to wishlist
    Then    wishlist notification success will visible
    And     user get the number of wishlist items after adding item
    And     user go to wishlist page
    Then    the number of items greater than zero in wishlist page
