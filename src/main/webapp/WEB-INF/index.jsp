<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio::</title>
<% Integer registrado = (Integer) session.getAttribute("registrado"); %>
</head>
<body>
	<div>
		<c:if test="${registrado == 1 }">
			<a href="/licencia"> Nueva Licencia</a>
			<br>
			<a href="/categoria"> Nueva Categoria</a>
			<br>
			<a href="/producto"> Nueva Producto</a>
		</c:if>
		<c:if test="${registrado != 1}">
			<a href="/persona/registro"> Nueva Persona</a>
			<a href="/login"> Inicio Sesion</a>
		</c:if>
		
	</div>
</body>
</html>