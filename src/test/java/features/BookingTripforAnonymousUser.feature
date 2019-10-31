Feature: Booking a Trip for Anonymous User

  Background:
    Given Navigate to "www" Fly365 "stage" site

  Scenario: Verify that the user can search successfully
    Given Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure, after "10" day from today
    And Select Passengers: "1" adult, "0" child, "0" infant
#    And Select "Premium" Class
    And Press on Search Now
    And Choose a trip
    And Press on Continue Button
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |

    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                        | Phone Country | Phone Number|
      | Mr    | John      | Smith      | john.smith.fly365pwa@gmail.com  |Ireland          | 12345678      |
    And Click on Next Step
    And Add a valid data for the credit card
      | Card Holder Number | Card Number         | Card Expire Date | Card CVV |
      | John Smith         | 5399 9999 9999 9999 | 0225             | 123      |
    And Select the passenger name as passport acknowledgment
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then 'Thank you for booking with Fly365' message is displayed