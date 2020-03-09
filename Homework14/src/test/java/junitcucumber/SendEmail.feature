Feature: Send email

  Scenario: Test sending email
    Given I logged in the mailbox
    When I click 'Написать письмо' button
    When fill 'Кому' field
    When fill 'Тема' field
    When fill text field
    When click 'Отправить' button
    Then The screenshots are like the ones in the baseline