<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="ISO-8859-1">
    <title>Swap Mobile</title>
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
    <c:import url="/WEB-INF/jsp/menu.jsp"/>

    <div class="container-fluid hero-section mt-5">
        <h3 style="color: #ffcc00;">Listagem de Usuarios:</h3>
        <h5><a href="/usuario/cadastro">Incluir Usuarios</a></h5>

        <table class="table table-custom table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Senha</th>
                    <th>Clientes</th>
                    <th>Trocas</th>
                    <th>Ordem de Troca</th>
                    <th>Acoes</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${listaUsuario}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.nome}</td>
                        <td>${u.email}</td>
                        <td>${u.senha}</td>
                        <td>${u.clientes.size()}</td>
                        <td>${u.trocas.size()}</td>
                        <td>${u.ordemDeTroca.size()}</td>
                        <td>
                            <a href="/usuario/${u.id}/editar" style=class="text-success">editar</a>
                            |
                            <a href="/usuario/${u.id}/excluir" class="text-danger">excluir</a>

                         </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
