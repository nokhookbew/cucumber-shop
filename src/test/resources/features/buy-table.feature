Feature: Buy a lot of product

Background:
  Given the following products exist:
    | Bread | 100 |
    | Jam   | 50  |
    | Butter | 75 |
    | Chocolate | 150 |


Scenario: Buy 3 product
  When I buy Bread with quantity 2
  And I buy Jam with quantity 1
  And I buy Butter with quantity 2
  Then total should be 400.00
