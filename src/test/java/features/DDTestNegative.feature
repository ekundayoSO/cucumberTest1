Feature: Login Functionality/Negative testing
  This feature deals with login functionality of the application

  Scenario Outline: Login with invalid credentials
    Given User launches edge browser
    When User navigate to the DemoWebShop login page
    And User clicks login button
    And User enters "<Email>" and "<Password>"
    And User clicks on login button
    Then User should see appropriate "<ErrorMessage>" being displayed

    Examples:
      | Email          | Password | ErrorMessage                           |
      | sfvf@gmail.com | abc@123  | The credentials provided are incorrect |
      |                |          | No customer account found              |

