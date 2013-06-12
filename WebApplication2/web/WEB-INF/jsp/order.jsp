<%-- 
    Document   : hello
    Created on : 15.05.2013, 23:53:12
    Author     : Starik
--%>

<%@page import="springmodel.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %> 
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<div class="content">
    <h1>Checkout</h1> 
<c:if test="${!sucs}">
    <c:if test="${!flag}">
        <c:redirect url="/hello.htm"/>
    </c:if>   
</c:if>   
    <div class="chekout-content">  
<c:if test="${sucs}">
    <p>Ordering is successful, your order number №<c:out value="${ord}" /> </p>
    <% 
        request.getSession().setAttribute("sucs", null); 
        request.getSession().setAttribute("ord", null); 

    %>
<br>
</c:if>
<c:if test="${loged}">
<c:if test="${flag}">   
    <h4>Information:</h4>
    <table border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" >Name:</td>
        <td >
          <c:out value="${user.name}" />
        </td>
    </tr>
    <tr>
      <td align="right" >Contry:</td>
        <td >
          <c:out value="${user.contry}" />
        </td>
    </tr>
    <tr>
      <td align="right" >Region:</td>
        <td >
          <c:out value="${user.region}" />
        </td>
    </tr>
    <tr>
      <td align="right" >City:</td>
        <td >
          <c:out value="${user.city}" />
        </td>
    </tr>
    <tr>
      <td align="right" >Address:</td>
        <td>
          <c:out value="${user.addres}" />
        </td>
    </tr>
    <tr>
      <td align="right" >Zip:</td>
        <td >
          <c:out value="${user.zip}" />
        </td>
    </tr>
    <tr>
      <td align="right" >Email:</td>
        <td >
          <c:out value="${user.mail}" />
        </td>
       
    </tr>
    <tr>
      <td align="right" >Phone:</td>
        <td>
          <c:out value="${user.phone}" />
        </td>
    </tr>
  </table>
    </br>
    <h4>Products:</h4>
    <table class="cart">
    <tr class="head-cart">
       <td width="60%">Name</td>
        <td width="10%">Qty</td>
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
            <td>Namr: <c:out value="${product.name}" /></td>
            <td>Qty: <c:out value="${product.qty}" /></td>
            <td>Price: <c:out value="${product.price*product.qty}" /></td>
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
            <td>Total: <%=total %></td>
        </tr>
    </table>
    <div class="text">Is your data and address that will be sent the goods.
Delivery is made by mail to the EMS. The item is paid for the acquisition, if no payment you will be blocked until pay.</div>
       <c:if test="${user_status}" >
            <a href="<c:url value="order.htm?order=place" />">Place Order</a>
       </c:if>
       <c:if test="${!user_status}" >
           <p>You were blocked for non-payment.</p>
       </c:if>
</c:if>

</c:if> 
<c:if test="${!loged}">
    To place orders please <a href="<c:url value="login.htm" />">login</a> to your account.
</c:if> 
</div>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>