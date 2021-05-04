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
		<form action="/persona/insertar" method="post">
			<label for="nombre">Nombre: </label>
			<input type="text" name="nombre" id="nombre">
			<br>
			<label for="apellido">Apellido: </label>
			<input type="text" name="apellido" id="apellido">
			<br>
					<br>
			<!-- lista de personas -->
			<label for="curso">Curso: </label>
			<select name="curso">
				<option value="0">Seleccione curso...</option>
				<c:forEach var="curso" items="${listaCursos}">
					<option value="<c:out value="${curso.id}"></c:out>"><c:out value="${curso.nombre}"></c:out> </option>
				</c:forEach>
			</select>
			<input type="submit" value="Guardar Persona">
		</form>
		<br>
		<a href="/"> Home</a>
	</div>
</body>
</html>