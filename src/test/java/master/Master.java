package master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;
import utils.LocatorReader;

public class Master {
   
    public WebDriver driver = DriverFactory.getDriver();

    public Master()  {
        // Constructor can be used for initialization if needed
        
    }
    
    private  String  initLocators(String locator) throws Exception {
        LocatorReader.loadLocatorProperties();
        String loc = LocatorReader.getLocatorProperty(locator);
        return loc;
    }

   public  By locator(String locator) throws Exception {
    String loc = null;
    try {
        loc = initLocators(locator);
    } catch (Exception e) {
        e.printStackTrace();
    } // get the actual locator string like "id=login-button"
    String[] locParts = loc.split("=");
    String name = locParts[0].toLowerCase();
    String value = locParts[1];

    switch (name) {
        case "id": return By.id(value);
        case "name": return By.name(value);
        case "xpath": return By.xpath(value);
        case "css": return By.cssSelector(value);
        case "class": return By.className(value);
        case "tag": return By.tagName(value);
        default:
            throw new IllegalArgumentException("Unsupported locator type: " + name);
    }
}

    public void click(String locator) throws Exception {
        WebElement element = driver.findElement(locator(locator));
        element.click();
    }

    public WebElement findElement(String locator) throws Exception {
        return driver.findElement(locator(locator));
        
    }
}

