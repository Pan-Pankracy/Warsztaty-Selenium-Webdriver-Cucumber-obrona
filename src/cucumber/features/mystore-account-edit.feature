Feature: User account details edit

  Scenario: User adds first address to the account
    Given I'm on the mystore main page
    When I go to the signin page
    And I sign in with my credentials
    And I click on "ADDRESSES" card
#    And Create a new address
    And I fill in the address details Joshi Short street Norfolk 11111 and 111111111
    And I save the changes
    Then I can see the new address on the addresses page
    And Verify the created address "Joshi" "Josh Serpentine" "Short street" "Norfolk" "11111" "United Kingdom" and "111111111"


  Scenario Outline: User creates new address on his account with outline
    Given I'm on the mystore main page
    When I go to the signin page
    And I sign in with my credentials
    And I click on "ADDRESSES" card
    And I fill in the address details <alias> <address> <city> <postal code> and <phone>
    And I save the changes
    Then I can see the new address on the addresses page

    Examples:
      | alias     | address      | city    | postal code | phone     |
      | Joshi     | Short street | Norfolk | 11111       | 111111111 |
      | Joshy     | Long street  | Norfolk | 55555       | 999888777 |
      | Ungabunga | Black street | Wakanda | 99999       | 777777777 |


