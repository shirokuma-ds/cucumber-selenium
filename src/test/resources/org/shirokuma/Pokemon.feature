@BulbapediaFeature
  Feature: Test Bulbapedia

    Scenario Outline: Search a pokemon
      Given I open Bulbapedia
      When I search a '<pokemon>'
      Then I should see the pokemon '<pokemon>'
      Examples:
      | pokemon |
      | pikachu |
      | bulbasaur |
      | squirtle  |
