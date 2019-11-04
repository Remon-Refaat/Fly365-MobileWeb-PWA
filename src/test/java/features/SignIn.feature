Feature: Sign In page

  Background:
    Given Navigate to "www" Fly365 "stage" site

#  @Sign_Out
  Scenario: Login into account with correct details
    And Delete the user "john.smith.fly365pwa@gmail.com" if he exists in the database
    And Insert new user at database "john.smith.fly365pwa@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And Open the main menu
    And Press on Sign in or register now button
    And Add the email "john.smith.fly365pwa@gmail.com" to the email field
    And Add the password "@Test123" to the password field
    When Press on Sign In button
    Then The user profile of "John Smith" is opened successfully
