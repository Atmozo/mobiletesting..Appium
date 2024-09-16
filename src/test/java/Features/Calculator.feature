Feature: Calculator Operations

  Scenario Outline: Verify that <num1> <operation> <num2> equals <answer>
    Given app is launched
    And the user clicks "<num1>"
    And the user clicks the "<operation>" button
    And the user clicks "<num2>"
    When the user clicks the equal button
    Then the correct Answer is displayed "<answer>"

    Examples:
      | num1 | operation | num2 | answer |
      | 1    | plus      | 1    | 2      |
      | 2    | plus      | 3    | 5      |
      | 8    | minus     | 2    | 6      |
      | 6    | multiply  | 2    | 12     |
      | 8    | divide    | 2    | 4      |

  Scenario: Verify calculator history after operations
    Given app is launched
    And the user performs a few operations
    And the user scrolls down to view history
    Then the history is visible

