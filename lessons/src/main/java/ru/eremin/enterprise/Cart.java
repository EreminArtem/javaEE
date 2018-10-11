package ru.eremin.enterprise;


import lombok.Getter;
import lombok.NonNull;
import ru.eremin.enterprise.products.Product;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Cart {

    @Getter
    private List<Product> cart;

    @Getter
    private BigDecimal amount;

    public Cart() {
        this.cart = new ArrayList<>();
        this.amount = new BigDecimal(0);
    }

    public void addProduct(@NonNull Product product) {
        this.cart.add(product);
        this.amount = this.amount.add(product.getCost());
    }

    public boolean removeProduct(@NonNull String art) {
        for (Product product : this.cart) {
            if (product.getArt().equals(art)) {
                this.cart.remove(product);
                this.amount = this.amount.subtract(product.getCost());
                return true;
            }
        }
        return false;
    }
}
