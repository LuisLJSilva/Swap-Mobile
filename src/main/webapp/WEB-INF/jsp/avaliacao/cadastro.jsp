<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Troca de Telefones</title>
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
        <h2>Inclusao de Avaliacao de Telefone</h2>

        <form action="/avaliacao/incluir" method="post">

        <c:import url="/WEB-INF/jsp/troca/cadastro.jsp"/>

          <div class="mb-3">
            <label for="condicaoAparelho">Condicao do Aparelho:</label>
            <select class="form-select" id="condicaoAparelho" name="condicaoAparelho">
                <option value="Bom">Bom</option>
                <option value="Regular">Regular</option>
                <option value="Ruim">Ruim</option>
            </select>
          </div>

          <div class="mb-3">
            <label for="valorAvaliado">Valor Avaliado:</label>
            <input type="number" step="0.01" class="form-control" id="valorAvaliado" placeholder="Entre com o valor avaliado do telefone" name="valorAvaliado">
          </div>

          <div class="mb-3">
            <label for="observacoes">Observacoes:</label>
            <textarea class="form-control" id="observacoes" placeholder="Digite quaisquer observacoes sobre o telefone" name="observacoes"></textarea>
          </div>

          <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
</body>
</html>
