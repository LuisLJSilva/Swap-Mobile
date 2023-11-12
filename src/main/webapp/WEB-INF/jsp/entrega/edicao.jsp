<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editar Entrega</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
    <style>
            .hero-section {
                background-color: #212529;
                padding: 50px 0;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            }
            /* Custom styles for the table */
            .table-custom {
                border-collapse: collapse;
                width: 100%;
                border: 1px solid #ddd;
            }
            .table-custom th {
                background-color: #0056b3;
                color: #ffcc00;
                text-align: center;
                padding: 14px;
                border: 1px solid #ddd;
            }
            .table-custom td {
                text-align: center;
                padding: 14px;
                border: 1px solid #ddd;
            }
            .table-custom tr:hover {
                background-color: #f5f5f5;
            }
        </style>
</head>
<body>
    <div class="container mt-3">
        <h2>Editar Entrega</h2>

        <form action="/entrega/${entrega.id}/editar" method="post">

        <c:import url="/WEB-INF/jsp/troca/edicao.jsp"/>

            <div class="mb-3">
                <label for="sedex">Entregue via Sedex:</label>
                 <select class="form-select" id="sedex" name="sedex">
                    <option value="true" ${entrega.sedex == true ? 'selected' : ''}>Sim</option>
                    <option value="false" ${entrega.sedex == false ? 'selected' : ''}>Nao</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="statusEntrega">Status da Entrega:</label>
                <select class="form-select" id="statusEntrega" name="statusEntrega">
                    <option value="Pendente" ${entrega.statusEntrega == 'Pendente' ? 'selected' : ''}>Pendente</option>
                    <option value="Enviado" ${entrega.statusEntrega == 'Enviado' ? 'selected' : ''}>Enviado</option>
                    <option value="Entregue" ${entrega.statusEntrega == 'Entregue' ? 'selected' : ''}>Entregue</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="enderecoEntrega">Endereço de Entrega:</label>
                <input type="text" class="form-control" id="enderecoEntrega" name="enderecoEntrega" value="${entrega.enderecoEntrega != null ? entrega.enderecoEntrega : 'Rua Fictícia, 123'}" placeholder="Digite o endereço de entrega">
            </div>

            <button type="submit" class="btn btn-primary">Salvar Alteracoes</button>
        </form>
    </div>
</body>
</html>
