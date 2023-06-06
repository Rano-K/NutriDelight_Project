/**
 * 
 */

function dataConnect(dataSetGender, dataSetAge, dataSetInsert) {
	let dataGender = dataSetGender;
	let dataAge = dataSetAge;
	let dataInsert = dataSetInsert;

	google.charts.load('current', {
		'packages': ['corechart']
	});
	google.charts.setOnLoadCallback(drawChart1);

	function drawChart1() {

		var data = google.visualization.arrayToDataTable(dataGender);

		var options = {
			is3D: true

		};

		var chart = new google.visualization.PieChart(document
			.getElementById('pieGender'));

		chart.draw(data, options);
	}

	google.charts.load('current', {
		'packages': ['corechart']
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {

		var data = google.visualization.arrayToDataTable(dataAge);

		var options = {
			is3D: true

		};

		var chart = new google.visualization.PieChart(document
			.getElementById('pieAge'));

		chart.draw(data, options);
	}

	google.charts.load('current', { packages: ['corechart', 'bar'] });
	google.charts.setOnLoadCallback(drawBasic);

	function drawBasic() {
		var data = google.visualization.arrayToDataTable(dataInsert);

		var options = {
			vAxis: {
				format: 0
			}
		};

		var chart = new google.visualization.LineChart(document.getElementById('barInsert'));

		chart.draw(data, options);
	}


}