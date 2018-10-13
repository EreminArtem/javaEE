package ru.eremin.enterprise;

import lombok.Getter;
import lombok.NonNull;
import ru.eremin.enterprise.products.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Catalog {

    @Getter
    private List<Product> catalog;

    public Catalog() {
        this.catalog = new ArrayList<>();
    }

    public void addProduct(@NonNull Product product) {
        this.catalog.add(product);
    }

    public Product findByArt(String art) {
        for (Product product : catalog) {
            if (product.getArt().equals(art)) return product;
        }
        return null;
    }
}
