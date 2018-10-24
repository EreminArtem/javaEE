package ru.eremin.enterprise.soap;

import ru.eremin.enterprise.catalog.CatalogRepository;
import ru.eremin.enterprise.enity.Category;
import ru.eremin.enterprise.rest.CategoryDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
@ApplicationScoped
public class SoapService {

    @Inject
    private CatalogRepository repository;

    @WebMethod
    public List<Category> getAll() {
        return repository.findAll();
    }
}
