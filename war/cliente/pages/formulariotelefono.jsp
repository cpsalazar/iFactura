
<h2 style="font-family: Fondamento;">Subida de Factura Manual</h2>

<form id="formTelefono" class="form-horizontal" action="/newFactura"
	method="post" role="form">
	<input type="hidden" class="form-control" name="tipo" id="tipo"
		value="telefono">

	<div class="form-group">
		<label class="control-label col-sm-2" for="importeTotal">Importe:</label>
		<div class="col-sm-3">
			<input type="number" step="any" class="form-control"
				name="importeTotal" id="importeTotal" placeholder="Importe">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="datosContratados">Datos
			Contratados:</label>
		<div class="col-sm-3">
			<input type="number" step="any" class="form-control"
				name="datosContratados" id="datosContratados"
				placeholder="Datos Contratados">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="datosConsumidos">Datos
			Consumidos:</label>
		<div class="col-sm-3">
			<input type="number" step="any" class="form-control"
				name="datosConsumidos" id="datosConsumidos"
				placeholder="Datos Consumidos">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="esTarde">Horario:</label>
		<div class="col-sm-1">
			<select class="form-control" name="esTarde" id="esTarde">
				<option value="false">Mañana</option>
				<option value="saab">Tarde</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="vozContratada">Voz
			Contratada:</label>
		<div class="col-sm-3">
			<input type="number" step="any" class="form-control"
				name="vozContratada" id="vozContratada" placeholder="Voz Contratada">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="vozConsumida">Voz
			Consumida:</label>
		<div class="col-sm-3">
			<input type="number" step="any" class="form-control"
				name="vozConsumida" id="vozConsumida" placeholder="Voz Consumida">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="fechaFacturacion">Fecha
			Emision:</label>
		<div class="col-sm-3">
			<input type="date" class="form-control" name="fechaFacturacion"
				id="fechaFacturacion" placeholder="Fecha Emision">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn ">Añade Factura</button>
		</div>
	</div>
	<a href="/isst_g08_ifactura" id="returnToFactura">Volver a Facturas</a>

</form>