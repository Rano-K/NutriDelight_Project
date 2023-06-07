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
<script src="admin/js/user_graph.js"></script>

<!-- sweetalret2 https://wooncloud.com/12 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!--get attribute from java  -->
<%
ArrayList<ArrayList<String>> dataSetGender = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetGender");
ArrayList<ArrayList<String>> dataSetAge = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetAge");
ArrayList<ArrayList<String>> dataSetInsert = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetInsert");
%>
<script type="text/javascript">
	$(document).ready(function() {
		var dataSetGender =
<%=dataSetGender %>
	;
		var dataSetAge =
<%=dataSetAge %>
	;
		var dataSetInsert =
<%=dataSetInsert %>
	;
		dataConnect(dataSetGender, dataSetAge, dataSetInsert);
	});
</script>
</head>
<body id="page-top">
	<%@ include file="admin_toolbar.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">유저 성향 그래프 확인</h1>
		<!-- 1열 -->
		<div class="row">
			<div class="col-lg-6">
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">남녀 성비</h6>
					</div>
					<div class="card-body">
						<div id="pieGender" style="width : 100%; height: 400px;"></div>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">연령대 별 가입자</h6>
					</div>
					<div class="card-body">
						<div id="pieAge" style="width : 100%; height: 400px;"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- 2열 -->
		<div class="row">
			<div class="col-lg-12">
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">가입자 추이</h6>
					</div>
					<div class="card-body">
						<div id="barInsert" style="width : 100%;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.container-fluid -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i></a>

</body>
</html>
