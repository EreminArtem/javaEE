package ru.eremin.enterprise.rest;

import ru.eremin.enterprise.catalog.CatalogRepository;
import ru.eremin.enterprise.enity.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@WebService
@Path("/rest")
@ApplicationScoped
public class RestService {

    @Inject
    private CatalogRepository repository;

    @GET
    @Path("/getAll")
    @WebMethod
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDTO> getAll() {
        List<CategoryDTO> resultList = new ArrayList<>();
        List<Category> categoryList = repository.findAll();
        for (Category category : categoryList) {
            resultList.add(new CategoryDTO(category.getId(), category.getName()));
        }
        return resultList;
    }

    @GET
    @Path("/getById")
    @WebMethod
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryDTO getById(@QueryParam("id") final String id) {
        Category category = repository.findCategoryById(id);
        return new CategoryDTO(category.getId(), category.getName());
    }

    @GET
    @Path("/addNew")
    @WebMethod
    @Consumes("text/plain")
    public void addNew(@QueryParam("name") String name) {
        repository.addCategory(name);
    }

    @GET
    @Path("/update")
    @WebMethod
    @Consumes("text/plain")
    public void update(@QueryParam("id") String id, @QueryParam("newName") String newName) {
        repository.update(id, newName);
    }

    @GET
    @Path("/delete")
    @WebMethod
    @Consumes("text/plain")
    public void delete(@QueryParam("id") String id) {
        repository.deleteCategoryById(id);
    }
}
