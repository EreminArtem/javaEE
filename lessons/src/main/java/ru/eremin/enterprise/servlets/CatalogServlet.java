package ru.eremin.enterprise.servlets;

import ru.eremin.enterprise.Catalog;
import ru.eremin.enterprise.Constants;
import ru.eremin.enterprise.products.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    @Inject
    private Catalog catalog;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Product> catalogList = catalog.getCatalog();
        req.setAttribute(Constants.CATALOG, catalogList);
        req.getRequestDispatcher("WEB-INF/pages/catalog.jsp").forward(req, resp);
    }
}
