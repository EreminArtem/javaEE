package ru.eremin.enterprise.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @Getter
    @Setter
    private String id = UUID.randomUUID().toString();

    @Getter
    @Setter
    @ManyToOne
    private Category category;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private BigDecimal cost;



}
