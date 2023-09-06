@search
Feature: search by categories in searcbox

  Scenario: Search by categories in searcbox
    Given user "https://www.amazon.com.tr" logs in
    And   From the All categories tab, click in order
    And   verify that it goes to the right category