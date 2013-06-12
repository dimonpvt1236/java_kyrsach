<%-- 
    Document   : cart
    Created on : 23.05.2013, 9:55:15
    Author     : Starik
--%>
<%@page import="springmodel.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %> 
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
 <script language="JavaScript">
 
function change(qty, id)
 {
     qty.value = qty.value.replace (/\D/, '')
     document.getElementById(id).setAttribute("href", "cart.htm?id="+id+"&qty="+qty.value);
 
}
 </script>
<div class="content">
    <h1>Cart</h1>
<c:if test="${flag}">
<table class="cart">
    <tr class="head-cart">
       <td width="60%">Name</td>
        <td width="10%">Qty</td>
        <td width="10%"></td>
        <td width="20%">Price</td> 
    </tr>
    <% Integer i=0; %>
    <c:forEach items="${cartProd}" var="product">
        <% i++;
            String str="";
            if (i%2 == 0) {
                str="row";
            }
        %>
        
        <tr class="<%=str %>">
        <td><c:out value="${product.name}" /></td>
        <td><input type="text" value="<c:out value="${product.qty}" />" onkeyup="change(this, <c:out value="${product.id}" /> )" /></td>
        <td><a href="<c:url value="cart.htm?delete=${product.id}" />">Delete</a></br>
        <a id="<c:out value="${product.id}" />" href="<c:url value="cart.htm?id=${product.id}&qty=${product.qty}" />">Update</a></td>
        <td>$<c:out value="${product.price*product.qty}" /></td>
        </tr>
    </c:forEach >
    <% Double total=0.0; 
            List<Cart>  cart = (List<Cart>) request.getSession().getAttribute("cartProd");
            for (Cart prod:cart) {
                total = total + prod.getPrice()*prod.getQty();
            }

        %>
    <tr class="total">
        <td></td>
        <td></td>
        <td>Total: </td>
        <td>$<%=total %></td>
    </tr>
</table>
</br>
    <a href="<c:url value="order.htm" />" class="chekout-link"><div class="chekout">Checkout</div></a>
</c:if>
<c:if test="${!flag}">
    <h4>Cart is empty</h4>
    <a href="<c:url value="hello.htm" />" >Continue shopping</a>
</c:if>
    
    <br>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
