package org.shirokuma.data.saucedemo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String name;
    private Double price;
}
