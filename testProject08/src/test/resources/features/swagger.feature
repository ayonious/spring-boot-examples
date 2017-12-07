Feature: swagger: As a developer I want to make sure I can access swagger page

  Scenario: Getting ok response when accessing swagger-ui
    When I try reaching swagger-ui index page
    Then I expect a 200 response
