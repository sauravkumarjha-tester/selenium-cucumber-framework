package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.SoftAssert;

public class Hooks {

    @Before
    public void setup() throws Exception {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        SoftAssert.assertAll();
    }
}
