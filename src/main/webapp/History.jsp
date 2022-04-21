<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Order id</th>
      <th scope="col">Amount</th>
      <th scope="col">Product</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${history}" var="pd">
    <tr>
      <td scope="row">${pd.getId()}</td>
      <td>${pd.getTotal()}</td>
      <td>${pd.getName()}</td>
      <td>${pd.getDay()}</td>
    </tr>
   </c:forEach>
</table>
<jsp:include page ="footer.jsp"/>
</body>
</html>