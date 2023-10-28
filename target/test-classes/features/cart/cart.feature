#Author: affandymurad@gmail.com
Feature: Cart Aplikasi Sauce Demo

  @Regression @Positive
  Scenario: Add cart
    Given Halaman login Sauce Demo
    When Input standard username
    And Input password
    And click login button
    Then User in dasboard page
    And User click cart button of first product
    And User check cart number is increasing

  @Regression @Negative
  Scenario: Remove Cart
    Given Halaman login Sauce Demo
    When Input standard username
    And Input password
    And click login button
    Then User in dasboard page
    And User click cart button of first product
    And User click remove button of first product
    And User check cart number is decreasing
