/**
 * 
 */

function dataConnect(dataSales, subscribeSales, ordersSales) {
	let dataOrders = dataSales;
	let subscribes = subscribeSales;
	let orders = ordersSales;

	google.charts.load('current', { packages: ['corechart', 'bar'] });
	google.charts.setOnLoadCallback(drawBasic);

	function drawBasic() {

		var data = google.visualization.arrayToDataTable(dataOrders);
		var options = {
		};

		var chart = new google.visualization.LineChart(document.getElementById('barchart'));

		chart.draw(data, options);
	}

	google.charts.load('current', {
		'packages': ['corechart']
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {

		var data = google.visualization.arrayToDataTable([
			['항목', '값'],
			['구독자 수', subscribes],
			['구매자 수', orders]
		]);

		var options = {
			 chartArea: { width: '100%', height: '90%' }
		};

		var chart = new google.visualization.PieChart(document
			.getElementById('pieChart'));

		chart.draw(data, options);
	}

}