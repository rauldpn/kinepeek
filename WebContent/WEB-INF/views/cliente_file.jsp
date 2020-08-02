<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <title>Kinepeek - Ficha</title>
</head>
<body>

	<div align="center" style="padding:0 50px">
		<h2>Servicios</h2>
		<input type="button" class="btn btn-outline-dark btn-lg float-right" onclick="javascript:location.href='newService?clienteId=<c:out value="${servicios[0].getClienteId()}" /> '" value="Nuevo Servicio">
		<table class="table table-striped table-bordered table-hover table-sm">
		    <caption>Listado de Servicios del Cliente</caption>
			<thead  class="thead-dark">
				<tr>
					<th scope="col">Fecha</th>
					<th scope="col">Fisioterapeuta</th>
					<th scope="col">Descripción</th>
					<th scope="col">Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="servicio" items="${servicios}">
				<tr>
					<td scope="row">${servicio.getFecha()}</td>
					<td scope="row">${servicio.getFisioterapeuta()}</td>
					<td scope="row">${servicio.getDescripcion()}</td>
					<td scope="row">
						<input type="button" class="btn btn-primary btn-sm" onclick="javascript:location.href='editService?id=${servicio.getId()}'" value="Modificar">
						<input type="button" class="btn btn-secondary btn-sm" onclick="javascript:location.href='deleteService?id=${servicio.getId()}'" value="Borrar">
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<!-- 
	<div align="center">
		<h2>Servicios</h2>
		<h3><a href="newService?clienteId=<c:out value="${servicios[0].getClienteId()}" /> ">Nuevo Servicio</a></h3>
		<table border="1">
			<tr>
				<th>Fecha</th>
				<th>Fisioterapeuta</th>
				<th>Descripción</th>
				<th>Acción</th>
			</tr>
			<c:forEach var="servicio" items="${servicios}">
			<tr>
				<td>${servicio.getFecha()}</td>
				<td>${servicio.getFisioterapeuta()}</td>
				<td>${servicio.getDescripcion()}</td>
				<td>
					<a href="editService?id=${servicio.getId()}">Modificar</a>
					&nbsp;&nbsp;
					<a href="deleteService?id=${servicio.getId()}">Borrar</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
-->		
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>