<!DOCTYPE html>
<html lang="es">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iFactura2016</title>
<!-- Bootstrap Core CSS -->
<link href="../../cliente/css/bootstrap.min.css" rel="stylesheet">

<link href="../../cliente/css/style.css" rel="stylesheet">

</head>
<body>


	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			i<span>Factura</span>
		</div>
	</div>
	<br>
	<div class="login" id="loginDiv">
		<input type="text" placeholder="correo" name="correo"><br>
		<input type="password" placeholder="password" name="password"><br>
		<div style="padding-top: 5px">
			<a type="button" class="btn btn-primary">Login </a> <a type="button"
				class="btn btn-primary" href="<c:url value="${url}"/>"> <i
				class="fa fa-google"></i> Login con Google
			</a>
		</div>
		<div style="padding-bottom: 15px; padding-top: 15px">
			<a id="registrationLink" href="">Registrate</a>
		</div>
		<a href="/comun/pages/login.jsp" style="display: block;">
			<p style="margin: 0;">Volver</p>
		</a>
	</div>
	<div class="login" id="registrationDiv" class="container clearfix"
		style="display: none">
		<%@ include file="registration.jsp"%>
	</div>



	<script src="../../cliente/js/prefixfree.min.js"></script>
	<script src="../../cliente/js/jquery.min.js"></script>
	<script src="../../cliente/js/login.js"></script>

</body>
</html>