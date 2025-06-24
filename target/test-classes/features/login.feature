Feature: feature to test login functionality

  Scenario Outline: check login is successful with valid credentials
    When user enter <username> and <password>
    And click on login button
    Then user is navigated to the home page

    Examples:
      | username | password |
      | standard_user    | secret_sauce    |

  Scenario Outline: check login functionality with invalid credentials
    When user enter <username> and <password>
    And click on login button
    Then user is navigated to the home page

    Examples:
      | username | password |
      | locked_out_user | secret_sauce |
      | problem_user | secret_sauce |
      | performance_glitch_user | secret_sauce |
      
