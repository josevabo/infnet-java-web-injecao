<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>App Montadora</title>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container-fluid mt-3">
	  <h3>Listagem de carros:</h3>
	  <h4><a href="/carro/cadastro">Novo Carro</a></h4>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Modelo</th>
	        <th>Custo</th>
	        <th>Cilindrada (cc)</th>
	        <th>Automático</th>
	        <th>Ar Condicionado</th>
	        <th>Direção</th>
	        <th>Elétrico</th>
	      </tr>
	    </thead>
	    <tbody>
	   	    
	      <c:forEach var="c" items="${listaCarro}">
		      <tr>
		        <td>${c.id}</td>
		        <td>${c.modelo}</td>
		        <td>${c.custo}</td>
		        <td>${c.cilindrada}</td>
		        <td>${c.cambioAutomatico}</td>
		        <td>${c.arCondicionado}</td>
		        <td>${c.tipoDirecao}</td>
		        <td>${c.eletrico}</td>
		        <td><a href="/carro/${c.id}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	</div>
</body>
</html>