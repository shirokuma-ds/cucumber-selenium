@SauceDemoFeature
Feature: Testing Sauce Demo Website

  Scenario: Add Items to Cart and Verify Items in the Cart
    Given User open Swag Lab website
    And User login to the website
      | username      | password     |
      | standard_user | secret_sauce |
    Then User should see the products page
    When User add the following items to the cart
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |
    And User click the cart button
    Then user verify items in the cart