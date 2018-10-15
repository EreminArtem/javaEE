package ru.eremin.enterprise.servlets;

import ru.eremin.enterprise.Cart;
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

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    @Inject
    private Cart cart;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Product> cartList = cart.getCart();
        req.setAttribute(Constants.CART, cartList);
        req.setAttribute(Constants.AMOUNT, cart.getAmount());
        req.getRequestDispatcher("WEB-INF/pages/cart.jsp").forward(req, resp);
    }
}
