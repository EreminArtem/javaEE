package ru.eremin.enterprise.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@ToString
@EqualsAndHashCode
public class Product {

    @Getter
    private String art;

    @Getter
    private String name;

    @Getter
    private BigDecimal cost;

    public Product(@NonNull String name, @NonNull BigDecimal cost) {
        this.art = UUID.randomUUID().toString();
        this.name = name;
        this.cost = cost;
    }
}
