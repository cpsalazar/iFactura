$(function() {
	var table;
	$(document)
			.ready(
					function() {
						table = $('#tabla_telefono')
								.DataTable(
										{
											"language" : {
												"sProcessing" : "Procesando...",
												"sLengthMenu" : "Mostrar _MENU_ facturas",
												"sZeroRecords" : "No se encontraron resultados",
												"sEmptyTable" : "Ningún dato disponible en esta tabla",
												"sInfo" : "Mostrando facturas del _START_ al _END_ de un total de _TOTAL_ facturas",
												"sInfoEmpty" : "Mostrando facturas del 0 al 0 de un total de 0 facturas",
												"sInfoFiltered" : "(filtrado de un total de _MAX_ facturas)",
												"sInfoPostFix" : "",
												"sSearch" : "Buscar:",
												"sUrl" : "",
												"sInfoThousands" : ",",
												"sLoadingRecords" : "Cargando...",
												"oPaginate" : {
													"sFirst" : " Primero ",
													"sLast" : " Último ",
													"sNext" : " Siguiente ",
													"sPrevious" : " Anterior "
												},
												"oAria" : {
													"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
													"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
												}
											},
											responsive : true
										});
					});

	$('.eliminar').on('click', function(event) {
		var rowId = event.currentTarget.id
		var id = rowId.split("_")[1];
		console.log(id);
		$.post("/deleteFactura", {
			id : id
		}, function(data) {
			alert("Factura borrada correctamente");
		});
		event.preventDefault();
	});
});

$(function() {

	$('#facturaTelefonoManual').click(function(e) {
		$("#formularioTelefono").show();
		$("#fileUploadFormDiv").hide();
	});

	$('#fileUploadForm').click(function(e) {
		$("#fileUploadFormDiv").show();
		$("#formularioTelefono").hide();
	});

});