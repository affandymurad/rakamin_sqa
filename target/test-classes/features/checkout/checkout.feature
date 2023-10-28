#Author: affandymurad@gmail.com
Feature: Checkout Page Aplikasi Sauce Demo

  @Regression @Positive
  Scenario: Success Checkout
    Given Halaman login Sauce Demo
    When Input standard username
    And Input password
    And click login button
    Then User in dasboard page
    And User click cart button of first product
    And User click cart icon
    Then User in cart page
    And User click checkout button
    Then User in checkout page
    When Input firstname
    And Input lastname
    And Input Postal Code
    And User click continue button
    Then User in overview page

  @Regression @Negative
  Scenario: Failed Checkout
    Given Halaman login Sauce Demo
    When Input standard username
    And Input password
    And click login button
    Then User in dasboard page
    And User click cart button of first product
    And User click cart icon
    Then User in cart page
    And User click checkout button
    Then User in checkout page
    And User click continue button
    Then User get error prompt
