<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page
	import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iFactura2016</title>

<!-- Bootstrap Core CSS -->
<link href="../../cliente/css/bootstrap.min.css" rel="stylesheet">
<link href="../../cliente/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="../../cliente/css/jquery.dataTables.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../../cliente/css/simple-sidebar.css" rel="stylesheet">
<link href="../../cliente/css/style.css" rel="stylesheet">
<link href="../../cliente/css/animate.min.css" rel="stylesheet">
<link href="../../cliente/css/dataTables-custom.css" rel="stylesheet">


<link href='https://fonts.googleapis.com/css?family=Fondamento'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="../../cliente/css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet" href="../../cliente/css/faq-style.css">

</head>
<body style="font-family: 'Exo'">


	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="sidebar.jsp"%>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">


					<h2 style="font-family: Fondamento; text-align: center;">Ofertas
						Disponibles</h2>
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img class="img-responsive center-block"
									src="../../cliente/images/ofertas/oferta_movistar.jpg"
									alt="Movistar">
							</div>

							<div class="item">
								<img class="img-responsive center-block"
									src="../../cliente/images/ofertas/oferta_vodafone.jpg"
									alt="Vodafone">
							</div>

							<div class="item">
								<img class="img-responsive center-block"
									src="../../cliente/images/ofertas/oferta_orange.jpg"
									alt="Orange">
							</div>

						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" role="button"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
					<div style="text-align: center;">
						<p>Estas ofertas han sido seleccionadas para usted basandose
							en su consumo</p>
						<br> <br> <br>
						<p>Si desea recibir facturas personalizadas en su correo,
							pulse aquí</p>
						<input id="ofertas" class="btn" type="submit"
							value="Recibir Ofertas"> <br> <br> <br>
						<p>
							¿No encuentra ofertas interesantes?<a href=""> Pulse aquí
								para generar nuevas ofertas</a>
						</p>
					</div>

				</div>
				<!-- /#page-content-wrapper -->
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../../cliente/js/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="../../cliente/js/bootstrap.min.js"></script>
	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
	<script>
		$("#ofertas").click(function(e) {
			e.preventDefault();
			alert("Gracias, sus preferencias se han guardado");
		});
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js"></script>
	<script src="../../cliente/js/jquery.dataTables.js"></script>
	<script src="../../cliente/js/tablaFacturas.js"></script>
	<script src="../../cliente/js/pdf.js"></script>
	<script src="../../cliente/js/pdf.worker.js"></script>
	<script src="../../cliente/js/pdfparser.js"></script>
	<script src="../../cliente/js/chart.min.js"></script>
	<script src="../../cliente/js/graficos.js"></script>
</body>
</html>