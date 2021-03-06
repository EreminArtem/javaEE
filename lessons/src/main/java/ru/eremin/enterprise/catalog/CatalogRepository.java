package ru.eremin.enterprise.catalog;

import lombok.NonNull;
import ru.eremin.enterprise.enity.Category;
import ru.eremin.enterprise.interceptors.LogInterceptor;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
@Interceptors({LogInterceptor.class})
@ManagedBean(name = "catalogRepository")
public class CatalogRepository {

    @PersistenceContext
    EntityManager em;

    public List<Category> findAll() {
        return em.createQuery("SELECT e FROM Category e", Category.class).getResultList();
    }

    public void addCategory(final String name) {
        final Category category = new Category(name);
        em.persist(category);
    }

    public Category findCategoryById(@NonNull final String id) {
        return em.find(Category.class, id);
    }

    public void deleteCategoryById(@NonNull final String id) {
        final Category category = em.find(Category.class, id);
        em.remove(category);
    }

    public void update(@NonNull final String id, @NonNull final String newName) {
        final Category category = em.find(Category.class, id);
        category.setName(newName);
        em.merge(category);
    }
}
