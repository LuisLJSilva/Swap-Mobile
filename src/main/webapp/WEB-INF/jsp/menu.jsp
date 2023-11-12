<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
  <style>
    .navbar, .nav-link {
      transition: background-color 0.3s, color 0.3s;
    }
    .navbar:hover, .nav-link:hover {
      background-color: #0056b3;
      color: #ffffff;
    }
    .navbar-dark .navbar-brand {
      color: #ffcc00;
      font-weight: bold;
    }
    .navbar-dark .navbar-nav .nav-link {
      color: #ffcc00;
    }
    .navbar-dark .navbar-nav .nav-link:hover {
      color: #ffffff;
    }
    .navbar-dark .navbar-nav .nav-link i {
      margin-right: 5px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/"><i class="fas fa-mobile-alt"></i> Swap Mobile</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav me-auto">
         <li class="nav-item">
          <a class="nav-link" href="/sobre"><i class="fas fa-info-circle"></i> Sobre </a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/usuario/lista"><i class="fas fa-user-friends"></i> Usuarios</a>
        </li>

       <c:if test="${not empty user}">

        <li class="nav-item">
          <a class="nav-link" href="/cliente/lista"><i class="fas fa-users"></i> Clientes </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/avaliacao/lista"><i class="fas fa-star-half-alt"></i> Avaliacao </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/entrega/lista"><i class="fas fa-truck"></i> Entrega </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/novoTelefone/lista"><i class="fas fa-phone"></i> Novo Telefone </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/troca/lista"><i class="fas fa-exchange-alt"></i> Trocas </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ordemdetroca/lista"><i class="fas fa-file-alt"></i> Ordem de Troca </a>
        </li>
       </c:if>
      </ul>
      <ul class="navbar-nav ms-auto">

        <c:if test="${empty user}">
        <li class="nav-item">
          <a class="nav-link" href="/usuario/cadastro"><i class="fas fa-user-plus"></i> Registrar-se </a>
          <a class="nav-link" href="/login"><i class="fas fa-sign-in-alt"></i> Login ${user.email}</a>
        </li>
        </c:if>

        <c:if test="${not empty user}">
        <li class="nav-item">
          <a class="nav-link" href="/logout"><i class="fas fa-sign-out-alt"></i> Logout ${user.email}</a>
        </li>
       </c:if>

      </ul>
    </div>
  </div>
</nav>

</body>
</html>
