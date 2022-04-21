<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"/>
	<form action="Register"  >
	<label style="width:200px">Username</label>
		<input  type="email" id="email" pattern=".+@+.+.com"  required name="username"><br>
			<label style="width:200px">Password</label>
		<input id="pss" type="password" name="password" required><br>
			<label style="width:200px">Name</label>
		<input type="text" name="name" required><br>
		<label style="width:200px">Address</label>
		<input type="text" name="address" required><br>
		<label style="width:200px">Phone Number</label>
		<input type="text" name="phone" required><br>
		<button type="submit">Submit</button>
	</form>

<jsp:include page ="footer.jsp"/>

</body>
</html>