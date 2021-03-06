@all
Feature: Test inbox page

  Scenario: Test checkboxes marking on inbox page
    When I click the checkbox
    Then Checkmarks next to emails are displayed

  Scenario: Test checkboxes unmarking on inbox page
    When I click the checked checkbox
    Then Checkmarks next to emails are not displayed

  Scenario: Test sending email to the group of people
    When I click the "Написать письмо" button
    And Fill the "Кому", "Тема" and text fields with valid data
    And Click "Отправить" button
    Then "Письмо отправлено" notification appears