
@smoke @login
Feature: Login Feature

	@positive
  Scenario: Verify valid login
    Given I open the login page
   	When I login using username "tomsmith" and password "SuperSecretPassword!"
    Then I should be navigated to the dashboard
