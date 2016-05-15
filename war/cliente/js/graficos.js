$(function() {
	var ctx = document.getElementById("myChart");
	var data = {
		labels : [ "23/01/2016", "23/02/2016", "23/03/2016", "23/04/2016",
				"23/05/2016", "23/06/2016" ],
		datasets : [ {
			label : "Consumo en €",
			backgroundColor : "rgba(255,99,132,0.2)",
			borderColor : "rgba(255,99,132,1)",
			borderWidth : 1,
			hoverBackgroundColor : "rgba(255,99,132,0.8)",
			hoverBorderColor : "rgba(255,99,132,1)",
			data : [ 76, 70, 82, 74, 80, 76 ]
		} ]
	};
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : data,
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			},
			responsive : true,
			maintainAspectRatio : true
		}

	});

});