<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edicao de Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2>Edicao de Cliente</h2>

        <form action="/cliente/${cliente.id}/editar" method="post">

            <div class="mb-3">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" value="${cliente.nome}" placeholder="Digite o nome do cliente">
            </div>

            <div class="mb-3">
                <label for="cpf">CPF:</label>
                <input type="text" class="form-control" id="cpf" name="cpf" value="${cliente.cpf}" placeholder="Digite o CPF do cliente">
            </div>

            <div class="mb-3">
                <label for="email">E-mail:</label>
                <input type="email" class="form-control" id="email" name="email" value="${cliente.email}" placeholder="Digite o e-mail do cliente">
            </div>

            <button type="submit" class="btn btn-primary">Salvar Alteracoes</button>
        </form>
    </div>
</body>
</html>
