Feature: Best Buy Application


  Scenario Outline: Store CRUD Test
    Given Best buy application is running
    When I create a new store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    Then I verify that the store with name "<name>" is created
    And I update store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    And The store with name "<name>" is updated successfully
    And I delete the store that created with name "<name>"
    Then The store deleted successfully from the application
    Examples:
      | name  | type    | address           | address2 | city   | state  | zip   | lat | lng | hours    |
      | Tesco | Reatil  | 20prince road     | ha2 4rt  | London | Harrow | 54507 | 44  | 43  | mon10to4 |
      | Asda  | Reatail | 30 breamar avenue | ha4 1we  | London | Wembly | 54505 | 45  | 48  | Fri10to8 |