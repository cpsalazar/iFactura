var datos = [];
$(function() {
	$('#file').change(function(e) {

		e.preventDefault();
		// Step 1: Get the file from the input element
		var file = $("#file")[0].files[0];

		// Step 2: Read the file using file reader
		var fileReader = new FileReader();

		fileReader.onload = function() {

			// Step 4:turn array buffer into typed array
			var typedarray = new Uint8Array(this.result);

			// Step 5:PDFJS should be able to read this
			PDFJS.getDocument(typedarray).then(function(pdf) {
				// Using promise to fetch the page
				pdf.getPage(1).then(function(page) {

					page.getTextContent().then(function(textContent) {
						datos = [];
						var arrayLength = textContent.items.length;
						for (var i = 0; i < arrayLength; i++) {
							datos.push(textContent.items[i].str)
						}
					});

					var scale = 1.5;
					var viewport = page.getViewport(scale);

					//
					// Prepare canvas using PDF page dimensions
					//
					var canvas = document.getElementById("myCanvas");
					var context = canvas.getContext('2d');
					canvas.height = viewport.height;
					canvas.width = viewport.width;

					//
					// Render PDF page into canvas context
					//
					var renderContext = {
						canvasContext : context,
						viewport : viewport
					};
					page.render(renderContext);
				});
			});

		};

		// Step 3:Read the file as ArrayBuffer
		fileReader.readAsArrayBuffer(file);
		$("#submit").show();
	});
});

$("#submit").click(function(event) {
	console.log(datos);
	$.post("/uploadFactura", {
		arraydata : datos,
		mode : "Insert"
	}, function(data) {
		alert("Factura subida correctamente");
	});
});
