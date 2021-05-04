<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<input type="submit" value="Guardar Persona">
	</form>
	<br>
	<a href="/"> Home</a>
	</div>
</body>
</html>