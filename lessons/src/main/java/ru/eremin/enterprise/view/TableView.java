package ru.eremin.enterprise.view;

import ru.eremin.enterprise.catalog.CatalogRepository;
import ru.eremin.enterprise.enity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class TableView implements Serializable {

    @Inject
    private CatalogRepository repository;

    public List<Category> getCategories (){
        return repository.findAll();
    }

    public CatalogRepository getRepository() {
        return repository;
    }

    public void deleteCatalog(String id) {
        repository.deleteCategoryById(id);
    }

    public void onAddNew() {
        repository.addCategory("New Category");
    }

    public void update (String id, String newName){
        repository.update(id, newName);
    }
}
