<%-- 
    Document   : cart
    Created on : 23.05.2013, 9:55:15
    Author     : Starik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %> 
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<div class="content">
    
  <form:form method="post" commandName="login" >
  <table width="50%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="left" >Login:</td>
        <td width="20%">
          <form:input path="login"/>
        </td>
        <td >
          <form:errors path="login" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="left" >Password:</td>
        <td width="20%">
          <form:input type="password" path="pass"/>
        </td>
        <td >
          <form:errors path="pass" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td></td>
        <td width="20%">
              <input type="submit" align="center" value="Login">
        </td>
        <td >
        <div class="reg"><a href="<c:url value="register.htm" />" >Register</a>  </div>
        </td>
    </tr>
  </table>
</form:form>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
