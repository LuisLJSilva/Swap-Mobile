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
		.hero-section h1, .hero-section p {
			color: #ffcc00;
		}
		.hero-section p {
			font-weight: bold;
		}
	</style>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container-fluid hero-section mt-5">
		<div class="row">
			<div class="col-md-8 offset-md-2 text-center">
				<h1>Swap Mobile <i class="fas fa-mobile-alt" style="color:#ffcc00;"></i></h1>
				<p class="lead">Sistema de Agendamento de Trocas de Aparelhos Usados por Novos</p>
			</div>
		</div>
	</div>

</body>
</html>
