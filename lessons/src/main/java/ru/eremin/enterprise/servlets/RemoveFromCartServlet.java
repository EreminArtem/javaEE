package ru.eremin.enterprise.servlets;

import ru.eremin.enterprise.Cart;
import ru.eremin.enterprise.Constants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {

    @Inject
    private Cart cart;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String art = req.getParameter(Constants.ART);
        if (!cart.removeProduct(art)) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        resp.sendRedirect("cart");
    }
}
