@homepage
Feature: Homepage

    Scenario: Login to Amazon and verify
    Given user "https://www.amazon.com.tr" logs in
    And confirms that it is on the amazon page and on the homepage

    Scenario: Verify the countries down the page
    Given user "https://www.amazon.com.tr" logs in
    And scroll to the bottom of the page and see the countries
    And clicks on individual countries

    Scenario: Hakkımızda, Bizimle Para Kazanın, Amazon Ödeme Araçları, Size Yardımcı Olalım verify
    Given user "https://www.amazon.com.tr" logs in
    And Hakkımızda, Bizimle Para Kazanın, Amazon Ödeme Araçları, Size Yardımcı Olalım sections appear

    Scenario: Back to top must be clickable
    Given user "https://www.amazon.com.tr" logs in
    And backToTop click

    Scenario: Clicks and verifies all categories
    Given user "https://www.amazon.com.tr" logs in
    And clicks and verifies All

    Scenario: Tümü - Merhaba Giriş Yapın
    Given user "https://www.amazon.com.tr" logs in
    And all click
    And Hello, sign in clicks and hello sign in that it is redirected to the login page

    Scenario: Tümü - Öne Çıkanlar
    Given user "https://www.amazon.com.tr" logs in
    And all click
    And Clicks and verifies the tabs of the highlights section