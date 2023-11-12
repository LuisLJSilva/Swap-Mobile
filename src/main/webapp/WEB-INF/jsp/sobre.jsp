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
        <div class="row">
            <div class="col-md-8 offset-md-2 text-center">
                <h2 style="color: #ffcc00;">${projeto.nome} - ${projeto.descricao}</h2>

                <c:forEach var="c" items="${projeto.classes}">
                    <p style="color: #ffcc00;">${c.nome}</p>
                    <table class="table table-custom table-bordered">
                        <thead>
                            <tr>
                                <th>Campo</th>
                                <th>Tipo</th>
                                <th>Descricao</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="a" items="${c.atributos}">
                                <tr>
                                    <td>${a.nome}</td>
                                    <td>${a.tipo}</td>
                                    <td>${a.descricao}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
