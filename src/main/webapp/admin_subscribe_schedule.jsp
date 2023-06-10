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

<!-- Schedule for pages -->
<script
	src="
https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js
"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<link
	href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css'
	rel='stylesheet'>
<link
	href='https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.13.1/css/all.css'
	rel='stylesheet'>

<!--get attribute from java  -->
<%
ArrayList<String> dataSetSubscribe = (ArrayList<String>) request.getAttribute("dataSetSubscribe");
%>

</head>

<body id="page-top">

	<!-- Tool-bar -->
	<%@ include file="admin_toolbar.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">구독 일정</h1>
		<p class="mb-4">구독 일정을 확인해주세요.</p>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">구독 일정</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<div id='calendar'></div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i></a>
</body>
<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		
		themeSystem: 'bootstrap',
		locale: 'ko',

		headerToolbar: {
			left: 'prevYear,prev,next,nextYear today',
			center: 'title',
			right: 'dayGridMonth,dayGridWeek,dayGridDay'
		},

		selectable: true,
		selectMirror: true,

		navLinks: true, // can click day/week names to navigate views
		editable: true,

		dayMaxEvents: true, // allow "more" link when too many events
		events: ${dataSetSubscribe},
		
		eventClick: function(arg) {
			var eventTitle = arg.event.title;
			var eventStart = arg.event.start;
			var eventUname = arg.event.extendedProps.uname;
			var eventPlcode = arg.event.extendedProps.plcode;
			var eventPname = arg.event.extendedProps.pname;
			var eventAddress = arg.event.extendedProps.address;

			if (arg.event.backgroundColor === '#000000') {
				Swal.fire({
					text: "이미 배송 완료 처리되었습니다.",
					icon: "error",
					buttonsStyling: false,
					confirmButtonText: "확인",
					customClass: {
						confirmButton: "btn btn-primary",
					}
				});
			} else {
				Swal.fire({
					html: eventUname + "의 " + eventPname + "를<br> " + eventAddress + "(으)로<br> 배송 확인 처리 하시겠습니까?",
					icon: "warning",
					showCancelButton: true,
					buttonsStyling: false,
					confirmButtonText: "네, 배송 완료 처리하겠습니다!",
					cancelButtonText: "아니요, 아직 도착 안하였습니다.",
					customClass: {
						confirmButton: "btn btn-primary",
						cancelButton: "btn btn-active-light"
					}
				}).then(function(result) {
					if (result.value) {
						arg.event.setProp('backgroundColor', '#000000');
						Swal.fire({
							text: "배송 처리되었습니다.",
							icon: "success",
							buttonsStyling: false,
							confirmButtonText: "알겠습니다!",
							customClass: {
								confirmButton: "btn btn-primary",
							}
						});
						// 배송 처리
						var url = 'admin_updatesubscribe.do?plcode=?' + eventPlcode;
						window.location.href = url;
					} else if (result.dismiss === "cancel") {
						Swal.fire({
							text: "취소되었습니다.",
							icon: "error",
							buttonsStyling: false,
							confirmButtonText: "알겠습니다!",
							customClass: {
								confirmButton: "btn btn-primary",
							}
						});
					}
				});
			}
		}
	});

	calendar.render();
});

</script>
</html>
