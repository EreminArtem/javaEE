package ru.eremin.enterprise.catalog;

import lombok.NonNull;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Stateless
@ManagedBean(name = "catalogRepository")
public class CatalogRepository {

    @PersistenceContext
    EntityManager em;

    public List<Category> findAll() {
        return em.createQuery("SELECT e FROM Category e", Category.class).getResultList();
    }

    public void addCategory(String name) {
        Category category = new Category(name);
        em.persist(category);
    }

    public Category findCategoryById(@NonNull final String id) {
        return em.find(Category.class, id);
    }

    public void deleteCategoryById(@NonNull final String id) {
        Category category = em.find(Category.class, id);
        em.remove(category);
    }

    public void update(@NonNull final String id, @NonNull final String newName) {
        Category category = em.find(Category.class, id);
        category.setName(newName);
        em.refresh(category);
    }
}
