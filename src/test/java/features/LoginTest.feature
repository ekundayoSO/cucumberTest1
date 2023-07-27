Feature: LoginFeature
  This feature deals with login functionality of the application


  Scenario: Login with correct username and password
    Given I launch chrome browser
    When I navigate to the demo web shop login page
    And I click login button
    And I enter the username and password
    And I should see the user log out page
    Then I close the browser