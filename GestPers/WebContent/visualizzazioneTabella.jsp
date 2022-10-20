<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Persone</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>

<body style="background-color:lightblue;">

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    
    <nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="home.jsp">Gestione Persone</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">Inserisci/Elimina Utente</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="Lettura?pagina=0">Lista Utenti</a>
        </li>
       
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Cerca..." aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Cerca</button>
      </form>
    </div>
  </div>
</nav>

	<table border="5" cellspacing="0" cellpadding="30" align="center">
		<tr>
			<td><h5>ID</h5></td>
			<td><h5>NOME</h5></td>
			<td><h5>COGNOME</h5></td>
			<td><h5>ETA'</h5></td>
		</tr>

		<c:forEach items="${lista}" var="LetturaPersone">
			<tr>
				<td>${LetturaPersone.id}</td>
				<td>${LetturaPersone.nome}</td>
				<td>${LetturaPersone.cognome}</td>
				<td>${LetturaPersone.eta}</td>
				<td>
				<a href="Modifica?id=${LetturaPersone.id}&cognome=${LetturaPersone.cognome}&nome=${LetturaPersone.nome}&eta=${LetturaPersone.eta}" style="color:#0B4DA0">
						MODIFICA </a></td>
				<td><a href="Eliminazione?id=${LetturaPersone.id}" style="color:#D41E1E"> ELIMINA </a></td>
			</tr>
		</c:forEach>
	</table>
	

<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="Lettura?pagina=0">1</a></li>
    <li class="page-item"><a class="page-link" href="Lettura?pagina=3">2</a></li>
    <li class="page-item"><a class="page-link" href="Lettura?pagina=6">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    
  </ul>
</nav>

</body>

</html>