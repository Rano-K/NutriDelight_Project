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
<title>게시글 목록</title>
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
<script src="admin/js/board_table.js"></script>

<!--get attribute from java  -->
<%
ArrayList<ArrayList<String>> dataSetBoard = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetBoard");
ArrayList<ArrayList<String>> dataSetReview = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetReview");
ArrayList<ArrayList<String>> dataSetNotice = (ArrayList<ArrayList<String>>) request.getAttribute("dataSetNotice");
%>

<script type="text/javascript">
	$(document).ready(function() {
		var dataSetBoard = <%=dataSetBoard%>;
		var dataSetReview =	<%=dataSetReview%>;
		var dataSetNotice =	<%=dataSetNotice%>;
		var sessionId = '<%=session.getAttribute("ID")%>';

		dataConnect(dataSetBoard, dataSetReview, dataSetNotice, sessionId);
	});
</script>

</head>

<body id="page-top">
	<%@ include file="admin_toolbar.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">게시글 목록</h1>
		<p class="mb-4">게시글 목록을 확인해주세요.</p>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary" id="headerTitle">게시글
					확인</h6>
				<div class="dropdown no-arrow">
					<a class="dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i
						class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
					</a>
					<div
						class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
						aria-labelledby="dropdownMenuLink">
						<div class="dropdown-header">게시글 목록:</div>
						<a class="dropdown-item" id="boardBtn">게시판 확인</a> <a
							class="dropdown-item" id="reviewBtn">리뷰 확인</a> <a
							class="dropdown-item" id="noticeBtn">공지사항 확인</a>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div id="boardDiv" class="table-responsive">
					<table id="boardTable" class="display" width="100%">
					</table>
				</div>
				<div id="reviewDiv" class="table-responsive">
					<table id="reviewTable" class="display" width="100%">
					</table>
				</div>
				<div id="noticeDiv" class="table-responsive">
					<table id="noticeTable" class="display" width="100%">
					</table>
				</div>
			</div>

		</div>
	</div>
	<!-- /.container-fluid -->

	<button id="edit-post-btn" class="btn btn-primary mt-3">게시글 수정</button>

	<!-- 게시글 작성 모달 -->
	<div id="post-modal" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">게시글 작성</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="post-form">
						<div class="form-group">
							<label for="post-title">제목</label> <input type="text"
								class="form-control" id="post-title" required>
						</div>
						<div class="form-group">
							<label for="post-content-input">내용</label>
							<textarea class="form-control" id="post-content-input" rows="5"
								required></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button id="save-post-btn" type="button" class="btn btn-primary">저장</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i></a>
</body>
<!-- modal -->
<script>
	$(document).ready(function() {
		// 게시글 보기 페이지
		$('#post-view-page').show();
		$('#post-modal').modal('hide');

		// 게시글 수정 버튼 클릭 시
		$('#edit-post-btn').click(function() {
			// 게시글 내용 가져오기 (예시로 임의의 내용 사용)
			var postContent = '게시글 내용';

			// 게시글 내용 표시
			$('#post-content').text(postContent);

			// 게시글 보기 화면 숨기고 모달 열기
			$('#post-view-page').hide();
			$('#post-modal').modal('show');
		});

		// 게시글 저장 버튼 클릭 시
		$('#save-post-btn').click(function() {
			// 게시글 제목과 내용 가져오기
			var postTitle = $('#post-title').val();
			var postContentInput = $('#post-content-input').val();

			// 게시글 저장 로직 추가 (여기서는 예시로 콘솔에 출력)
			console.log('게시글 제목:', postTitle);
			console.log('게시글 내용:', postContentInput);

			// 모달 닫기
			$('#post-modal').modal('hide');
			// 게시글 보기 화면 보여주기
			$('#post-view-page').show();
		});
	});
</script>
<script>
	window.addEventListener('DOMContentLoaded', function() {
		// 초기 설정
		document.getElementById('boardDiv').style.display = 'block';
		document.getElementById('reviewDiv').style.display = 'none';
		document.getElementById('noticeDiv').style.display = 'none';
	});

	document.getElementById('boardBtn').addEventListener('click', function() {
		document.getElementById('boardDiv').style.display = 'block';
		document.getElementById('reviewDiv').style.display = 'none';
		document.getElementById('noticeDiv').style.display = 'none';
		document.getElementById('boardTable').style.display = 'table';
		document.getElementById('reviewTable').style.display = 'none';
		document.getElementById('noticeTable').style.display = 'none';
		document.getElementById('headerTitle').innerText = "게시판 확인";
	});

	document.getElementById('reviewBtn').addEventListener('click', function() {
		document.getElementById('boardDiv').style.display = 'none';
		document.getElementById('reviewDiv').style.display = 'block';
		document.getElementById('noticeDiv').style.display = 'none';
		document.getElementById('boardTable').style.display = 'none';
		document.getElementById('reviewTable').style.display = 'table';
		document.getElementById('noticeTable').style.display = 'none';
		document.getElementById('headerTitle').innerText = "리뷰글 확인";
	});

	document.getElementById('noticeBtn').addEventListener('click', function() {
		document.getElementById('boardDiv').style.display = 'none';
		document.getElementById('reviewDiv').style.display = 'none';
		document.getElementById('noticeDiv').style.display = 'block';
		document.getElementById('boardTable').style.display = 'none';
		document.getElementById('reviewTable').style.display = 'none';
		document.getElementById('noticeTable').style.display = 'table';
		document.getElementById('headerTitle').innerText = "공지사항 확인";
	});
</script>
</html>
