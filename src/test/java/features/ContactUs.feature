Feature: Use Contact Us Page

  Background:
    Given Navigate to "www" Fly365 "stage" site

  Scenario: Verify that the user can send message through contact us page
    Given Open the main menu
    And Press on "Contact us"
    And Add "John Smith" to the Full Name field
    And Add "john.smith.fly365pwa@gmail.com" to the Email field
    And Choose a Category "General Question"
    And Add a message
    And Click on Send
    Then "Thank you for contacting us. Your message has been sent successfully" message will be displayed