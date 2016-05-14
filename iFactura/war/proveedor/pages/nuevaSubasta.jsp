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
							<h3>Formulario de creación de subasta</h3>
						</div>
					</div>
					<div class="clearfix"></div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<!-- /.panel-heading -->
								<div class="panel-body">
									<form class="form-horizontal" action="/crearSubasta" method="post" id="creacion-subasta">
										<div class="form-group">
											<label class="control-label col-md-2 col-md-offset-2">Descripción de la subasta:</label>
											<div class="col-md-6">
												<input name="descripcion" class="form-control" placeholder="Introduzca descripción" required>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-md-offset-2">Nº usuarios:</label>
											<div class="col-md-6">
												<input name="usuarios" class="form-control numeric" placeholder="Introduzca número de usuarios" required>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-md-offset-2">Fecha de finalización:</label>
											<div class="col-md-6">
												<input name="fecha" class="form-control" placeholder="Introduzca fecha" required>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-md-offset-2">Puja inicial:</label>
											<div class="col-md-6">
												<input name="puja_inicial" class="form-control numeric" step="0.25" placeholder="Introduzca la puja inicial" required>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<input type="submit" class="btn btn-primary btn-form" value="Enviar">	
											</div>
										</div>
									</form>
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
			<p class="denied col-xs-12">Solamente pueden crear subastas los miembros de la compañía iFactura.</p>
			<p><a class="denied-a col-xs-12" href="javascript:history.back()"><c:out value="Volver" /></a></p>
		</div>
	</c:if>
</body>
</html>