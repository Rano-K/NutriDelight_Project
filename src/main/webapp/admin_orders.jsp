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
<title>주문목록</title>
<!-- Custom fonts for this template -->
<link href="admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
<!-- Custom styles for this page -->
<link 	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"	rel="stylesheet">
<!-- sweetalret2 https://wooncloud.com/12 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body id="page-top">
	<%@ include file="admin_toolbar.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">주문목록</h1>
		<p class="mb-4">주문목록을 확인해주세요.</p>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">주문 현황</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table id="orders" class="display" width="100%">
					</table>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i></a>

	<!-- Bootstrap core JavaScript-->
	<script src="admin/vendor/jquery/jquery.min.js"></script>
	<script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="admin/js/sb-admin-2.min.js"></script>

	<!-- DataTables library -->
	<script	src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	<%
	ArrayList<ArrayList<String>> dataSet = (ArrayList<ArrayList<String>>) request.getAttribute("dataSet");
	%>
	<script>
	const Toast = Swal.mixin({
	    toast: true,
	    position: 'center-center',
	    showConfirmButton: false,
	    timer: 3000,
	    timerProgressBar: true,
	    width: '600px', 
	    height: '600px', 
	    didOpen: (toast) => {
	        toast.addEventListener('mouseenter', Swal.stopTimer)
	        toast.addEventListener('mouseleave', Swal.resumeTimer)
	    }
	})
	
    var dataSet = <%=dataSet%>;

    $(document).ready(function () {
        var table = $('#orders').DataTable({
            data: dataSet,
            columns: [
                { title: '주문번호' },
                { title: '주문 id' },
                { title: '상품 코드' },
                { title: '배송 주소' },
                { title: '주문 갯수' },
                { title: '재고' },
                { title: '주문날짜' },
                { title: '환불날짜' },
                { title: '배송날짜' }
            ]
        });

        // 행 클릭 이벤트 처리
        $('#orders tbody').on('click', 'tr', function() {
            var rowData = table.row(this).data();
            var ordercode = rowData[0]; 
            var refunddate = rowData[7]; 
            var deliverydate = rowData[8]; 
            
            if (refunddate === '환불되지 않았습니다.' && deliverydate === '배송되지 않았습니다.'){
            	 var url = 'admin_updateorders.do?ordercode=' + ordercode; 
                 console.log(url);
                 // 페이지 이동
                 window.location.href = url;
            } else{
            Toast.fire({
        	    icon: 'error',
        	    title: '필요 없는 작업입니다.'
        	})
            }
        });
    });
</script>
</body>
</html>
