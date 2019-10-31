Feature: Sign Up Page

  Background:
    Given Navigate to "www" Fly365 "stage" site

  @Sign_Out
  Scenario: Verify that Verify your email is sent successfully
    And Delete the user "john.smith.fly365pwa@gmail.com" if he exists in the database
    And Open the main menu
    And Press on Sign in or register now button
    And Click on Register Link
    And   Fill the following required data
      | First Name | Last Name | Email Address               | Password |
      | John       | Smith     | john.smith.fly365pwa@gmail.com | 12345678 |
    And   Click on Register button
    Then The user profile of "John Smith" is opened successfully
