package org.shirokuma.page.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.shirokuma.data.saucedemo.Product;
import org.shirokuma.driver.DriverManager;
import org.shirokuma.page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(DriverManager driverManager) {
        super(driverManager);
    }

    private By itemsPath = By.className("cart_item");
    private By itemNamePath = By.className("inventory_item_name");
    private By itemPricePath = By.className("inventory_item_price");

    public List<Product> getCartItems() {
        List<Product> productList = new ArrayList<>();
        List<WebElement> items = driver().findElements(itemsPath);
        items.forEach(i -> {
            String name = i.findElement(itemNamePath).getText().trim();
            Double price = Double.parseDouble(i.findElement(itemPricePath).getText().replaceAll("\\$", "").trim());
            productList.add(Product.builder()
                    .name(name)
                    .price(price)
                    .build());
        });
        return productList;
    }

}
