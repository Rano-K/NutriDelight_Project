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
<title>상품 목록</title>
<!-- Custom fonts for this template -->
<link href="admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
<!-- Custom styles for this page -->
<link
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"
	rel="stylesheet">
<!-- sweetalret2 https://wooncloud.com/12 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!-- Bootstrap core JavaScript-->
<script src="admin/vendor/jquery/jquery.min.js"></script>
<script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="admin/js/sb-admin-2.min.js"></script>

<!-- DataTables library -->
<script
	src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="admin/js/product_table.js"></script>

<!--get attribute from java  -->
<%
ArrayList<ArrayList<String>> dataSetProduct = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetProduct");
%>

<script type="text/javascript">
	$(document).ready(function() {
		var dataSetProduct =
<%=dataSetProduct%>
	;

		dataConnect(dataSetProduct);
	});
</script>

</head>

<body id="page-top">
	<%@ include file="admin_toolbar.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">구매목록</h1>
		<p class="mb-4">구매목록을 확인해주세요.</p>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">주문 현황</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table id="product" class="display" width="100%">
					</table>
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
