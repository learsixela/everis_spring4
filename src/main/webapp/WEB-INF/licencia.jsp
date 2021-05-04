<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Licencia</title>
</head>
<body>
	<form action="/licencia/insertar" method="post">
	
		<label for="numero">Numero: </label>
		<input type="text" name="numero" id="numero">
		<br>
		<label for="activo">Activo : </label>
		<input type="radio" id="activo" name="estado" value="1"> 
		<label for="inactivo">Inactivo: </label>
		<input type="radio" id="inactivo" name="estado" value="0">
		<br>
		<label for="expiracion">Expiracion: </label>
		<input type="date" id="expiracion" name="expiracion">
		<br>
		<!-- lista de personas -->
		<label for="expiracion">Persona: </label>
		<select name="persona">
			<option value="0">Seleccione persona...</option>
			<c:forEach var="persona" items="${listaPersonas}">
				<option value="<c:out value="${persona.id}"></c:out>"><c:out value="${persona.nombre}"></c:out> </option>
			</c:forEach>
		</select>
		<br>
		<input type="submit" value="Insertar Licencia">
	</form>
	<br>
	<a href="/"> Home</a>
</body>
</html>