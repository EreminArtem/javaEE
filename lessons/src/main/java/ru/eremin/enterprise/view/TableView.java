package ru.eremin.enterprise.view;

import ru.eremin.enterprise.catalog.CatalogRepository;
import ru.eremin.enterprise.catalog.Category;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class TableView implements Serializable {
    private List<Category> categories;

    @ManagedProperty("#{catalogRepository}")
    @Inject
    private CatalogRepository repository;

    @PostConstruct
    public void init() {
        categories = repository.getCatalog();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public CatalogRepository getRepository() {
        return repository;
    }

    public void deleteCatalog(String id) {
        System.out.println("delete");
        repository.deleteCategoryById(id);
    }

    public void onAddNew() {
        repository.addCategory("New Category");
    }
}
