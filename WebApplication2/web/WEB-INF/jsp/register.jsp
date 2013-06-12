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
  <form:form method="post" commandName="register" >
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Name:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
        <td width="60%">
          <form:errors path="name" cssClass="error"/>
        </td>
    </tr>
      <tr>
      <td align="right" width="20%">Login:</td>
        <td width="20%">
          <form:input path="login"/>
        </td>
        <td width="60%">
          <form:errors path="login" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Password:</td>
        <td width="20%">
          <form:input type="password" path="pass"/>
        </td>
        <td width="60%">
          <form:errors path="pass" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Comfirm Password:</td>
        <td width="20%">
          <form:input type="password" path="confirm_pass"/>
        </td>
        <td width="60%">
          <form:errors path="confirm_pass" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Contry:</td>
        <td width="20%">
          <form:input path="contry"/>
        </td>
        <td width="60%">
          <form:errors path="contry" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Region:</td>
        <td width="20%">
          <form:input path="region"/>
        </td>
        <td width="60%">
          <form:errors path="region" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">City:</td>
        <td width="20%">
          <form:input path="city"/>
        </td>
        <td width="60%">
          <form:errors path="city" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Address:</td>
        <td width="20%">
          <form:input path="addres"/>
        </td>
        <td width="60%">
          <form:errors path="addres" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Zip:</td>
        <td width="20%">
          <form:input path="zip"/>
        </td>
        <td width="60%">
          <form:errors path="zip" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Email:</td>
        <td width="20%">
          <form:input path="mail"/>
        </td>
        <td width="60%">
          <form:errors path="mail" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Phone:</td>
        <td width="20%">
          <form:input path="phone"/>
        </td>
        <td width="60%">
          <form:errors path="phone" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%"></td>
        <td width="20%">
          <input type="submit" align="center" value="Register">
        </td>
        <td width="60%">
        </td>
    </tr>
    
  </table>
  <br>
  
</form:form>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
