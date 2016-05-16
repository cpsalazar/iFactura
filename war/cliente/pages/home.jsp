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
<body style="font-family: Exo">


	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="sidebar.jsp"%>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">


					<div id="facturasDiv">
						<div style="padding-left: 70px; padding-right: 70px;">
							<h2 style="text-align: -webkit-center; font-family: Fondamento;">Facturas
								Telefono</h2>
							<c:if test="${existenFacturasTelefono != null}">
								<%@ include file="facturastelefono.jsp"%>
							</c:if>
						</div>
					</div>
					<c:if test="${existenFacturasTelefono != null}">
						<canvas id="myChart"></canvas>
					</c:if>
					<c:if test="${existenFacturasTelefono == null}">
						<h5 style="text-align: -webkit-center; font-family: Fondamento;">!Añade
							una factura para empezar a usar iFactura!</h5>
					</c:if>


				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

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

	<script src="../../cliente/js/jquery.dataTables.js"></script>
	<script src="../../cliente/js/tablaFacturas.js"></script>
	<script src="../../cliente/js/pdf.js"></script>
	<script src="../../cliente/js/pdf.worker.js"></script>
	<script src="../../cliente/js/pdfparser.js"></script>
	<script src="../../cliente/js/chart.min.js"></script>
	<script src="../../cliente/js/graficos.js"></script>


</body>
</html>