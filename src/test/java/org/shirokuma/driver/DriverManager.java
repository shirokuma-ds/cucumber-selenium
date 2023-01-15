package org.shirokuma.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.shirokuma.utils.PropertiesManager;

public class DriverManager {

    private WebDriver driver;

    public DriverManager() {
        initDriver();
    }

    public void initDriver() {
        String browser = PropertiesManager.appProperties().get("driver.browser").toString().trim();
        if (browser.equalsIgnoreCase(Browser.FIREFOX.browserName())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase(Browser.OPERA.browserName())) {
            WebDriverManager.operadriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase(Browser.SAFARI.browserName())) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase(Browser.EDGE.browserName())) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        PageFactory.initElements(driver, this);
    }

    public WebDriver driver() {
        if (driver == null) {
            initDriver();
        }

        return driver;
    }

}
