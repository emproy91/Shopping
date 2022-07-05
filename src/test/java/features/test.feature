Feature: Buy five products

  Scenario: User unregistered buy in guest mode
    Given The user is navigates on the SUT page
    When Clik on guest mode
    When searches for soap
    When filter by cleanliness home
    When selects five items
    Then the user add it to the cart