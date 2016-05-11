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
	<c:if test="${user != null}">
	<div class="container body">
		<div class="main_container">
			<c:if test="${user == 'Orange' || user == 'Vodafone' || user == 'Yoigo' || user == 'Movistar'}">
				<%@ include file="menu.jsp"%>
			</c:if>
			<c:if test="${user == 'iFactura'}">
				<%@ include file="menuRoot.jsp"%>
			</c:if>
      		<!-- /top navigation -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Petición de subasta</h3>
						</div>
					</div>
					<div class="clearfix"></div>
					<!-- /.row -->
					<div class="row" style="margin-top: 5px;">
						<div class="col-xs-12" style="padding-left: 10px; padding-right: 10px;">
							<div class="panel panel-default">
								<!-- /.panel-heading -->
								<div class="panel-body">
									<form class="form-horizontal" id="peticion-subasta" style="margin: 10px;" action="/nuevaPeticion" method="post">
											
										<div class="form-group">
											<c:if test="${peticion != null}">
												
												<p>Tiene peticiones pendientes por confirmar:</p>
												<c:forEach items="${peticion}" var="peti">
													<p><c:out value="${peti.peticion}" /></p>
												</c:forEach>
											</c:if>
										</div>
										
										<div class="form-group">
											<label>Exprese brevemente los criterios bajo los cuales le gustaría que se crease una subasta</label>
											<textarea name="peticion" class="form-control" rows="6" style="float: none; border-radius: 4px; max-width: 82vw;"></textarea>
											<input class="btn btn-primary" value="Enviar" type="submit" style="margin-top: 5px;"></input>
											<label class="checkbox-inline">
												<input value="agree" type="checkbox"></input>Acepto los <a href=#openModal>términos y condiciones</a>
											</label>
											<div id="openModal" class="modalDialog">
												<div class="col-xs-6 col-xs-offset-3" style="transform: translateY(50%);">
													<a href="#close" class="close">X</a>
													<h2 style="margin-top: 0;"><strong>Términos y condiciones</strong></h2>
													<h4><strong>Complaints</strong></h4>
													<p>Any complaints about items or sellers may be sent to our support team: support@wesellyourstuff.com or (888) 555-0198.
													There is no guarantee of a resolution. Each case will be looked at individually, and the seller will be in contact as well.</p>
													<h4><strong>Legalities</strong></h4>
													<p>blablablablablablabla blablabla blablablabla blablalablablablabla</p>
													<p>blablablablablablabla blablabla blablablabla blablalablablablabla</p>
													<p><strong>These terms and conditions are subject to change</strong></p>
												</div>
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
	<c:if test="${user == null}">
		<br>
		<div class="container">
			<p class="denied-top col-xs-12">Acceso denegado</p>
			<p class="denied col-xs-12">No has iniciado sesión en el sistema, pulsa el siguiente enlace para registrarte</p>
			<p><a class="denied-a col-xs-12" href="<c:url value="/isst_g09_ifactura"/>"><c:out value="Iniciar sesión" /></a></p>
		</div>
	</c:if>
</body>
</html>