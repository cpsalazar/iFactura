
<!--  table id="tabla_telefono" class="display well" cellspacing="0" 	width="100%">
-->
<table id="tabla_telefono" class="table table-striped table-hover"
	cellspacing="0" width="100%">

	<thead style="background-color: black; color: white;">
		<tr>
			<th style="display: none;">Factura</th>
			<th>Fecha Facturacion</th>
			<th>Datos Contratados</th>
			<th>Datos Consumidos</th>
			<th>Voz Contratada</th>
			<th>Voz Consumida</th>
			<th>Importe</th>
			<th>Horario</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${facturasTelefono}" var="item">
			<tr>
				<td style="display: none;">${item.idFactura}</td>
				<td>${item.fechaFacturacion}</td>
				<td>${item.datosContratados}</td>
				<td>${item.datosConsumidos}</td>
				<td>${item.vozContratada}</td>
				<td>${item.vozConsumida}</td>
				<td>${item.importeTotal}</td>
				<td>${item.esTarde}</td>
				<td><input type="button" value="eliminar"
					id="eliminar_${item.idFactura}" class="eliminar btn btn-sm"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
