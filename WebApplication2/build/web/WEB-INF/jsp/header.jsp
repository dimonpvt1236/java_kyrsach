<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
<!--        <base href="http://localhost:8080/WebApplication2/" />-->
    </head>
    <body>
        <div class="body">
            <header>
        <div class="head">
        <div class="top-menu" >
            <ul>
                <li><a href="<c:url value="hello.htm" />" >Home</a></li>
                <c:if test="${menu}">
                <li><a href="<c:url value="adminorders.htm" />" >Orders</a></li>
                <li><a href="<c:url value="adminusers.htm" />" >Users</a></li>
                <li><a href="<c:url value="adminproducts.htm" />" >Products Manager</a></li>
                </c:if>   
                <li><a href="<c:url value="cart.htm" />" >Cart</a></li>
                <c:if test="${loged}">
                <li><a href="<c:url value="hello.htm?logout=1" />" >Logout</a> (<c:out value="${user_name}" />)</li>
                </c:if>    
                <c:if test="${!loged}">
                <li><a href="<c:url value="login.htm" />" >Login</a></li>
                </c:if>   
            </ul>
            
        </div>    
        </div>
        </header>
                