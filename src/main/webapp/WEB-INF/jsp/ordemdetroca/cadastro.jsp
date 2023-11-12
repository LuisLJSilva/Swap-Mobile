<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cadastro de Ordem de Troca</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
        <style>
            body {
                background-color: #212529;
            }
            .container {
                background-color: #ffffff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            }
            h2 {
                color: #ffcc00;
            }
            label {
                color: #ffcc00;
            }
            .btn-primary {
                background-color: #0056b3;
                border-color: #0056b3;
            }
            .btn-primary:hover {
                background-color: #003f7d;
                border-color: #003f7d;
            }
        </style>
</head>
<body>

    <c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

    <div class="container mt-3">
        <form action="/ordemdetroca/incluir" method="post">
        <c:import url="/WEB-INF/jsp/troca/cadastro.jsp"/>

            <div class="mb-3">
                <label for="status">Status:</label>
                <input type="text" class="form-control" id="status" name="status" placeholder="Entre com o status" required>
            </div>

            <div class="mb-3">
                <label for="dataAgendamento">Data Agendamento:</label>
                <input type="datetime-local" class="form-control" id="dataAgendamento" name="dataAgendamento" required>
            </div>

            <div class="mb-3">
                <label>Urgente:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="urgenteSim" name="urgente" value="true"> Sim
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="urgenteNao" name="urgente" value="false" checked> Nao
                </div>
            </div>

            <div class="mb-3">
                <label for="cliente">Cliente:</label>
                <select id="cliente" name="cliente" class="form-control">
                    <c:forEach var="cliente" items="${clientes}">
                        <option value="${cliente.id}">${cliente.nome}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="trocas">Trocas:</label>
                <c:forEach var="troca" items="${trocas}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="troca${troca.id}" name="trocas" value="${troca.id}">
                        <label class="form-check-label" for="troca${troca.id}">${troca.tipoTroca}</label>
                    </div>
                </c:forEach>
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
</body>
</html>
