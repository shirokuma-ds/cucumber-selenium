@YugiOhFeature
Feature: Test Yugi Oh

  Scenario Outline: User search <card> on Yugi Oh DB
    Given I open Yugi Oh DB
    When I search for card '<card>'
    And I click for the first result
    Then I should see the card'<card>'
    Examples:
      | card                   |
      | dark magician          |
      | dark magician girl     |
      | blue-eyes white dragon |
      | red-eyes black dragon  |