Feature: RegistrationFeature
  This is to create new user account on the application

  Scenario: Verify successful registration of a new user
    Given User launches the browser
    And User navigates to the homepage
    When User clicks on the register element
    And User clicks gender
    And User inputs the following details
    |Femi|Davids|test123|test123|
    And User presses the register button
    Then User should see success message your registration completed

