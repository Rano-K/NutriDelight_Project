/**
 * 
 */

function dataConnect(datas, datasb) {
	let dataSetup = datas;
	let dataSetbelow = datasb;
	

	google.charts.load('current', {
		'packages': ['corechart']
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {

		var data = google.visualization.arrayToDataTable(dataSetup);

		var options = {
			is3D: true

		};

		var chart = new google.visualization.PieChart(document
			.getElementById('piechart'));

		chart.draw(data, options);
	}

	google.charts.load('current', { packages: ['corechart', 'bar'] });
	google.charts.setOnLoadCallback(drawBasic);

	function drawBasic() {

		var data = google.visualization.arrayToDataTable(dataSetbelow);

		var options = {
		};

		var chart = new google.visualization.BarChart(document.getElementById('barchart_order'));

		chart.draw(data, options);
	}

}