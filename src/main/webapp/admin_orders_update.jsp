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
<title>주문 업데이트</title>
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
<body id="page-top">
	<%@ include file="admin_toolbar.jsp"%>
	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">주문 업데이트</h1>
		<p class="mb-4">주문목록을 확인해주시고, 업데이트해주세요.</p>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">주문 목록 업데이트</h6>
			</div>
			<div class="card-body">
				<form action="admin_updateorders_checked.do" class="user"
					method="post">
					<div class="table-responsive">
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">주문
									코드</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword"
									placeholder="${dtoOrders[0].ordercode}" disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">유저
									아이디</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword" placeholder="${dtoOrders[0].userid}"
									disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">제품
									코드</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword" placeholder="${dtoOrders[0].pcode}"
									disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">배송
									주소</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword"
									placeholder="${dtoOrders[0].address}" disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">주문
									수량</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword" placeholder="${dtoOrders[0].count}"
									disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">재고량</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword" placeholder="${Stock}"
									disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">주문
									날짜</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword"
									placeholder="${dtoOrders[0].orderdate}" disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">환불
									날짜</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword" placeholder="${Refunddate}"
									disabled="disabled">
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-1"></div>
							<div class="col-lg-2">
								<h6 style="text-align: center"
									class="m-3 font-weight-bold text-secondary order-code-label">배송
									날짜</h6>
							</div>
							<div class="col-lg-8">
								<input style="text-align: left" type="password"
									class="form-control form-control-user"
									id="exampleRepeatPassword" placeholder="${Deliverydate}"
									disabled="disabled">
							</div>
						</div>
						<hr>
						<div class="form-group row">
							<div class="col-sm-1"></div>
							<div class="col-sm-4">
								<a id="confirmRefund" class="btn btn-google btn-user btn-block">
									환불 확인</a>
							</div>
							<div class="col-sm-2"></div>
							<div class="col-sm-4">
								<a id="confirmDelivery"
									class="btn btn-facebook btn-user btn-block"> 배송 확인</a>
							</div>
							<div class="col-sm-1"></div>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i></a>
	<!-- modal  -->
	<script>
        $("#confirmRefund").click(function () {
            Swal.fire({
                title: '환불 확인',
                text: '누르시면, 되돌릴 수 없습니다.',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '승인',
                cancelButtonText: '취소'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                    	'환불 처리 완료!',
                        '환불 처리되었습니다.',
                        'success'
                    ).then(() => {
                      window.location.href= "admin_updateorders_checked.do?ordercode=${dtoOrders[0].ordercode}&insertmode=1";
                    });
                }
            })
        });

        $("#confirmDelivery").click(function () {
            Swal.fire({
                title: '배송 확인',
                text: '누르시면, 되돌릴 수 없습니다.',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '승인',
                cancelButtonText: '취소'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                    		'배송 처리 완료!',
                     '배송이 완료처리되었습니다.',
                    'success'
                    ).then(() => {
                    window.location.href="admin_updateorders_checked.do?ordercode=${dtoOrders[0].ordercode}&insertmode=2";
                    });
               }
            })
        });
</script>
</body>
</html>
