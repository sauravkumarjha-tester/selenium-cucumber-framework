package stepdefinitions;

import org.openqa.selenium.WebDriver;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();

    Login login;

    public LoginSteps() {
        login = new Login();
    }

    @When("^user enter (.*) and (.*)$")
    public void user_enter_username_and_password(String username, String password) throws Exception {
        login.userEnterUsernameAndPassword(username, password);
        // System.out.println("Inside Steps:- user enter username and password");
    }

    @And("click on login button")
    public void click_on_login_button() throws Exception {
        Thread.sleep(2000);
        login.clickOnLoginButton();
        // System.out.println("Inside Steps:- click on login button");
    }

    @Then("^user (.*) (.*) is navigated to the home page (.*)$")
    public void user_is_navigated_to_the_home_page(String username, String password, String expectedValue)
            throws Exception {
        if (username.equals("standard_user") || username.equals("problem_user")
                || username.equals("performance_glitch_user") || username.equals("error_user")
                || username.equals("visual_user") && password.equals("secret_sauce")) {
            String actualValue = driver.getCurrentUrl();
            login.userIsNavigatedToTheHomePage("User is navigated to the home page",
                    actualValue, expectedValue);
        } else if (username.equals("locked_out_user") && password.equals("secret_sauce")) {
            String actualValue = login.getText("locked_out_userer_errormessage");
            login.userIsNavigatedToTheHomePage("User is not navigated to the home page",
                    actualValue, expectedValue);
        }
    }
}