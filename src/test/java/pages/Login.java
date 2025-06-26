package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;
import master.Master;
import utils.SoftAssert;

public class Login {

    public WebDriver driver = DriverFactory.getDriver();
    Master master;
    public Login() {
        master = new Master();
    }
 
    public void userEnterUsernameAndPassword(String username,String password) throws Exception {
        
        WebElement usernameField = master.findElement("username");
        usernameField.sendKeys(username);

        WebElement passwordField = master.findElement("password");
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() throws Exception {
        
        master.click("loginButton");
        
    }
    public void userIsNavigatedToTheHomePage(String description,String actualValue,String expectedValue) throws Exception {
        master.validateResult(description, actualValue, expectedValue);
    }

    public String getText(String locator) throws Exception {
      return master.findElement(locator).getText();
        //return element.getText();
    }

}
