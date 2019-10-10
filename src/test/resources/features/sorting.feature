Feature: Housing - sorting

  Background:
    Given site is open
    And housing is open

  Scenario: Sorting can be done by price
    When sorting is done by lowest price
    Then all items are sorted by lowest price

