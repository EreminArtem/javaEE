package ru.eremin.enterprise.catalog;

import lombok.Getter;
import lombok.NonNull;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.*;

@ManagedBean(name = "catalogRepository")
@ApplicationScoped
public class CatalogRepository {

    @Getter
    private List<Category> catalog;

    public CatalogRepository() {
        catalog = new ArrayList<>();
    }

    public void addCategory(String name) {
        catalog.add(new Category(name));
    }

    public Category findCategoryById(String id) {
        for (Category category: catalog) {
            if(id.equals(category.getId())){
                return category;
            }
        }
        return null;
    }

    public void deleteCategoryById(@NonNull String id){
        catalog.remove(findCategoryById(id));
    }
}
