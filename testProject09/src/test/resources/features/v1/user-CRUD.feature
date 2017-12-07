Feature: Api: A user should be Created, Read, Updated and Deleted successfully

  Scenario: Create User And Read Is successful
    Given Ayon-API is up
    When I make a call to Create a User with Name Ayon and Age 39
    Then I expect a 200 response

    When I make a call to Fetch a User with Name Ayon
    Then I expect a 200 response
    And the API response contains
      | name | Ayon |
      | age  | 39   |

  Scenario: User Update and Deletion is successful
    Given Ayon-API is up
    When I make a call to Create a User with Name Ayon2 and Age 33
    Then I expect a 200 response

    When I make a call to Update a User Ayon2 With NewAge 35
    Then I expect a 200 response

    When I make a call to Fetch a User with Name Ayon2
    Then I expect a 200 response
    And the API response contains
      | name | Ayon2 |
      | age  | 35    |

    When I make a call to Delete a User With Name Ayon2
    Then I expect a 200 response

    When I make a call to Fetch a User with Name Ayon2
    Then I expect a 404 response
    And the API response contains
      | message | Person Does Not Exist|


  Scenario: User Fetch is not sucessful when I try to find a user that was not inserted
    Given Ayon-API is up
    When I make a call to Fetch a User with Name Tania
    Then I expect a 404 response
    And the API response contains
      | message | Not Found |
