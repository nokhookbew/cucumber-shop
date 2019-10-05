Feature: Check Stock

  Background:
    Given a product milk for 10 in stock with price 100 for each product
    And a product butter for 5 in stock with price 250 for each product

  Scenario: Buy product more than stock
    When I buy 11 milk that more than stock
    Then There are 10 milk in stock

  Scenario: Buy product less than stock
    When I buy 10 milk that less than stock
    Then There are 0 milk in stock