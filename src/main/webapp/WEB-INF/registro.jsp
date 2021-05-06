<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</head>
<body>
<%@ include file="navegacion.jsp" %>
	<div class="container col-lg-4">
		
		<form:form action="/persona/guardar" method="post" modelAttribute="persona">
			<form:label path="nombre">Nombre: </form:label>
			<form:input path="nombre" class="form-control mb-4"></form:input>
			<br>
			<form:label path="apellido">Apellido: </form:label>
			<form:input class="form-control mb-4" path="apellido"></form:input>
			<br>
			<form:label path="email">Email: </form:label>
			<form:input  class="form-control mb-4" path="email"></form:input>
<br>
			<form:label path="password">Password: </form:label>
			<form:password  class="form-control mb-4" path="password"></form:password>
<br>
			<form:label path="passwordConfirmation">password Confirmation: </form:label>
			<form:password  class="form-control mb-4" path="passwordConfirmation"></form:password>
			<br>
			<input type="submit" value="Registrar!">
		</form:form>
	</div>
</body>
</html>