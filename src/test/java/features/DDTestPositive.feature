# Demonstrating the use of Data Driven Test

Feature: Login Functionality

Scenario Outline: Verifying the user successful login
Given User launches chrome browser
When User navigates to the DemoWebShop login page
And User clicks login element
When User enters the "<Username>" and "<Password>"
And User should see the user logout page
Then User closes the browser

Examples:
| Username         | Password   |
| sulai@gmail.com  | Abc@123    |
| kimolu@gmail.com | testing123 |
| doej@gmail.com   | john123    |
| sellos@gmail.com | test123    |
| sfvf@gmail.com   | Abc@123    |

