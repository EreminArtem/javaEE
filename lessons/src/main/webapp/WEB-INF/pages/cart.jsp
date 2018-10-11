<%@ page import="ru.eremin.enterprise.Constants" %>
<%@ page import="ru.eremin.enterprise.products.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<%
    final Object cartObject = request.getAttribute(Constants.CART);
    final List<Product> cart = (ArrayList<Product>) cartObject;
    final BigDecimal amount = (BigDecimal) request.getAttribute(Constants.AMOUNT);
%>

<% if (cart.isEmpty()) { %>
<h1>Cart Is Empty</h1>
<%} else {%>
<table>
    <caption>Your order</caption>
    <thead>
    <tr>
        <th>Art</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <tbody>
    <%for (final Product product : cart) {%>
    <tr>
        <td><%=product.getArt()%>
        </td>
        <td><%=product.getName()%>
        </td>
        <td><%=product.getCost().setScale(2, BigDecimal.ROUND_HALF_UP)%>
        </td>
        <td><a href="#">Remove</a></td>
    </tr>
    <%} %>
    <tr>
        <td colspan="3">Total Cost</td>
        <td><%=amount.setScale(2, BigDecimal.ROUND_HALF_UP)%>
        </td>
    </tr>
    </tbody>
    </thead>
</table>
<a href="order">
    <button>Order</button>
</a>
<%} %>

<jsp:include page="footer.jsp"/>

