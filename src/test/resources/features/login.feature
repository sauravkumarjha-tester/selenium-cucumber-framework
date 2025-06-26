Feature: feature to test login functionality

@test
  Scenario Outline: check login is successful with valid credentials
    When user enter <username> and <password>
    And click on login button
    Then user <username> <password> is navigated to the home page <expectedValue>

    Examples:
      | username | password |expectedValue|
      | standard_user    | secret_sauce    |https://www.saucedemo.com/inventory.html|
      | performance_glitch_user | secret_sauce | https://www.saucedemo.com/inventory.html|
      | problem_user | secret_sauce | https://www.saucedemo.com/inventory.html|
      | locked_out_user | secret_sauce |Epic sadface: Sorry, this user has been locked out.|
      | error_user | secret_sauce | https://www.saucedemo.com/inventory.html|
      | visual_user | secret_sauce | https://www.saucedemo.com/inventory.html|

      
      
      
