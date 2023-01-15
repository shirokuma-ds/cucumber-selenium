package org.shirokuma.step.saucedemo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.shirokuma.page.saucedemo.ProductPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ProductSteps {

    public ProductSteps(ProductPage productPage) {
        this.productPage = productPage;
    }

    private final ProductPage productPage;

    @Then("User should see the products page")
    public void userShouldSeeTheProductsPage() {
        assertThat(productPage.getTitle(), equalToIgnoringCase("products"));
    }

    @When("User add the following items to the cart")
    public void userAddTheFollowingItemsToTheCart(DataTable dataTable) {
        List<String> productNameList = dataTable.asList(String.class);
        productPage.selectItems(productNameList);
    }

    @And("User click the cart button")
    public void userClickTheCartButton() {
        productPage.clickCartBtn();
    }

}
