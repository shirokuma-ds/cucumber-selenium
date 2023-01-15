package org.shirokuma.page.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.shirokuma.data.saucedemo.User;
import org.shirokuma.driver.DriverManager;
import org.shirokuma.page.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(DriverManager driverManager) {
        super(driverManager);
        PageFactory.initElements(driver(), this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void doLogin(User user) {
        usernameField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
    }

}
