package org.shirokuma.page.bulbapedia;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.shirokuma.driver.DriverManager;
import org.shirokuma.page.BasePage;

public class BulbapediaPage extends BasePage {
    public BulbapediaPage(DriverManager driverManager) {
        super(driverManager);
        PageFactory.initElements(driver(), this);
    }

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "mw-searchButton")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@title='Pokémon category']/preceding-sibling::big//b")
    private WebElement pokemonName;

    public String getPokemonName() {
        return pokemonName.getText();
    }

    public void typeIntoSearchInput(String keyword) {
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void clickSearchButton() {
//        searchButton.click();
    }
}
