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
		body {
			background-color: #f9f9f9;
		}
		.container {
			background-color: #212529;
			padding: 20px;
			border-radius: 8px;
			box-shadow: 0 4px 6px rgba(0,0,0,0.1);
			color: #ffcc00;
		}
		h2 {
			color: #ffcc00;
		}
		label {
			color: #ffcc00;
		}
		.btn-primary {
			background-color: #ffcc00;
			border-color: #ffcc00;
			color: #212529;
		}
		.btn-primary:hover {
			background-color: #e6b800;
			border-color: #e6b800;
		}
	</style>
</head>
<body>
	<div class="container mt-3">
	  <h2>Autenticacao</h2>

	  <form action="/valida" method="post">

	    <div class="mb-3 mt-3">
	      <label for="email">E-mail:</label>
	      <input type="email" class="form-control" value="admin@admin.com" id="email" placeholder="Entre com o seu e-mail" name="email">
	    </div>

	    <div class="mb-3">
	      <label for="pwd">Senha:</label>
	      <input type="password" class="form-control" value="123" id="pwd" placeholder="Entre com a sua senha" name="senha">
	    </div>

	    <button type="submit" class="btn btn-primary">Acessar</button>
	  </form>
	</div>
</body>
</html>
