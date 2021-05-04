<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Crear Producto</h2>
		<form action="/producto/insertar" method="post">
			<label for="nombre">Nombre Producto: </label>
			<input type="text" name="nombre" id="nombre">
			<br>
			<label for="desc">Desc Producto: </label>
			<input type="text" name="desc" id="desc">
				<br>
			<label for="precio">Precio Producto: </label>
			<input type="text" name="precio" id="precio">
			<input type="submit" value="agregar">
		</form>
		<br>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>accion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "producto" items="${listaProductos}">
				<tr>
				<td><c:out value="${producto.nombre}"></c:out></td>
				<td><c:out value="${producto.descripcion}"></c:out></td>
				<td><c:out value="${producto.precio}"></c:out></td>
				<td><a href="/producto/editar/${producto.id}">Editar</a></td>
				</tr>
				</c:forEach>
			</tbody>
</table>
	
	
	</div>
</body>
</html>