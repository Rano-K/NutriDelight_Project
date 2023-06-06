<%@page import="com.javalec.bbs.dto.NDOrdersDto_OKH"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>유저 그래프</title>
<!-- Custom fonts for this template -->
<link href="admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
<!-- sweetalret2 https://wooncloud.com/12 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!-- Bootstrap core JavaScript-->
<script src="admin/vendor/jquery/jquery.min.js"></script>
<script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="admin/js/sb-admin-2.min.js"></script>

<!--Google chart  -->
<script src="https://www.gstatic.com/charts/loader.js"></script>

<!-- sweetalret2 https://wooncloud.com/12 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!--get attribute from java  -->
	<%
	ArrayList<ArrayList<String>> dataSetup = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetup");
	ArrayList<ArrayList<String>> dataSetbelow = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetbelow");	
	%>
<script type="text/javascript">
	$(document).ready(function() {
		var dataSetup =
<%=dataSetup%>
	;
		var dataSetbelow =
<%=dataSetbelow%>
	;
		dataConnect(dataSetup, dataSetbelow);
	});
</script>
<body id="page-top">
	<%@ include file="admin_toolbar.jsp"%>

	<script type="text/javascript">
		google.charts.load('current', {
			'packages' : [ 'corechart' ]
		});
		google.charts.setOnLoadCallback(drawChart);

		function drawChart() {

			var data = google.visualization.arrayToDataTable(
	<%=dataSetup%>
		);

			var options = {
					is3D: true
					
			};

			var chart = new google.visualization.PieChart(document
					.getElementById('piechart'));

			chart.draw(data, options);
		}
		
		google.charts.load('current', {packages: ['corechart', 'bar']});
		google.charts.setOnLoadCallback(drawBasic);

		function drawBasic() {

			var data = google.visualization.arrayToDataTable(
					<%=dataSetbelow%>
						);

		      var options = {
		        chartArea: {width: '50%'},
		        hAxis: {
		          title: '주문량',
		          minValue: 0
		        },
		        vAxis: {
		          title: '날짜'
		        }
		      };

		      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

		      chart.draw(data, options);
		    }
	</script>
	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">주문 그래프 확인</h1>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">상품별 주문 그래프</h6>
			</div>
			<div class="card-body">
				<div id="piechart" style="height: 700px;"></div>
			</div>
		</div>
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">주간 주문 그래프</h6>
			</div>
			<div class="card-body">
					<div id="chart_div" style="height: 700px;"></div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i></a>

</body>
</html>
