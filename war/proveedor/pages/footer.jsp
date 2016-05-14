<%@page pageEncoding="utf8"%>
<c:if test="${user != null}">
	<!-- footer content -->
	<footer>
		<div class="copyright-info">
			<p class="pull-right">Copyright © 2016 iFactura. Todos los derechos reservados</p>
		</div>
		<div class="clearfix"></div>
	</footer>
</c:if>
<c:if test="${user == null}">
	<br>
	<meta http-equiv="refresh" content="0; url=/isst_g09_ifactura" />
</c:if>