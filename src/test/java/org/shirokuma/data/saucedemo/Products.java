package org.shirokuma.data.saucedemo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Products {
    List<Product> products = new ArrayList<>();
}
