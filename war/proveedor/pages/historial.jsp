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
								<h3>Historial de subastas</h3>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-xs-12">
							<div class="panel panel-default">
								<!-- /.panel-heading -->
								<div class="panel-body">
									<div class="dataTable_wrapper">
										<table
											class="table table-striped responsive-utilities jambo_table dataTable no-footer"
											id="dataTables-example">
											<thead>
												<tr class="headings tr_historial">
													<th class="sorting">Nº Subasta</th>
													<th class="sorting">Nº Usuarios</th>
													<th class="sorting">Estado</th>
													<th class="sorting">Ganador Actual</th>
													<th class="sorting">Puja ganadora</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${historial}" var="subasta">
													<tr>
														<td class=" "><c:out value="${subasta.id}" /></td>
														<td class=" "><c:out value="${subasta.numUsuarios}" /></td>
														<c:if test="${subasta.fechaFin lt miliActual}">
															<td class=" ">Terminada</td>
														</c:if>
														<c:if test="${subasta.fechaFin gt miliActual}">
															<td class=" ">Activa</td>
														</c:if>
														<c:if test="${user == subasta.ganadorActual}">
															<td class=" "><c:out value="${subasta.ganadorActual}" /></td>
														</c:if>
														<c:if test="${user != subasta.ganadorActual}">
															<td class=" ">-</td>
														</c:if>
														<td class=" "><c:out value="${subasta.pujaActual}" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp"%>
		</div>
 	<!-- /page content -->
	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group"></ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>
	<%@ include file="scripts.jsp" %>
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