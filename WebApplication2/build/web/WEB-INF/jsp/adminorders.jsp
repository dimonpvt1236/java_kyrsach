<%-- 
    Document   : hello
    Created on : 15.05.2013, 23:53:12
    Author     : Starik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %> 
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<div class="content">
    <h1>Orders</h1>
    <table class="cart">
        <tr class="head-cart">
            <td>№ Order</td>
            <td>Date order</td>
            <td>Name User</td>
            <td>Total price</td>
            </tr>
        <% Integer i=0; %>
        <c:forEach items="${tabs}" var="tb">
            <% i++;
                String str="";
                if (i%2 == 0) {
                    str="row";
                }
            %>

            <tr class="<%=str %>">
            <td><c:out value="${tb.ordernumber}" /></td>
            <td><c:out value="${tb.data}" /></td>
            <td><c:out value="${tb.username}" /></td>
            <td><c:out value="${tb.total}" /></td>
            </tr>
        </c:forEach >
    </table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>