package ru.eremin.enterprise.servlets;

import ru.eremin.enterprise.catalog.CatalogRepository;
import ru.eremin.enterprise.products.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/createCatalog")
public class CreateCatalogServlet extends HttpServlet {

    @Inject
    private CatalogRepository catalogRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("catalogRepository");
    }
}
