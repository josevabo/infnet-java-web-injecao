<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>Listagem de Fabricas</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h3>Fábricas: ${listagem.size()}</h3>

	  <h4><a href="/fabrica/cadastro">Nova Fábrica</a></h4>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Nome</th>
	        <th>Endereço</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
		  <c:forEach var="f" items="${listagem}">
		      <tr>
				<td>${f.id}</td>
		        <td>${f.nome}</td>
		        <td>${f.endereco}</td>
		        <td><a href="/fabrica/${f.id}/excluir">excluir</a></td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	</div>
</body>
</html>