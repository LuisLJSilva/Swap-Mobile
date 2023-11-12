<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editar de Avaliacao de Telefone</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2>Editar de Avaliacao de Telefone</h2>

        <form action="/avaliacao/${avaliacao.id}/editar" method="post">

        <c:import url="/WEB-INF/jsp/troca/edicao.jsp"/>

            <div class="mb-3">
                <label for="condicaoAparelho">Condicao do Aparelho:</label>
                <select class="form-select" id="condicaoAparelho" name="condicaoAparelho">
                    <option value="Bom" ${avaliacao.condicaoAparelho == 'Bom' ? 'selected' : ''}>Bom</option>
                    <option value="Regular" ${avaliacao.condicaoAparelho == 'Regular' ? 'selected' : ''}>Regular</option>
                    <option value="Ruim" ${avaliacao.condicaoAparelho == 'Ruim' ? 'selected' : ''}>Ruim</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="valorAvaliado">Valor Avaliado:</label>
                <input type="number" step="0.01" class="form-control" id="valorAvaliado" value="${avaliacao.valorAvaliado}" placeholder="Entre com o valor avaliado do telefone" name="valorAvaliado">
            </div>

            <div class="mb-3">
                <label for="observacoes">Observacoes:</label>
                <textarea class="form-control" id="observacoes" placeholder="Digite quaisquer observações sobre o telefone" name="observacoes">${avaliacao.observacoes}</textarea>
            </div>

            <button type="submit" class="btn btn-primary">Salvar Alteracoes</button>
        </form>
    </div>
</body>
</html>
