@homepage
Feature: Anasayfa

  Scenario: Kullanici sayfaya giris yapar
    Given user "https://www.amazon.com.tr" logs in
    And confirms that it is on the amazon page and on the homepage
    And scroll to the bottom of the page and see the countries
    And Hakkımızda, Bizimle Para Kazanın, Amazon Ödeme Araçları, Size Yardımcı Olalım sections appear
    And backToTop click
    And clicks and verifies All
    And all click