<%-- 
    Document   : hello
    Created on : 15.05.2013, 23:53:12
    Author     : Starik
--%>

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
    <h1>Home page</h1>
    <div class="catalog">
         <% Integer i=1; 
            String str="";%>
     <c:forEach items="${mass[0]}" var="product">
         <% i++; %>
         <div class="product">
            <div class="image"><img src="<c:url value="${product.image}" />" /></div>
            <div class="name"> <c:out value="${product.name}" /></div>
            <div class="price">Price: <em>$<c:out value="${product.price}" /></em></div>
            <div class="desc">Description: <c:out value="${product.description}" /></div>
            <div class="addtocart">
            <input  type="text" value="1" onkeyup="change(this, <c:out value="${product.id}" /> )" />
            <a id="<c:out value="${product.id}" />" href="<c:url value="cart.htm?id=${product.id}&qty=1" />">Add to Cart</a>
            </div>
        </div>
        <% if (i%4==0) {
            str = "<div style='clear:both'> </div>";
            i=1;
        }%>
        <%=str %>
        <% str = "";%>
    </c:forEach> 
        <div style="clear:both"> </div>
    </div>
<br>
    
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>