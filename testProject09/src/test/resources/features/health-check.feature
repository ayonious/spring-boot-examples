Feature: Health check

  Scenario: Health check returns 2xx proper response
    Given Ayon-API is up
    When I make a call to the health check
    Then I expect a 200 response
    And the API response contains
      | status  | UP |
