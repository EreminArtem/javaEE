package ru.eremin.enterprise.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Category {
    @Id
    @Getter
    @Setter

    private String id = UUID.randomUUID().toString();

    @Column
    @Getter
    @Setter
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
