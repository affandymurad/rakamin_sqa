#Author: affandymurad@gmail.com
Feature: Login Page Aplikasi Sauce Demo

  @Regression @Positive
  Scenario: Success Login
    Given Halaman login Sauce Demo
    When Input username
    And Input password
    And click login button
    Then User in dasboard page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman login Sauce Demo
    When Input username
    And Input invalid password
    And click login button
    Then User get error message

  @TDD
  Scenario Outline: User login to Sauce Demo
    Given Halaman login Sauce Demo
    When I input <username> as username
    And I input <password> as password
    And click login button
    Then user verify <status> login result

    Examples: 
      | username      | password     | status  |
      | standard_user | secret_sauce | success |
      | wrong_user    | secret_sauce | failed  |
