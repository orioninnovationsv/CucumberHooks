@wip
Feature: Login feature

  @login
  Scenario: Login with invalid credentials
    Given User on the trendyol website
    When user navigate login page
    And user enter username and password
    Then verify that unsuccessful login

  @smoke
  Scenario: navigate category
    Given User on the trendyol website
    When user navigate "Çocuk"


  @subCategory
  Scenario: navigate category
    Given User on the trendyol website
    When user navigate "Elbise" from "Çocuk"
