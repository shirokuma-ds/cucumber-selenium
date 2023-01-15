package org.shirokuma.step.saucedemo;

import io.cucumber.java.en.Then;
import org.shirokuma.data.saucedemo.Products;
import org.shirokuma.page.saucedemo.CartPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

public class CartSteps {

    public CartSteps(CartPage cartPage, Products products) {
        this.cartPage = cartPage;
        this.products = products;
    }

    private final CartPage cartPage;
    private Products products;

    @Then("user verify items in the cart")
    public void userVerifyItemsInTheCart() {
        assertThat(cartPage.getCartItems().toArray(), arrayContainingInAnyOrder(products.getProducts().toArray()));
    }
}
