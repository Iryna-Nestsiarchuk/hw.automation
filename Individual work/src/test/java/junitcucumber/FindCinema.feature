Feature: Find cinema

  Scenario: Check cinemas for today's evening
    Given I am on the main application page
    When I search in post category of yandex for a film
    And choose the founded film
    And select today's evening
    And take screenshot
    Then I see at least one founded cinema
    And Screenshot the same as in the baseline
