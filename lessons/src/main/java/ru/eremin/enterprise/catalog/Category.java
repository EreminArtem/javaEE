package ru.eremin.enterprise.catalog;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.eremin.enterprise.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {

    @Getter
    @Setter
    private String name;

    @Getter
    private String id;
    private List<Product> products;

    public Category(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        products = new ArrayList<>();
    }

    public List<Product> findAll() {
        return products;
    }

    public void addProduct(@NonNull Product product) {
        products.add(product);
    }

    public Product findByArt(String art) {
        for (Product product : products) {
            if (product.getArt().equals(art)) return product;
        }
        return null;
    }
}
