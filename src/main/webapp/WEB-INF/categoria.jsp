<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categoria:.</title>
</head>
<body>
	<div>
	<h2>Crear Categoria</h2>
	<form action="/categoria/insertar" method="post">
		<label for="nombre">Nombre Categoria: </label>
		<input type="text" name="nombre" id="nombre">
		<input type="submit" value="agregar cat">
	</form>
	
	</div>
</body>
</html>