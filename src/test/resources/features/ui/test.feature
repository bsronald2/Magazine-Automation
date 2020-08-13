@ui
Feature: Automate 3 scenarios for Trivago Magazine
    Preconditions: All scenarios start on Trivago Home Magazine.
    PostConditions: Refresh Browser and Navigate home page.


  @HomePage
  Scenario Outline: : Navigate to a destination through the menu on the top left
    When I navigate to destination "<destination>" through menu
    Then I verify that the correct destination page is displayed
      Examples:
      | destination |
      | Southwest   |
      | Northwest   |

  @CloseChildWindows @HomePage
  Scenario: Fill in the contact form and send it
    Given I navigate to "Contact" page using footer link
    When I fill out the contact form
      |            | message            | fullname    | email                       |
      | ContactA   | I would like to..  | Tester User | r.butron.projects@gmail.com |
      And I submit the form
    Then The following message should be displayed "Message Sent Successfully!"

  @Home
  Scenario: Verify that the links in homepage are working
    When I am in homepage
    Then I verify that all links are working