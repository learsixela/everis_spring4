<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio::</title>
</head>
<body>
	<div>

		<c:if test="${registrado}">
			
			<br>
			<a href="/licencia"> Nueva Licencia</a>
			<br>
			<a href="/categoria"> Nueva Categoria</a>
			<br>
			<a href="/producto"> Nueva Producto</a>
		</c:if>
		<c:if test="${!registrado}">
			<a href="/persona"> Nueva Persona</a>
			<a href="/login"> Nueva Login</a>
		</c:if>
	</div>
</body>
</html>