package master;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;
import utils.AssertReader;
import utils.ConfigReader;
import utils.LocatorReader;
import utils.SoftAssert;

public class Master {

    public WebDriver driver = DriverFactory.getDriver();

    public Master() {
        // Constructor can be used for initialization if needed

    }

    private String initLocators(String locator) throws Exception {
        LocatorReader.loadLocatorProperties();
        String loc = LocatorReader.getLocatorProperty(locator);
        return loc;
    }

    public By locator(String locator) throws Exception {
        String loc = null;
        try {
            loc = initLocators(locator);
        } catch (Exception e) {
            e.printStackTrace();
        } // get the actual locator string like "id=login-button"
        String[] locParts = loc.split(">");
        String name = locParts[0].toLowerCase();
        String value = locParts[1];

        switch (name) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "xpath":
                return By.xpath(value);
            case "css":
                return By.cssSelector(value);
            case "class":
                return By.className(value);
            case "tag":
                return By.tagName(value);
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + name);
        }
    }

    public void initAssertFile(String assertFile) throws Exception {
        AssertReader.loadAssertReader(assertFile);
    }

    public String getAssert(String assertFile, String key) throws Exception {
        initAssertFile(assertFile);
        String value = AssertReader.getAssertProperties(key);
        if (value == null) {
            throw new Exception("Assertion key '" + key + "' not found in file '" + assertFile + "'");
        }
        return value;
    }

    public Wait<WebDriver> getWait() {
        return new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("webdriver.timeout=30"))));
    }

    public void click(String locator) throws Exception {
        WebElement element = driver.findElement(locator(locator));
        element.click();
    }

    public WebElement findElement(String locator) throws Exception {
        return driver.findElement(locator(locator));

    }

    public void validateResult(String description, String actualValue, String expectedValue) throws Exception {
        try {
            SoftAssert.getSoftAssert()
                    .assertThat(actualValue)
                    .as(description)
                    .isEqualTo(expectedValue);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(
                    "Validation failed: " + description + ". Expected: " + expectedValue + ", but got: " + actualValue);
        }
    }

    // public static void main(String[] args) throws Exception {
    // Master master = new Master();
    // System.out.println("Master class initialized successfully."+
    // master.getAssert("homepage_assert", "page"));
    // }
}
