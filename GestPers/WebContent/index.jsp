<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link 
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>

<body style="background-color:lightblue;">

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous">
	</script>

	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.jsp">Gestione Persone</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="index.jsp">Inserisci/Elimina Utente</a>
					</li>
					<li class="nav-item"><a class="nav-link" href=Lettura?pagina=1>Lista Utenti</a>
					</li>

				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Cerca..." aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Cerca...</button>
				</form>
			</div>
		</div>
	</nav>
	
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	
<script type="text/javascript">
			var Msg ='<%=session.getAttribute("inserimento")%>';
			    if (Msg == "true") {
					 function alertName(){
						 Swal.fire(
				    		'Inserimento Riuscito!',
				    		'Persona inserita correttamente!',
				    		 'success'
				    		    )	
			 		 } 
			 	}
			    <%session.setAttribute("inserimento", false);%>
		</script> 
 
    	 <script type="text/javascript"> window.onload = alertName; </script>	
	



	
<hr>
&nbsp 
	<form action="Inserimento" method="POST" align="center">
		<h2>Inserimento</h2>
		Età: 
		<input type="number" name="eta" required/> <br> 
		Cognome:
		<input type="text" name="nome" required /> <br>
		Nome: 
		<input type="text" name="cognome" required/> <br>
		<input type="submit" value = "invia"/>
		
	</form>

&nbsp 
<hr>
&nbsp 
	<form action="Eliminazione" method="POST" align="center">
		<h2>Cancellazione</h2>
		Inserisci qui l'ID che vuoi cancellare 
		<label for="iddelete"> </label> 
		<input type="number" name="iddelete" required /> 
		<input type="submit" onclick="visualizzazioneTabella.jsp"/>
	</form>

<hr>
&nbsp 
	<form action="Lettura?pagina=0" method="POST" align="center">
		<h2>Visualizzazione</h2>
		Clicca qui per leggere gli elementi della tabella 
		<input type="submit"  onclick="Lettura?pagina=1" />
	</form>
	&nbsp 
<hr>

</body>
</html>