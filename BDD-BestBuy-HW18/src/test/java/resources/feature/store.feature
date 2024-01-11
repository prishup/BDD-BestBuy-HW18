Feature: Best Buy Application
  @POSITIVE
Scenario Outline: Store CRUD Test
Given Best buy application is running
When I create a new store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    Then I verify that the store with name "<name>" is created
And I update store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
And The store with name "<name>" is updated successfully
And I delete the store that created with name "<name>"
Then The store deleted successfully from the application
Examples:
| name    | type     | address      | address2 |    city     | state   | zip    | lat  | lng | hours   |
| MineCan | BigBox2  | 20 Coventry  | CV 40    | Birmingham  |  Harrow |  54507 | 44   | 43  | Tue10to9 |
| ZingBan | BigBox1  | 30 Coventry  | CV 30    | Coventry    |  Wembly |  54505 | 45   | 48  | Fri10to9 |