<%@ page import="ru.eremin.enterprise.Constants" %>
<%@ page import="ru.eremin.enterprise.products.Product" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<%
    final Product product = (Product) request.getAttribute(Constants.PRODUCT);
%>
<h3><%=product.getArt()%></h3>
<h2><%=product.getName()%></h2>
<h3><%=product.getCost().setScale(2, BigDecimal.ROUND_HALF_UP)%></h3>
<jsp:include page="footer.jsp"/>
