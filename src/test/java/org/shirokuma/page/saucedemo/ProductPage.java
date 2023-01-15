package org.shirokuma.page.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.shirokuma.data.saucedemo.Product;
import org.shirokuma.data.saucedemo.Products;
import org.shirokuma.driver.DriverManager;
import org.shirokuma.page.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductPage extends BasePage {
    public ProductPage(DriverManager driverManager, Products products) {
        super(driverManager);
        this.products = products;
        PageFactory.initElements(driver(), this);
    }

    private Products products;

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartBtn;

    private By itemsPath = By.className("inventory_item");
    private By itemNamePath = By.className("inventory_item_name");
    private By itemPricePath = By.className("inventory_item_price");

    public String getTitle() {
        return title.getText().trim();
    }

    public void clickCartBtn() {
        cartBtn.click();
    }

    public void selectItems(List<String> itemNameList) {
        List<WebElement> items = driver().findElements(itemsPath);
        List<Product> productList = new ArrayList<>();
        for (String itemName : itemNameList) {
            Optional<WebElement> optionalItem = items.stream()
                    .filter(el -> el.findElement(itemNamePath)
                            .getText().trim().equalsIgnoreCase(itemName))
                    .findFirst();

            if (!optionalItem.isPresent())
                throw new NotFoundException(itemName + " could not be found.");

            WebElement item = optionalItem.get();
            String name = item.findElement(itemNamePath).getText().trim();
            Double price = Double.parseDouble(item.findElement(itemPricePath).getText().replaceAll("\\$", "").trim());
            productList.add(Product.builder()
                    .name(name)
                    .price(price)
                    .build());
            item.findElement(By.className("pricebar")).findElement(By.tagName("button")).click();
        }
        products.setProducts(productList);
    }

}
