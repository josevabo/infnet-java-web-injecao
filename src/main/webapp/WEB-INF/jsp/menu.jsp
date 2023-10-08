<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">App Montadora</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>
	  <c:if test="${not empty user}">
	      <li class="nav-item">
	        <a class="nav-link" href="/carro/lista">Carros</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/funcionario/lista">Funcionário</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/lote/lista">Lotes</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/fabrica/lista">Fábricas</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/veiculo/lista">Veículos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/onibus/lista">Ônibus</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/caminhao/lista">Caminhões</a>
	      </li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
	      <li><a href="/funcionario/cadastro"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      
      <c:if test="${not empty user}">
      	  <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout ${user.nome}</a></li>
      </c:if>
    </ul>
  </div>
</nav>