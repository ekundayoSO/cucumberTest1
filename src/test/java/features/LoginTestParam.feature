Feature: LoginFeature
  This feature deals with login functionality of the application


  Scenario: Login with correct username and password
    Given I launch firefox browser
    When I navigate to the Demo Web Shop login page
    And I click login element
    And I input the username as "sfvf@gmail.com" and password as "Abc@123"
    And I should see the user logout page
    Then I quit the browser