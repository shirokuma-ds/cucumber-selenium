package org.shirokuma.step.saucedemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.shirokuma.data.saucedemo.User;
import org.shirokuma.page.saucedemo.LoginPage;

import java.util.Map;

public class LoginSteps {

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    private final LoginPage loginPage;

    @DataTableType
    public User userEntry(Map<String, String> mapEntry) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(mapEntry, User.class);
    }

    @Given("User open Swag Lab website")
    public void userOpenSwagLabWebsite() {
        loginPage.driver().get("https://www.saucedemo.com");
    }

    @And("User login to the website")
    public void userLoginToTheWebsite(User user) {
        loginPage.doLogin(user);
    }
}
