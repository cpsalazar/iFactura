$(function() {
	$('#registrationLink').click(function(e) {
		$("#registrationDiv").show();
		$("#loginDiv").hide();
		e.preventDefault();
	});

	$('#registrationBack').click(function(e) {
		$("#registrationDiv").hide();
		$("#loginDiv").show();
		e.preventDefault();
	});

});