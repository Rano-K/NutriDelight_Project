/**
 * 
 */

function dataConnect(datas, datasb) {
	let dataSetup = datas;
	let dataSetbelow = datasb;
	
	console.log(dataSetup);
	console.log(dataSetbelow);

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
			chartArea: { width: '50%' },
			hAxis: {
				title: '주문량(개)',
				minValue: 0
			},
			vAxis: {
				title: '날짜'
			}
		};

		var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

		chart.draw(data, options);
	}

}