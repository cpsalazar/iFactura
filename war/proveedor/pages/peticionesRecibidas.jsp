<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>iFactura</title>
	<!-- Bootstrap core CSS -->
	<link href="../../proveedor/css/bootstrap.min.css" rel="stylesheet">
	<link href="../../proveedor/fonts/css/font-awesome.min.css" rel="stylesheet">
	<link href="../../proveedor/css/animate.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="../../proveedor/css/custom.css" rel="stylesheet">
</head>
<body class="nav-md">
	<c:if test="${user == 'iFactura'}">
	<div class="container body">
		<div class="main_container">
			<%@ include file="menuRoot.jsp"%>
      		<!-- /top navigation -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Peticiones recibidas</h3>
						</div>
					</div>
					<div class="clearfix"></div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<!-- /.panel-heading -->
								<div class="panel-body">
									<c:forEach items="${peticiones}" var="peticion" varStatus="loop">
										<form action="/valorarPeticion" method="post">
											<input type="hidden" name="id" value="${peticion.peticion}">
											<input type="hidden" name="correo" value="${peticion.correo}">
											<input type="hidden" name="compania" value="${peticion.compania}">
											<p>Petición de: <c:out value="${peticion.compania}" /></p>
											<p><c:out value="${peticion.peticion}" /></p>
											<input name="solicitud" type="radio" value="aceptar" />Aceptar solicitud
            								<input name="solicitud" type="radio" value="declinar" />Declinar solicitud          
            								<input type="submit"  value="Enviar" />
										</form>	
									</c:forEach>
								</div>
								<!-- /.panel-body -->
							</div>
							<!-- /.panel -->
						</div>
						<!-- /.col-lg-12 -->
					</div>
				</div>
				<!-- /page content -->
				<div id="custom_notifications" class="custom-notifications dsp_none">
					<ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group"></ul>
					<div class="clearfix"></div>
					<div id="notif-group" class="tabbed_notifications"></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>			
		</div>
		<%@ include file="scripts.jsp" %>
	</div>
	</c:if>
	<c:if test="${user != 'iFactura'}">
		<br>
		<div class="container">
			<p class="denied-top col-xs-12">Acceso denegado</p>
			<p class="denied col-xs-12">Solamente miembros de la compañía iFactura pueden ver peticiones de subastas.</p>
			<p><a class="denied-a col-xs-12" href="<c:url value="/isst_g09_ifactura"/>"><c:out value="Iniciar sesión" /></a></p>
		</div>
	</c:if>
</body>
</html>