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

<link rel="stylesheet" href="../../cliente/css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet" href="../../cliente/css/faq-style.css">

<link href='https://fonts.googleapis.com/css?family=Fondamento'
	rel='stylesheet' type='text/css'>
<!-- Resource style -->
<script src="../../cliente/js/modernizr.js"></script>
<!-- Modernizr -->

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

					<h2 style="text-align: -webkit-center; font-family: Fondamento;">FAQ</h2>


					<section class="cd-faq">

						<!-- cd-faq-categories -->

						<div class="cd-faq-items">
							<ul id="basics" class="cd-faq-group">
								<li class="cd-faq-title"><h2>Sobre nosotros</h2></li>
								<li><a class="cd-faq-trigger" href="#0">¿Quiénes somos?</a>
									<div class="cd-faq-content">
										<p>Somos el equipo de iFactura, un grupo de ingenieros
											dispuestos a facilitar su tarea de administración y gestión
											de facturas.</p>
									</div> <!-- cd-faq-content --></li>

								<li><a class="cd-faq-trigger" href="#0">Misión</a>
									<div class="cd-faq-content">
										<p>Comprometernos con nuestros clientes, ofreciéndoles la
											posibilidad de almacenar, organizar y consultar sus facturas.
											Además contamos con un sistema de calidad y confianza que
											analiza los datos almacenados de sus facturas para poder
											proponer cambios en sus ofertas con el fin de ocasionarle un
											ahorro considerable.</p>
									</div> <!-- cd-faq-content --></li>

								<li><a class="cd-faq-trigger" href="#0">Visión</a>
									<div class="cd-faq-content">
										<p>Ser la empresa reconocida como líder a nivel nacional
											en el desarrollo, calidad e innovación de soluciones para
											factura electrónica, que permita a nuestros clientes un
											ahorro económico.</p>
									</div> <!-- cd-faq-content --></li>

								<li><a class="cd-faq-trigger" href="#0">Valores</a>
									<div class="cd-faq-content">
										<p>
											CONFIABILIDAD. Seguridad y calidad en la funcionalidad y
											eficiencia de los productos y servicios que ofrecemos a
											nuestros clientes. Confianza en nuestro personal.<br>
											RAPIDEZ. Desarrollar soluciones en poco tiempo y calidad de
											producto.<br> HONESTIDAD. Actuar sin engaños, con
											rectitud y honradez, para fomentar la confianza de nuestros
											clientes en los productos y servicios que ofrecemos, así como
											la confianza dentro del equipo de trabajo.<br>
											EFICIENCIA. Lograr nuestro objetivo principal de satisfacer y
											cubrir íntegramente las necesidades de nuestros clientes.<br>
											INNOVACIÓN. Generar nuevos productos y servicios que agilicen
											los procesos operacionales de las Empresas, utilizando
											nuestra tecnología.<br> TRABAJO EN EQUIPO. Unificar
											fuerzas y lograr objetivos comunes. Compartir
											responsabilidades y éxitos.
										</p>
									</div> <!-- cd-faq-content --></li>
							</ul>
							<!-- cd-faq-group -->

							<ul id="mobile" class="cd-faq-group">
								<li class="cd-faq-title"><h2>Uso de la aplicación</h2></li>
								<li><a class="cd-faq-trigger" href="#0">¿Cómo subo una
										factura?</a>
									<div class="cd-faq-content">
										<p>Una vez identificado con su cuenta en la aplicación,
											pulse sobre el menú izquierdo en Añadir Factura, y seleccione
											sobre el desplegable si desea hacerlo manualmente o subiendo
											un PDF a la aplicación. Si lo hace manualmente, solo tiene
											que ingresar los datos y aceptar la nueva factura. En la
											opción de PDF, seleccione y suba su archivo en formato PDF, y
											automáticamente se agregarán sus datos a su historial de
											facturas.</p>
									</div> <!-- cd-faq-content --></li>

								<li><a class="cd-faq-trigger" href="#0">¿Cómo recibo
										ofertas?</a>
									<div class="cd-faq-content">
										<p>Pulse en el menú izquierdo sobre la opción Ofertas para
											ver las ofertas disponibles. Si quiere suscribirse a nuestro
											servicio, marque la opcion correspondiente. Automáticamente,
											recibirá ofertas por correo electrónico cada vez que
											detectemos que puede contratar una tarifa más beneficiosa en
											función de su consumo.</p>
									</div> <!-- cd-faq-content --></li>

							</ul>
							<!-- cd-faq-group -->

							<ul id="account" class="cd-faq-group">
								<li class="cd-faq-title"><h2>Errores</h2></li>
								<li><a class="cd-faq-trigger" href="#0">No puedo abrir
										la aplicación</a>
									<div class="cd-faq-content">
										<p>La aplicación se encuentra aún en fase previa a
											lanzamiento, por lo que puede detectar errores de vez en
											cuando. Pruebe a recargar la página o a desloguearse y volver
											a ingresar en la aplicación. Si no funciona, puede que
											estemos trabajando en nuestros servidores y el servicio se
											encuentre no disponible momentáneamente. Perdone las
											molestias.</p>
									</div> <!-- cd-faq-content --></li>

								<li><a class="cd-faq-trigger" href="#0">No aparecen mis
										facturas</a>
									<div class="cd-faq-content">
										<p>Recargue la página, ya que probablemente su nueva
											factura aún se esté procesando.</p>
									</div> <!-- cd-faq-content --></li>

								<li><a class="cd-faq-trigger" href="#0">No recibo
										correos con ofertas</a>
									<div class="cd-faq-content">
										<p>Corrobore que ha seguido el paso de autorizarnos a
											utilizar su correo electrónico. Para ello, pulse sobre la
											opción Ofertas en el menú de la izquierda. Si ha seguido ya
											este paso y sigue sin recibir ofertas, por favor, contacte
											con nosotros directamente. Sentimos las molestias.</p>
									</div> <!-- cd-faq-content --></li>

								<li><a class="cd-faq-trigger" href="#0">No puedo
										identificarme</a>
									<div class="cd-faq-content">
										<p>La identificación se realiza mediante el sistema de
											Google. Corrobore que ha empleado un correo electrónico
											válido (terminado en @gmail.com) y que ha accedido con su
											contraseña actual. Si continúa con el problema, contacte con
											nosotros directamente. Su información no se perderá en ningún
											caso.</p>
									</div> <!-- cd-faq-content --></li>
							</ul>
							<!-- cd-faq-group -->

						</div>
						<!-- cd-faq-items -->
						<a href="#0" class="cd-close-panel">Close</a>
					</section>
					<!-- cd-faq -->
					<!-- Resource jQuery -->

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
	<script src="../../cliente/js/jquery-2.1.1.js"></script>
	<script src="../../cliente/js/jquery.mobile.custom.min.js"></script>
	<script src="../../cliente/js/main.js"></script>

	<script src="../../cliente/js/jquery.dataTables.js"></script>
	<script src="../../cliente/js/tablaFacturas.js"></script>
	<script src="../../cliente/js/pdf.js"></script>
	<script src="../../cliente/js/pdf.worker.js"></script>
	<script src="../../cliente/js/pdfparser.js"></script>

</body>
</html>