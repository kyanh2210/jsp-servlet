<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel ="stylesheet" type="text/css"href ="${pageContext.request.contextPath}/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="left-col">
<div class="row">
<c:choose>
	<c:when  test="${fn:length(result)>0}">
	
	
		<c:forEach items="${result}" var="productn">

		<div class="card col-sm-12 col-md-4">
			<a style=" text-decoration: none;color:black;"href="InformationProductController?id=${productn.getId()}">
			<img alt="hinh" src="${productn.getSrc()}"style="width:100%">
			<p>${productn.getType().toUpperCase()}</p>
			<p>${productn.getName()}</p>
			<p style="color:red">${productn.getPrice()} $</p>
			</a>
		</div>
		</c:forEach>
		
		
	</c:when>

	<c:otherwise>
		<p> Product not found</p>
	</c:otherwise>
</c:choose>
</div>
</div>
<c:if test="${total-5>0}">
<a href="SearchController2?page=1&s=${search}">1</a>  
<c:if test="${total-5>=1}">
<a href="SearchController2?page=2&s=${search}">2</a> 
</c:if>
</c:if>
<jsp:include page ="footer.jsp"/>
</body>
</html>