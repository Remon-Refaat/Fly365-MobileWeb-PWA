Feature: Manage my Booking

  Background:
    Given Navigate to "www" Fly365 "stage" site

  Scenario: Verify that the anonymous user can retrieve his/her booking via Fly365 Reference
    And Book a trip from API for "stage"
    And Get Fly365 Reference for the trip
    And Open the main menu
    And Press on "Manage my booking"
    And Add a valid email address "john.smith.fly365pwa@gmail.com"
    And Add a valid Fly365 Reference
    And Press Find Booking
    Then The system will retrieve the details of the Booking Correctly