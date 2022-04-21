<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<c:if test="${cart.size()>0}">
<table class="table">
  <thead>
    <tr>
      <th scope="col">Products in cart:${cart.size()}</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${cart.getItems()}" var="pd">
    <tr>
      <td scope="row">${pd.getName()}</td>
      <td>${pd.getPrice()}</td>
      <td>${pd.getNumber()}</td>
      <td>
      <fmt:setLocale value = "en_US"/>
      <fmt:formatNumber type="currency" value="${pd.getPrice()*pd.getNumber()}"  maxFractionDigits = "2"/></td>
    <td>
    <form action="AddToCartController">
   		<input type="hidden" name="action" value="delete">
   		<input type="hidden" name="id" value ="${pd.getId()}">
   		<button type="submit">Remove</button>
    </form>
    </td>
    </tr>
   </c:forEach>
   	<tr>
   		<td>Total</td>
   		<td></td>
   		<td></td>
   		<td>
   		<fmt:setLocale value = "en_US"/>
      <fmt:formatNumber type="currency" value="${cart.getAmount()}"  maxFractionDigits = "2"/></td>
   	</tr>
  </tbody>
</table>
<form action="PayController">
<label style="width:200px">Customer name</label>
<input type="text" name="name" required><br>
<label style="width:200px">Customer address</label>
<input type="text" name="address" required><br>
<label style="width:200px">Discount code(if any)</label>
<input type="text" name="discount"><br>
<button type="submit" style="color:white;background-color:orange">Submit</button>
</form>
</c:if>
<jsp:include page ="footer.jsp"/>
</body>
</html>