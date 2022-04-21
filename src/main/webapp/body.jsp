<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel ="stylesheet" type="text/css"href ="${pageContext.request.contextPath}/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="left-col">
<div class="row">
<c:forEach items="${products}" var="productn">

	<div class="card col-sm-12 col-md-4">
		<a style=" text-decoration: none;color:black;"href="InformationProductController?id=${productn.getId()}">
	<img alt="hinh" src="${productn.getSrc()}"style="width:100%">
	<p>${productn.getType().toUpperCase()}</p>
	<p>${productn.getName()}</p>
	<p style="color:red">${productn.getPrice()} $</p>
		</a>
	</div>

</c:forEach>
</div>
</div>
<a href="ListController?page=1">1</a>  
<a href="ListController?page=2">2</a>  
</body>
</html>