 <%@ include file="/WEB-INF/jsp/include.jsp" %> 
 <%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<div class="content">
 <script language="JavaScript">
 
function Validate()
 {
   var image =document.getElementById("image").value;
     if(image!=''){
            var checkimg = image.toLowerCase();
          if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
                 alert("Please enter Image File Extensions .jpg,.png,.jpeg");
                 document.getElementById("image").focus();
               return false;
             }
     }
    return true;
}
function onlyDigits(el) {
      el.value = el.value.replace(/[^\d\.]/g, "");
      if(el.value.match(/\./g).length > 1) {
        el.value = el.value.substr(0, el.value.lastIndexOf("."));
      }
    }
 </script>
<style>
.error {
    color: #ff0000;
}
 
.errorblock {
    color: #000;
    background-color: #ffEEEE;
    border: 3px solid #ff0000;
    padding: 8px;
    margin: 16px;
}
</style>   
 
<h1>Add or Editing product</h1>
<a href="<c:url value="adminproducts.htm"/>" class="add"><div>Back</div></a>
<form:form method="post" commandName="priceIncrease" enctype="multipart/form-data" onsubmit="return Validate();">
  <table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <form:input path="id" type="hidden" />
    <form:input path="image" type="hidden" />
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
      <td align="right" width="20%">Price:</td>
        <td width="20%">
            <form:input path="price" onkeyup="onlyDigits(this)"/>
        </td>
        <td width="60%">
          <form:errors path="price" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Description:</td>
        <td width="20%">
          <form:textarea  path="description"/>
        </td>
        <td width="60%">
          <form:errors path="description" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Qty:</td>
        <td width="20%">
          <form:input path="qty" onkeyup="this.value = this.value.replace (/\D/, '')"/>
        </td>
        <td width="60%">
          <form:errors path="qty" cssClass="error"/>
        </td>
    </tr>
    <c:if test="${image}">
    <tr>
      <td>
      </td>
      <td>
          <img src="<c:url value="${priceIncrease.image}" />" width="200px"/>
          <p>To change the image, simply select a new image file.</p>
        </td>
        <td>
        </td>
    </tr>
    
    </c:if>
    <tr>
      <td align="right" width="20%">Image:</td>
        <td width="20%">
          <form:input id="image" type="file" path="file"/>
        </td>
        <td width="60%">
          <form:errors path="file" cssClass="error"/>
        </td>
    </tr>
     <tr>
      <td align="right" width="20%"></td>
        <td width="20%">
              <input type="submit" align="center" value="Execute">
        </td>
        <td width="60%">
        </td>
    </tr>
  </table>
  <br>

</form:form>

</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>