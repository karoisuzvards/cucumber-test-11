Feature: Housing - sorting

  Background:
    Given site is open
    And housing is open

  Scenario: Sorting can be done by price ascending
    When sorting is done by price ascending
    Then all items are sorted by lowest price first

  Scenario: Sorting can be done by price descending
    When sorting is done by price descending
    Then all items are sorted by highest price first

  Scenario: Sorting possibilities are available
    Then following sorting possibilities are available
      | PRICE_ASC  |
      | PRICE_DESC |
      | NEWEST     |

  Scenario: Sorting possibilities after search
    When search is used with valid keyword
    Then following sorting possibilities are available
      | PRICE_ASC  |
      | PRICE_DESC |
      | NEWEST     |
      | UPCOMING   |
      | RELEVANT   |



