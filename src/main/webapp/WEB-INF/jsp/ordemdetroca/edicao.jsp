<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edição de Ordem de Troca</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilos adicionais, se necessário -->
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp"/>

    <div class="container mt-3">
        <h2>Edição de Ordem de Troca</h2>

        <form action="/ordemdetroca/${ordemDeTroca.id}/editar" method="post">
            <div class="mb-3">
                <label for="status">Status:</label>
                <input type="text" class="form-control" id="status" name="status" value="${ordemDeTroca.status}">
            </div>

            <div class="mb-3">
                <label for="dataAgendamento">Data Agendamento:</label>
                <input type="datetime-local" class="form-control" id="dataAgendamento" name="formattedDataAgendamento" value="${ordemDeTroca.dataAgendamento}">
            </div>

            <div class="mb-3">
                <label>Urgente:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="urgenteSim" name="urgente" value="true" ${ordemDeTroca.urgente ? 'checked' : ''}>
                    <label class="form-check-label" for="urgenteSim">Sim</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="urgenteNao" name="urgente" value="false" ${!ordemDeTroca.urgente ? 'checked' : ''}>
                    <label class="form-check-label" for="urgenteNao">Nao</label>
                </div>
            </div>

            <div class="mb-3">
                <label>Cliente:</label>
                <select name="clienteId" class="form-control">
                    <c:forEach var="cliente" items="${clientes}">
                        <option value="${cliente.id}" ${cliente.id == ordemDeTroca.cliente.id ? 'selected' : ''}>${cliente.nome}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Campo para selecionar trocas, se aplicável -->
            <!-- ... -->

            <button type="submit" class="btn btn-primary">Salvar Alterações</button>
        </form>
    </div>
</body>
</html>
