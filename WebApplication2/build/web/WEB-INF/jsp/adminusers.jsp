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
    <h1>Users</h1>
    <table class="cart">
        <tr class="head-cart">
            <td>Id</td>
            <td>Name</td>
            <td>Login</td>
            <td>Status</td>
            <td></td>
            </tr>
            <% Integer i=0; %>
        <c:forEach items="${users}" var="us">
            <% i++;
                String str="";
                if (i%2 == 0) {
                    str="row";
                }
            %>

            <tr class="<%=str %>">
            <td><c:out value="${us.id}" /></td>
            <td><c:out value="${us.name}" /></td>
            <td><c:out value="${us.login}" /></td>
            <td><c:if test="${us.status}">Actived</c:if><c:if test="${!us.status}">Banned</c:if></td>
            <td><c:if test="${us.status}"><a href="<c:url value="adminusers.htm?status=0&id=${us.id}" />">Bann</a></c:if><c:if test="${!us.status}"><a href="<c:url value="adminusers.htm?status=1&id=${us.id}" />">Unbann</a></c:if></td>
            </tr>
        </c:forEach >
    </table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>