<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<link rel ="stylesheet" type="text/css"href ="${pageContext.request.contextPath}/css/style.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="header">
 <div class="left d-none d-lg-block">
 <h1>PRJ321x</h1>
 <p>Welcome to my Website</p>
 </div>
  <form action="SearchController2" method="POST">
<div class="right col-lg-8 col-md-12">
<div class="container ">
<div class="input-group mb-3">

    <div class="input-group-text p-0">
   
        <select class="form-select form-select-lg shadow-none bg-light border-0">
            <option>Categories</option>
            <option>Iphone</option>
            <option>Iphone</option>
            <option>Iphone</option>
            <option>Iphone</option>
        </select>
    </div>
    <c:set var ="a" value="${search}"></c:set>
    <input type="text" class="form-control" placeholder="Search Here" name="s" value ="${a}">
    <button type="submit" class="input-group-text shadow-none px-4 btn-warning">
       <span class="material-icons">search</span>
    </button>

</div>
</div>
</div>
</div>
	    </form>
<div class="clear"></div>
<div class = "topnav">
<a href="${pageContext.request.contextPath}">Home</a>
<a href="#">Products</a>
<a href="#">About us</a>
<a href="Register.jsp" style = "float:right">Register</a>
<a id= "log"href="#" style = "float:right">Login</a>

</div>
<div id="loginform" style="background-color:#1d2e4a;border-radius:10px;display:none;float:right;width:750px" >
<div  style="float:left;width:50%">
<jsp:include page="login.jsp"></jsp:include>
</div>
<div class="text-center" style="color:white;padding-top:150px; ">
<h1 style="">Welcome Back!</h1>
<p >To keep connected with us<br> please login with your personal <br>info</p>
</div>
</div>
<div style="clear:both;content:"";"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

$("#log").click(function(){
	$("#loginform").toggle();
})
$
</script>

</body>
</html>