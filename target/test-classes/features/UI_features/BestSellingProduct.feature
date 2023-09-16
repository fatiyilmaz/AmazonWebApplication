@search
Feature:Top Ten Best Selling Products
  Scenario: Click on the products in the Categories section
    Given  user "https://www.amazon.com.tr" logs in
    Then   click on the products in the Categories section
    And    lists the top twenty best-selling products
    And    listed products are printed to excel file