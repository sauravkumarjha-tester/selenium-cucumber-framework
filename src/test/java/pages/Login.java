package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;
import master.Master;

public class Login {

    public WebDriver driver = DriverFactory.getDriver();
    Master master;
    public Login() {
        master = new Master();
    }
 
    public void userEnterUsernameAndPassword(String username,String password) throws Exception {
        
        // driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // driver.findElement(By.id("password")).sendKeys("secret_sauce");
        WebElement usernameField = master.findElement("username");
        usernameField.sendKeys(username);
        WebElement passwordField = master.findElement("password");
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton() throws Exception {
        master.click("loginButton");
        //driver.findElement(By.id("login-button")).click();
    }
    public void userIsNavigatedToTheHomePage() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("User is not navigated to the home page. Expected: " + expectedUrl + ", but got: " + actualUrl);
        }
    }

}
