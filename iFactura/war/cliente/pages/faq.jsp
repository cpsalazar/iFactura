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
</head>
<body>
	<div class="bodyHome"></div>


	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="sidebar.jsp"%>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">Lorem fistrum te voy a borrar el cerito te va
					a hasé pupitaa sexuarl apetecan caballo blanco caballo negroorl ese
					hombree apetecan mamaar hasta luego Lucas ese que llega. Mamaar al
					ataquerl por la gloria de mi madre diodeno va usté muy cargadoo no
					te digo trigo por no llamarte Rodrigor no te digo trigo por no
					llamarte Rodrigor pupita va usté muy cargadoo. Ahorarr a peich me
					cago en tus muelas se calle ustée me cago en tus muelas por la
					gloria de mi madre ese hombree fistro. Quietooor qué dise usteer
					está la cosa muy malar quietooor. Jarl al ataquerl ese hombree a
					peich diodenoo. A wan tiene musho peligro va usté muy cargadoo
					quietooor caballo blanco caballo negroorl diodenoo. Ese pedazo de
					sexuarl por la gloria de mi madre no te digo trigo por no llamarte
					Rodrigor ese pedazo de papaar papaar sexuarl benemeritaar torpedo
					pupita ese hombree. Ese pedazo de condemor condemor ese que llega
					ese que llega. Caballo blanco caballo negroorl benemeritaar no te
					digo trigo por no llamarte Rodrigor a peich va usté muy cargadoo
					pecador diodeno me cago en tus muelas. Jarl al ataquerl te va a
					hasé pupitaa diodenoo sexuarl ese hombree. Qué dise usteer qué dise
					usteer diodenoo va usté muy cargadoo me cago en tus muelas
					benemeritaar. Está la cosa muy malar jarl caballo blanco caballo
					negroorl ahorarr ese pedazo de no te digo trigo por no llamarte
					Rodrigor fistro te voy a borrar el cerito te va a hasé pupitaa ese
					pedazo de. No te digo trigo por no llamarte Rodrigor la caidita
					caballo blanco caballo negroorl benemeritaar a peich al ataquerl
					benemeritaar diodenoo qué dise usteer torpedo está la cosa muy
					malar. Papaar papaar ese que llega sexuarl pecador va usté muy
					cargadoo apetecan ahorarr tiene musho peligro. Apetecan no te digo
					trigo por no llamarte Rodrigor me cago en tus muelas apetecan no te
					digo trigo por no llamarte Rodrigor por la gloria de mi madre
					caballo blanco caballo negroorl quietooor tiene musho peligro
					mamaar mamaar. Benemeritaar tiene musho peligro se calle ustée qué
					dise usteer de la pradera ese hombree sexuarl la caidita papaar
					papaar está la cosa muy malar ese pedazo de. Hasta luego Lucas está
					la cosa muy malar ahorarr qué dise usteer a gramenawer ahorarr ese
					hombree amatomaa te voy a borrar el cerito quietooor sexuarl. Está
					la cosa muy malar ese pedazo de se calle ustée llevame al sircoo.</div>
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

</body>
</html>