@WikipediaFeature
Feature: Test Wikipedia

  Scenario Outline: User search <fruit> on Wikipedia
    Given I open Wikipedia
    When I search '<fruit>'
    Then I should see '<fruit>'
    Examples:
      | fruit  |
      | apple  |
      | banana |
      | kiwi   |
      | guavax |