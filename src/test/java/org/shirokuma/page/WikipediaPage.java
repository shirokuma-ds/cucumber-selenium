package org.shirokuma.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.shirokuma.driver.DriverManager;

public class WikipediaPage extends BasePage {

    public WikipediaPage(DriverManager driverManager) {
        super(driverManager);
        PageFactory.initElements(driver(), this);
    }

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void typeIntoSearchInput(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
