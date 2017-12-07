Feature: Api: As a developer, I want to make sure during most common cases of mistake we get proper errors from the service

  Scenario: I should get Invalid Input Error when I try to insert invalid entry
    Given Ayon-API is up
    When I make a call to Create a User with Name Pickachu and Age 1000
    Then I expect a 400 response
    And the API response contains
      | message | Age should be in the range [1,50] |


  Scenario: I should get Invalid Input Error when I try fetch a user that does not exist
    Given Ayon-API is up
    When I make a call to Fetch a User with Name Raiku
    Then I expect a 404 response
    And the API response contains
      | message | Person Does Not Exist |
