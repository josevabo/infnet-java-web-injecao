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
	  <h3>Listagem de Veiculos:</h3>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Modelo</th>
	        <th>Custo</th>
	        <th>Qtd Lotes</th>
	      </tr>
	    </thead>
	    <tbody>
	   	    
	      <c:forEach var="v" items="${listaVeiculo}">
		      <tr>
		        <td>${v.id}</td>
		        <td>${v.modelo}</td>
		        <td>${v.custo}</td>
		        <td>${v.lotes.size()}</td>
		        <td><a href="/veiculo/${v.id}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	</div>
</body>
</html>