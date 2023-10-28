#Author: affandymurad@gmail.com
Feature: Product Page Aplikasi Sauce Demo

  @Regression @Positive
  Scenario: Success Product Thumbnail
    Given Halaman login Sauce Demo
    When Input standard username
    And Input password
    And click login button
    Then User in dasboard page
    And User check second product thumbnail
    Then User click second product
    And User check product thumbnail is same

  @Regression @Negative
  Scenario: Failed Product Thumbnail
    Given Halaman login Sauce Demo
    When Input visual username
    And Input password
    And click login button
    Then User in dasboard page
    And User check first product thumbnail
    Then User click first product
    And User check product thumbnail is different