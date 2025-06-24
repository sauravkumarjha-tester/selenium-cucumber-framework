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
    public void user_enter_username_and_password(String username,String password) throws Exception{
        
        login.userEnterUsernameAndPassword(username,password);
        System.out.println("Inside Steps:- user enter username and password");
    }

    @And("click on login button")
    public void click_on_login_button() throws Exception{
        
        login.clickOnLoginButton();
        System.out.println("Inside Steps:- click on login button");
    }


    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page(){
    
    login.userIsNavigatedToTheHomePage();
        System.out.println("inside Steps:- user is navigated to the home page");
    }

}
