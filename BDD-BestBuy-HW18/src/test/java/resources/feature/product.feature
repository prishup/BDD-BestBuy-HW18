Feature: Testing crud on bestbuy product


  Scenario Outline: Product CRUD Operation
    Given Best buy application is running
    When I create a new product by providing the information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    And I verify that the product with name "<name>" is created
    And I update product by providing the information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    And The product with name "<name>" is updated successfully
    And I delete the product that created with name "<name>"
    Then The product deleted successfully from the application
    Examples:
      | name   | type   | price | shipping | upc    | description | manufacturer | model | url    | image  |
      | Laptop | String | 1000  | 50       | dpd    | tfyhgvhhgh  | Company1     | HP    | String | String |
      | Camera | String | 2000  | 40       | amazon | ghjbvjvbjb  | Company2     | Canon | String | String |

