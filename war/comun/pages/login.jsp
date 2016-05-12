<!DOCTYPE html>
<html lang="es">
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ page contentType="text/html;charset=UTF-8" language="java"%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>iFactura</title>
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet" type="text/css">
	<!-- Bootstrap Core CSS -->
	<link href="../../proveedor/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="../../proveedor/css/login.css" rel="stylesheet">
	<link href="../../proveedor/css/animate-custom.css" rel="stylesheet"> 
	<!-- Custom Fonts -->
	<link href="../../proveedor/fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body class="fade-in">
	<!-- Start Login box -->
	<div class="container" id="login-block">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4 animated flipInY">
				<div class="login-box clearfix" style="padding-top: 40px; padding-bottom: 50px; margin-top: 40%;">
					<div class="login-logo">
						<img src="../../proveedor/images/logo.png" alt="iFactura" style="width: 45%;">
					</div> 
					<hr>
					<div class="login-form" style="margin-top: 16px;">
						<div style="width: 200px; margin: 0 auto;">
							<a class="btn azm-social azm-btn azm-border-bottom azm-google" href="" style="width: 200px;">
								Aplicación Cliente
							</a>
						</div>
						<div style="width: 200px; margin: 0 auto;">
							<a class="btn azm-social azm-btn azm-border-bottom azm-google" href="/isst_g09_ifactura" style="width: 200px;"/>
								Aplicación Proveedor
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Login box -->
	<footer class="container">
		<p id="footer-text"><small>Copyright © 2016 iFactura. Todos los derechos reservados</small></p>
	</footer>
	<!-- jQuery -->
	<script src="../../proveedor/js/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="../../proveedor/js/bootstrap.min.js"></script>
	<script src="../../proveedor/js/login.js"></script>
</body>
</html>