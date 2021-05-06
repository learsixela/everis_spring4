<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar Persona</title>
</head>
<body>
	<div>
		<form:form action="/" method="post" modelAttribute="persona">
			<form:label path="nombre">Nombre: </form:label>
			<form:input path="nombre"/>
			<br>
			<form:label path="apellido">Apellido: </form:label>
			<form:input path="apellido"/>
			<br>
			<form:label path="email">Email: </form:label>
			<form:input path="email"/>
			<br>
			<form:label path="password">Password: </form:label>
			<form:password path="password"/>
			<br>
			<form:label path="passwordConfirmation">password Confirmation: </form:label>
			<form:password path="passwordConfirmation"/>

			<input type="submit" value="Registrar!">
		</form:form>
		<br>
		<a href="/"> Home</a>
	</div>
</body>
</html>