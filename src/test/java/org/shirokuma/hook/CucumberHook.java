package org.shirokuma.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.shirokuma.driver.DriverManager;
import org.shirokuma.utils.PropertiesManager;

public class CucumberHook {

    public CucumberHook(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    private DriverManager driverManager;

    @Before
    public void setupDriver() {
        if (Boolean.parseBoolean(PropertiesManager.appProperties().get("browser.maximized").toString())) {
            driverManager.driver().manage().window().maximize();
        }
    }

    @After(order = 2)
    public void handleFailedScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driverManager.driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
            scenario.attach(driverManager.driver().getPageSource(), "text/xml", scenario.getName() + "2");
        }
    }

    @After(order = 1)
    public void cleanUp() {
        if (driverManager.driver() != null) {
            driverManager.driver().quit();
        }
    }

}
