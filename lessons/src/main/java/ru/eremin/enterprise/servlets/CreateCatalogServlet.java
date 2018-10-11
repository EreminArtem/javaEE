package ru.eremin.enterprise.servlets;

import ru.eremin.enterprise.Catalog;
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
    private Catalog catalog;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i < 9; i++) {
            catalog.addProduct(
                    new Product(
                            "Product " + System.currentTimeMillis(),
                            new BigDecimal(0 + (Math.random() * 100.00))));
        }
        resp.sendRedirect("catalog");
    }
}
