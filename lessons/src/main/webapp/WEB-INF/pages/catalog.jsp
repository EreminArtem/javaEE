<%@ page import="ru.eremin.enterprise.Constants" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.eremin.enterprise.products.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<%
    final Object catalogObject = request.getAttribute(Constants.CATALOG);
    final List<Product> catalog = (ArrayList<Product>) catalogObject;
%>

<% for (final Product product : catalog) { %>
<jsp:include page="productCard.jsp">
    <jsp:param name="productArt" value="<%=product.getArt()%>"/>
    <jsp:param name="productName" value="<%=product.getName()%>"/>
    <jsp:param name="productCost" value="<%=product.getCost().setScale(2, BigDecimal.ROUND_HALF_UP)%>"/>
</jsp:include>
<%} %>
<jsp:include page="footer.jsp"/>
