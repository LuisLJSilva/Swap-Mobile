<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edição de Telefone</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2>Edição de Telefone</h2>

        <form action="/novoTelefone/${novoTelefone.id}/editar" method="post">

        <c:import url="/WEB-INF/jsp/troca/edicao.jsp"/>

            <div class="mb-3">
                <label for="modelo">Modelo do Novo Telefone:</label>
                <select class="form-select" id="modelo" name="modelo">
                    <option value="Modelo A" ${novoTelefone.modelo == 'Modelo A' ? 'selected' : ''}>Modelo A</option>
                    <option value="Modelo B" ${novoTelefone.modelo == 'Modelo B' ? 'selected' : ''}>Modelo B</option>
                    <option value="Modelo C" ${novoTelefone.modelo == 'Modelo C' ? 'selected' : ''}>Modelo C</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="preco">Preço:</label>
                <input type="number" step="0.01" class="form-control" id="preco" value="${novoTelefone.preco}" name="preco">
            </div>

            <div class="mb-3">
                <label for="garantia">Duração da Garantia do Novo Telefone:</label>
                <input type="text" class="form-control" id="garantia" value="${novoTelefone.garantia}" name="garantia">
            </div>

            <button type="submit" class="btn btn-primary">Salvar Alteracoes</button>
        </form>
    </div>
</body>
</html>
