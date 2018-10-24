package ru.eremin.enterprise.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private String id;
    private String name;

    public CategoryDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
