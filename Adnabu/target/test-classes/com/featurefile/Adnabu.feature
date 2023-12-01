@Adnabu
Feature: User test the Adnabu application

  @Scenario_1
  Scenario: User Search and Filter the product
    Given User launch the Adnabu appliction
    When User enter the keyword and search
    Then Verify that user should get related results
    When User click the Catalog button and select filter option
    Then Verify that user should get fitered results
    
    
  @Scenario_2
  Scenario: User Adding and Removing a product from the Shopping Cart
    When User goto the Homepage and click on a Product
    And User click the Add To Cart button
    Then Verify that product should added to the Cart page
    When User click the Remove button
    Then Verify that product should Removed from Cart page
    