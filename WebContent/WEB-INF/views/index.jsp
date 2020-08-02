<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <title>Kinepeek</title>
</head>
<body>
	<h1 align="center">Kinepeek</h1>
	<div align="center" style="padding:0 50px">
		<h2>Clientes</h2>
		<!--h3><a href="new">Nuevo Cliente</a></h3-->
		<input type="button" class="btn btn-outline-dark btn-lg float-right" onclick="javascript:location.href='new'" value="Nuevo Cliente">
		<table class="table table-striped table-bordered table-hover table-sm">
		    <caption>Listado de Clientes</caption>
			<thead  class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">F. Nacimiento</th>
					<th scope="col">EMail</th>
					<th scope="col">Teléfono</th>
					<th scope="col">Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td scope="row">${cliente.getId()}</td>
					<td scope="row">${cliente.getNombre()}</td>
					<td scope="row">${cliente.getApellido()}</td>
					<td scope="row">${cliente.getFNacimiento()}</td>
					<td scope="row">${cliente.getEmail()}</td>
					<td scope="row">${cliente.getTelefono()}</td>
					<td scope="row">
						<!--
						<a href="edit?id=${cliente.getId()}">Modificar</a>
						&nbsp;&nbsp;
						<a href="delete?id=${cliente.getId()}">Borrar</a>
						&nbsp;&nbsp;
						<a href="file?id=${cliente.getId()}">Servicios</a>
						-->
						<input type="button" class="btn btn-primary btn-sm" onclick="javascript:location.href='edit?id=${cliente.getId()}'" value="Modificar">
						<input type="button" class="btn btn-secondary btn-sm" onclick="javascript:location.href='file?id=${cliente.getId()}'" value="Servicios">
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>