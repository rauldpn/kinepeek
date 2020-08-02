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
  <title>Kinepeek - Cliente</title>
</head>
<body>
	<div align="center">
		<h1>Gestión de Clientes</h1>
		<form:form action="save" method="post" modelAttribute="cliente">
			<form:hidden path="id"/>
			<div style="padding:0 50px">
				<div class="form-group">
			    	<form:input path="Nombre" type="text" class="form-control" placeholder="Nombre"/>
			  	</div>
			  	<div class="form-group">
			    	<form:input path="Apellido" type="text" class="form-control" placeholder="Apellido"/>
			  	</div>
			  	<div class="form-group">
			    	<form:input path="FNacimiento" type="text" class="form-control" placeholder="Fecha de Nacimiento YYYY-MM-DD"/>
			  	</div>
			  	<div class="form-group">
			    	<form:input path="Email" type="text" class="form-control" placeholder="EMail"/>
			  	</div>
			  	<div class="form-group">
			    	<form:input path="Telefono" type="text" class="form-control" placeholder="Teléfono"/>
			  	</div>
			  	<button type="submit" class="btn btn-secondary btn-lg btn-block">Guardar</button>
		  	</div>
<!-- 		
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="Nombre"/></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><form:input path="Apellido"/></td>
			</tr>
			<tr>
				<td>Fecha Nacimiento:</td>
				<td><form:input path="FNacimiento"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="Email"/></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><form:input path="Telefono"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Guardar"/></td>
			</tr>
		</table>
 -->
		</form:form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>