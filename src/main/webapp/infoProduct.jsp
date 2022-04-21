<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  
 <!DOCTYPE html>
<html>
<head>
<link rel ="stylesheet" type="text/css"href ="${pageContext.request.contextPath}/css/style.css"/>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="card">
<div class="row">
 <div class="col-sm-10 col-md-3">
 <img alt="hinh" src="${product.getSrc()}" style="width:100%">
 </div>
 <div class=" col-sm-10 col-md-6">
 <h1 style="color:red">${product.getPrice()}</h1>
 <p>${product.getDescription()}</p>
 <form action="AddToCartController">
 	<input type="hidden" name="id" value="${product.getId()}">
 	<input type="hidden" name="action" value="add">
 	<button type="submit" style="color:white;background-color:orange;border-radius:5px">Add to cart</button>
 </form>
 </div>
 </div>
 </div>
 </div>
 <jsp:include page ="footer.jsp"/>
</body>
</html>