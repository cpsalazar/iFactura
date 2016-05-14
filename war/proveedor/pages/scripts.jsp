<c:if test="${user != null}">
	<!--[if lt IE 9]>
		<script src="../../proveedor/assets/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<!-- jQuery -->
	<script src="../../proveedor/js/countdown.js"></script> 
	<script src="../../proveedor/js/jquery.min.js"></script>
	<script src="../../proveedor/js/nicescroll/jquery.nicescroll.min.js"></script>
	<script src="../../proveedor/js/jquery-numeric.js"></script>
	<script>$(".numeric").numeric();</script>
	<!-- Bootstrap -->
	<script src="../../proveedor/js/bootstrap.min.js"></script>
	<script src="../../proveedor/js/nprogress.js"></script>
	<script src="../../proveedor/js/icheck/icheck.min.js"></script>
	<script src="../../proveedor/js/custom.js"></script>
	<script type="text/javascript"> 
	    (function($){
	        $(function(){
	            setInterval(function() {
	                var url = '#';
	                var num_subastas = document.getElementById("num_subastas").innerHTML;
	               	for (i = 1; i <= num_subastas; i++) {
	                	var id_puja = ('#rlpuja'+i);
	                	var id_pujador = ('#rlpujador'+i);
	                	$(id_puja).load(url + ' ' + id_puja + '_');
	                	$(id_pujador).load(url + ' ' + id_pujador + '_');
	               	}
	            }, 500000);
	        }); 
	     })(jQuery);
    </script>
	<!-- Form validation -->
	<script type="text/javascript" src="../../proveedor/js/parsley/parsley.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$.listen('parsley:field:validate', function() {
				validateFront();
			});
			$('#demo-form .btn').on('click', function() {
				$('#demo-form').parsley().validate();
				validateFront();
			});
			var validateFront = function() {
				if (true === $('#demo-form').parsley().isValid()) {
					$('.bs-callout-info').removeClass('hidden');
					$('.bs-callout-warning').addClass('hidden');
				} else {
					$('.bs-callout-info').addClass('hidden');
					$('.bs-callout-warning').removeClass('hidden');
				}
			};
		});
		$(document).ready(function() {
			$.listen('parsley:field:validate', function() {
				validateFront();
			});
			$('#demo-form2 .btn').on('click', function() {
				$('#demo-form2').parsley().validate();
				validateFront();
			});
			var validateFront = function() {
				if (true === $('#demo-form2').parsley().isValid()) {
					$('.bs-callout-info').removeClass('hidden');
					$('.bs-callout-warning').addClass('hidden');
				} else {
					$('.bs-callout-info').addClass('hidden');
					$('.bs-callout-warning').removeClass('hidden');
				}
			};
		});
		try {
			hljs.initHighlightingOnLoad();
		} catch (err) {}
	</script>
	<!-- Buscador -->
	<script>
		$(document).ready(function() {
			$('input.tableflat').iCheck({
				checkboxClass: 'icheckbox_flat-green',
				radioClass: 'iradio_flat-green'
			});
		});
		var asInitVals = new Array();
		$(document).ready(function() {
			var oTable = $('#example').dataTable({
				"oLanguage": {
					"sSearch": "Buscar:"
				},
				"aoColumnDefs": [{
					'bSortable': false,
					'aTargets': [0]
					} //disables sorting for column one
					],
					'iDisplayLength': 12,
					"sPaginationType": "full_numbers",
					"dom": 'T<"clear">lfrtip',
					"tableTools": {
						"sSwfPath": "js/datatables/tools/swf/copy_csv_xls_pdf.swf"
					}
				});
			$("tfoot input").keyup(function() {
				/* Filter on the column based on the index of this element's parent <th> */
				oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
			});
			$("tfoot input").each(function(i) {
				asInitVals[i] = this.value;
			});
			$("tfoot input").focus(function() {
				if (this.className == "search_init") {
					this.className = "";
					this.value = "";
				}
			});
			$("tfoot input").blur(function(i) {
				if (this.value == "") {
					this.className = "search_init";
					this.value = asInitVals[$("tfoot input").index(this)];
				}
			});
		});
	</script>
	<script type="text/javascript"> 
		$(document).ready(function() {
			$("tr > th").removeClass("sorting_asc");
		});
    </script>
	<script src="../../proveedor/js/datatables/js/jquery.dataTables.js"></script>
	<script>NProgress.done();</script>
	<!-- input tags -->
	<script>
		function onAddTag(tag) {
			alert("Added a tag: " + tag);
		}
		function onRemoveTag(tag) {
			alert("Removed a tag: " + tag);
		}
		function onChangeTag(input, tag) {
			alert("Changed a tag: " + tag);
		}
	</script>
	<!-- editor -->
	<script>
		$(document).ready(function() {
			$('.xcxc').click(function() {
				$('#descr').val($('#editor').html());
			});
		});
		$(function() {
			function initToolbarBootstrapBindings() {
				var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
				'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
				'Times New Roman', 'Verdana'
				],
				fontTarget = $('[title=Font]').siblings('.dropdown-menu');
				$.each(fonts, function(idx, fontName) {
					fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
				});
				$('a[title]').tooltip({
					container: 'body'
				});
				$('.dropdown-menu input').click(function() {
					return false;
				})
				.change(function() {
					$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
				})
				.keydown('esc', function() {
					this.value = '';
					$(this).change();
				});
				$('[data-role=magic-overlay]').each(function() {
					var overlay = $(this),
					target = $(overlay.data('target'));
					overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
				});
				if ("onwebkitspeechchange" in document.createElement("input")) {
					var editorOffset = $('#editor').offset();
					$('#voiceBtn').css('position', 'absolute').offset({
						top: editorOffset.top,
						left: editorOffset.left + $('#editor').innerWidth() - 35
					});
				} else {
					$('#voiceBtn').hide();
				}
			};
			function showErrorAlert(reason, detail) {
				var msg = '';
				if (reason === 'unsupported-file-type') {
					msg = "Unsupported format " + detail;
				} else {
					console.log("error uploading file", reason, detail);
				}
				$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
					'<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
			};
			initToolbarBootstrapBindings();
			window.prettyPrint && prettyPrint();
		});
	</script>
	<script>
		var x = 0;
		$('#menu_toggle').click(function(){
			if (x === 0) {
		    	$('#menu_logo').attr('src', '../../proveedor/images/logo_white.png');
		    	$('#menu_logo').attr('style', 'width: 80%;');
		    	x = 1;
			} else {
				$('#menu_logo').attr('src', '../../proveedor/images/logo_white_.png');
		    	$('#menu_logo').attr('style', 'width: 60%;');
		    	x = 0;
			}
		});
	</script>
</c:if>
<c:if test="${user == null}">
	<br>
	<meta http-equiv="refresh" content="0; url=/isst_g09_ifactura" />
</c:if>