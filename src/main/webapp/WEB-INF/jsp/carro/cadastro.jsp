<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>App Montadora</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container mt-3">
    <h2>Cadastramento de Carros</h2>

    <form action="/carro/incluir" method="post">

        <div class="mb-3 mt-3">
            <label>Modelo:</label>
            <input type="text" class="form-control"
                   placeholder="Informe o modelo" name="modelo">
        </div>

        <div class="mb-3 mt-3">
            <label>Custo</label>
            <input type="text" class="form-control" value="0" placeholder="Informe o custo" name="custo">
        </div>
        <div class="mb-3 mt-3">
            <label>Cilindrada</label>
            <input type="text" class="form-control" value="0" placeholder="Informe a cilindrada" name="cilindrada">
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="arCondicionado" checked>
            <label class="form-check-label">Ar Condicionado</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="cambioAutomatico" checked>
            <label class="form-check-label">Cambio Automatico</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="eletrico" checked>
            <label class="form-check-label">Elétrico</label>
        </div>

        <div class="mb-3 mt-3">
            <label>Tipo Direção:</label>
            <input type="text" class="form-control" value="Hidraulica" placeholder="Informe o tipo de direção"
                   name="tipoDirecao">
        </div>

        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>
</body>
</html>