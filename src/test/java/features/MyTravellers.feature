Feature: My Travellers for Logged in User

  Background:
    Given Navigate to "www" Fly365 "stage" site

#  @Sign_Out
  Scenario: Check that Login user can add traveller
    And Delete traveller "Jack Mark Daniel" from database
    And Delete the user "john.smith.fly365pwa@gmail.com" if he exists in the database
    And Insert new user at database "john.smith.fly365pwa@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And Open the main menu
    And Press on Sign in or register now button
    And Add the email "john.smith.fly365pwa@gmail.com" to the email field
    And Add the password "@Test123" to the password field
    And Press on Sign In button
    And Press on traveller tab
    And Press on add traveller button
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | Jack       | Mark        | Daniel    | 15  | February | 1985 |
    When Click Save button
    And Traveller "Mr. Jack Mark Daniel" is added successfully
