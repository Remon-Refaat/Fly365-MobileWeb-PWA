Feature: Subscription Email

  Background:
    Given Navigate to "www" Fly365 "stage" site

  Scenario: Verify that the user can subscribe his/her email successfully
    And Delete the subscribed user "john.smith.fly365pwa@gmail.com" if he exists in the database
    And Open the main menu
    And Press on "Subscribe"
    And  Add the email address "john.smith.fly365pwa@gmail.com" to Subscription Email field
    When Press on Subscribe Button
    Then "Thank you! You've subscribed successfully. Tune in for our updates and special offers" message will be displayed