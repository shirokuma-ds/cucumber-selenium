package org.shirokuma.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.shirokuma.driver.DriverManager;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager;

    public BasePage(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebDriver driver() {
        return driverManager.driver();
    }

    public Wait<WebDriver> waitFor() {
        return new FluentWait<>(driver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }

    public void waitUntilPresence(By by) {
        waitFor().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilClickable(By by) {
        waitFor().until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilTextExist(By by) {
        waitFor().until(driver -> !driver.findElement(by).getText().isEmpty());
    }

}
