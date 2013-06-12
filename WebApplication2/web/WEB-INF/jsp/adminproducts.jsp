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
    <h1>Products Manager</h1>
    <a href="<c:url value="priceincrease.htm" />" class="add"><div>Add new product</div></a>
    <br>
    <% Integer i=0; %>
    <table class="cart">
        <tr class="head-cart">
            <td>Id</td>
            <td>Name</td>
            <td>Description</td>
            <td>Price</td>
            <td></td>
            </tr>
        <c:forEach items="${products}" var="pr">
            <% i++;
                String str="";
                if (i%2 == 0) {
                    str="row";
                }
            %>

            <tr class="<%=str %>">
            <td><c:out value="${pr.id}" /></td>
            <td><c:out value="${pr.name}" /></td>
            <td><c:out value="${pr.description}" /></td>
            <td><c:out value="${pr.price}" /></td>
            <td><a href="<c:url value="priceincrease.htm?id=${pr.id}" />">Edit</a>
            </br><a href="<c:url value="adminproducts.htm?delete=1&id=${pr.id}" />">Delete</a></td>
            </tr>
        </c:forEach >
    </table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>