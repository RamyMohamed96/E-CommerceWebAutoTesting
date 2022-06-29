Feature:  user login to the system


  Scenario: user login with valid data
    When    user navigate to login page
    And     user enter "ramorionly96@gmail.com" and "Password"
    Then    user click on login button
    And     user login successfully and go to home page


  Scenario: user login with invalid data
    When    user navigate to login page
    And     user enter "ramorionly@gmail.com" and "Passwordddd"
    Then    user click on login button
    And     user not login successfully and go to home page