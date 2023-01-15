package org.shirokuma.page.yugioh;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.shirokuma.driver.DriverManager;
import org.shirokuma.page.BasePage;

import java.util.List;

public class YugiOhPage extends BasePage {
    public YugiOhPage(DriverManager driverManager) {
        super(driverManager);
        PageFactory.initElements(driver(), this);
    }

    @FindBy(id = "index-search")
    private WebElement searchInput;

    private By cardGridEntriesPath = By.className("card-grid-entry");
    private By cardNamePath = By.id("card-name");

    public void typeIntoSearchInput(String keyword) {
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void clickCardEntry(int index) {
        waitUntilPresence(cardGridEntriesPath);
        waitUntilClickable(cardGridEntriesPath);
        driver().findElements(cardGridEntriesPath).get(index).click();
    }

    public String getCardName() {
        waitUntilPresence(cardNamePath);
        waitUntilTextExist(cardNamePath);
        return driver().findElement(cardNamePath).getText();
    }
}
