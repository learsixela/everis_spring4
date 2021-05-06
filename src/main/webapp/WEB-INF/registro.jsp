<jsp:include page='header.jsp'>
<jsp:param value="title" name="Sistema Web Everis"/>
</jsp:include>
<body>
	<div class="container col-lg-4">
		<%@ include file="navegacion.jsp" %>
		<form:form action="/guardar" method="post" modelAttribute="persona">
			<form:label class="" path="nombre">Nombre: </form:label>
			<form:input class="form-control mb-4" path="nombre"></form:input>
			
			<form:label path="apellido">Apellido: </form:label>
			<form:input class="form-control mb-4" path="apellido"></form:input>
		
			<form:label path="email">Email: </form:label>
			<form:input  class="form-control mb-4" path="email"></form:input>

			<form:label path="password">Password: </form:label>
			<form:password  class="form-control mb-4" path="password"></form:password>

			<form:label path="passwordConfirmation">password Confirmation: </form:label>
			<form:password  class="form-control mb-4" path="passwordConfirmation"></form:password>
			
			<input type="submit" value="Registrar!">
		</form:form>
	</div>
</body>
</html>