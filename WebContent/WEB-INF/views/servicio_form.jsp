<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <title>Kinepeek - Servicios</title>
</head>
<body>

	<div align="center">
		<h1>Servicios de Clientes</h1>
		<form:form action="saveService" method="post" modelAttribute="servicio">
			<form:hidden path="id"/>
			<form:hidden path="clienteId"/>
			<div style="padding:0 50px">
				<div class="form-group">
			    	<form:input path="Fecha" type="text" class="form-control" placeholder="Fecha YYYY-MM-DD"/>
			  	</div>
			  	<div class="form-group">
			    	<form:input path="Fisioterapeuta" type="text" class="form-control" placeholder="Fisioterapeuta"/>
			  	</div>
			  	<div class="form-group">
			    	<form:input path="Descripcion" type="text" class="form-control" placeholder="Descripción"/>
			  	</div>
			  	<button type="submit" class="btn btn-secondary btn-lg btn-block">Guardar</button>
		  	</div>
		</form:form>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
	
</body>
</html>