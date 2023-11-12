<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Swap Mobile</title>
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
    <div class="container mt-3">
        <h2>Cadastramento de Usuario</h2>

        <form action="/usuario/incluir" method="post">


            <div class="mb-3 mt-3">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" value="Luis Silva" id="nome" placeholder="Entre com o seu nome" name="nome">
            </div>

            <div class="mb-3 mt-3">
                <label for="email">E-mail:</label>
                <input type="email" class="form-control" value="luis.rjunior@al.infnet.edu.br" id="email" placeholder="Entre com o seu e-mail" name="email">
            </div>

            <div class="mb-3">
                <label for="pwd">Senha:</label>
                <input type="password" class="form-control" value="luis.rjunior@al.infnet.edu.br" id="pwd" placeholder="Entre com a sua senha" name="senha">
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
</body>
</html>
