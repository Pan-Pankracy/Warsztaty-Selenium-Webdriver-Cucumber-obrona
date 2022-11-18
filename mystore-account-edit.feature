Feature: User account details edit

  Scenario: User creates new address on his account
    Given I'm on the mystore main page
    When I go to the signin page
    And I sign in with my credentials
    And I click on "ADDRESSES" card
    And I fill in the address details (alias), (address), (city), (zip/postal code), (phone)
    And I save the changes
    Then I can see the new address on the addresses page

  @create
  Scenario Outline: User creates new address on his account with outline
    Given I'm on the mystore main page
    When I go to the signin page
    And I sign in with my credentials
    And I click on "ADDRESSES" card
    And I fill in the address details alias <alias>, address <address>, city <city>, zip/postal code <zip/postal code and phone <phone>
    And I save the changes
    Then I can see the new address on the addresses page

    Examples:
      | alias | address      | city       | zip/postal code | phone     |
      | JJ    | Flatstreet 1 | Birmingham | 12345           | 123456789 |


