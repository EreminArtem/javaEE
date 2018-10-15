package ru.eremin.enterprise.servlets;

import ru.eremin.enterprise.catalog.CatalogRepository;
import ru.eremin.enterprise.Constants;
import ru.eremin.enterprise.products.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Inject
    private CatalogRepository catalogRepository;
    private Product product;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String art = req.getParameter(Constants.ART);
//        product = catalogRepository.findByArt(art);
//        if (product == null) {
//            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }
//        req.setAttribute(Constants.PRODUCT, product);
        req.getRequestDispatcher("WEB-INF/pages/product.jsp").forward(req, resp);
    }
}
