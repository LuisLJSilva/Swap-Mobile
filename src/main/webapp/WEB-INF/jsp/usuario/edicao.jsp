<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2>Editar Usuario</h2>

        <form action="/usuario/${usuario.id}/editar" method="post">

            <div class="mb-3">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" value="${usuario.nome}" placeholder="Digite o nome do usuario">
            </div>

            <div class="mb-3">
                <label for="email">E-mail:</label>
                <input type="email" class="form-control" id="email" name="email" value="${usuario.email}" placeholder="Digite o e-mail do usuario">
            </div>

            <div class="mb-3">
                <label for="senha">Senha:</label>
                <input type="password" class="form-control" id="senha" name="senha" value="${usuario.senha}" placeholder="Digite a nova senha">
            </div>

            <button type="submit" class="btn btn-primary">Salvar Alteracoes</button>
        </form>
    </div>
</body>
</html>
