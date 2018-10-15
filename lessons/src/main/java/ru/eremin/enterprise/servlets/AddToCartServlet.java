package ru.eremin.enterprise.servlets;

import ru.eremin.enterprise.Cart;
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

@WebServlet(urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {

    @Inject
    private Cart cart;

    @Inject
    private Catalog catalog;
    private Product product;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String art = req.getParameter(Constants.ART);
        product = catalog.findByArt(art);
        if (product == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        cart.addProduct(product);
        resp.sendRedirect("catalog");
    }
}
