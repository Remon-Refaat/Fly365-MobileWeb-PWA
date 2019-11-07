Feature: My Payment for Logged in User

  Background:
    Given Navigate to "www" Fly365 "stage" site

  Scenario: Check that Login user can add traveller
    And Delete payment card "4736140090905479" from database
    And Delete the user "john.smith.fly365pwa@gmail.com" if he exists in the database
    And Insert new user at database "john.smith.fly365pwa@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And Open the main menu
    And Press on Sign in or register now button
    And Add the email "john.smith.fly365pwa@gmail.com" to the email field
    And Add the password "@Test123" to the password field
    And Press on Sign In button
    And Press on payment tab
    And Press on add payment button
    And Add the following payment card details
      | Holder Name | Card Number      | Expiry Date | CVV |
      | John Smith  | 4736140090905479 | 1234        | 123 |
    And Click Save button
    And Card is added successfully
