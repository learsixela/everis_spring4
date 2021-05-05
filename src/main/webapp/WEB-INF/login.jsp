<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div>
	<form action="/persona/login" method="post">
			<label for="email">Email: </label>
			<input type="text" name="email" id="email">
			<br>
			<label for="password">Password: </label>
			<input type="text" name="password" id="password">
			<br>
			<input type="submit" value="Login">
	</form>
	<c:out value="${mensaje}"></c:out>
	</div>
</body>
</html>