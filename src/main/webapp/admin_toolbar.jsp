<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<!-- Page Wrapper -->
<%
HttpSession sessions = request.getSession();
%>
<%
String ID = (String) sessions.getAttribute("ID");
%>

<div id="wrapper">
	<!-- Sidebar -->
	<ul
		class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
		id="accordionSidebar">
		<!-- Sidebar - Brand -->
		<a
			class="sidebar-brand d-flex align-items-center justify-content-center"
			href="admin_main.do"> <img alt="로고"
			src="http://okrie.kro.kr:25567/images/logo.png" width="60">
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item - Dashboard -->
		<li class="nav-item active"><a class="nav-link"
			href="admin_main.do"> <i class="fas fa-fw fa-tachometer-alt"></i>
				<span>메인으로</span></a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">관리자 메뉴</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseTwo"
			aria-expanded="true" aria-controls="collapseTwo"> <i
				class="fa fa-credit-card"></i> <span>주문관리</span>
		</a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">상세 메뉴:</h6>
					<a class="collapse-item" href="admin_searchorders.do">주문 목록</a> <a
						class="collapse-item" href="admin_graphorders.do">주문 현황 그래프</a>
				</div>
			</div></li>

		<!-- Nav Item - Utilities Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseUtilities"
			aria-expanded="true" aria-controls="collapseUtilities"> <i
				class="fa fa-play"></i> <span>구독관리</span>
		</a>
			<div id="collapseUtilities" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">상세 메뉴:</h6>
					<a class="collapse-item" href="admin_searchsubscribe.do">구독 목록</a> <a
						class="collapse-item" href="admin_schedulesubscribe.do">구독 일정</a>
				</div>
			</div></li>


		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseUser"
			aria-expanded="true" aria-controls="collapseUser"> <i
				class="fa fa-user"></i> <span>유저관리</span>
		</a>
			<div id="collapseUser" class="collapse"
				aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">상세 메뉴:</h6>
					<a class="collapse-item" href="admin_searchusers.do">유저 목록</a> <a
						class="collapse-item" href="admin_graphusers.do">유저 성향 그래프</a>
				</div>
			</div></li>


		<!-- Nav Item - Tables -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseProduct"
			aria-expanded="true" aria-controls="collapseProduct"> <i
				class="fa fa-shopping-basket"></i> <span>상품 관리</span>
		</a>
			<div id="collapseProduct" class="collapse"
				aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">상세 메뉴:</h6>
					<a class="collapse-item" href="admin_searchproduct.do">상품 목록</a> <a
						class="collapse-item" href="admin_product_insert.jsp">상품 등록</a>
				</div>
			</div></li>



		<!-- Nav Item - Tables -->
		<!-- Nav Item - Tables -->
		<li class="nav-item"><a class="nav-link collapsed" href="admin_searchboard.do"
			data-toggle="collapse" data-target="#collapseBoard"
			aria-expanded="true" aria-controls="collapseBoard"> <i
				class="fas fa-fw fa-table"></i> <span>게시판 관리</span>
		</a>
			<div id="collapseBoard" class="collapse"
				aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">상세 메뉴:</h6>
					<a class="collapse-item" href="admin_searchboard.do">게시글 목록</a> 
				</div>
			</div></li>



		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>

		<!-- Sidebar Message -->

	</ul>
	<!-- End of Sidebar -->

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<!-- Topbar -->
			<nav
				class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

				<!-- Sidebar Toggle (Topbar) -->
				<button id="sidebarToggleTop"
					class="btn btn-link d-md-none rounded-circle mr-3">
					<i class="fa fa-bars"></i>
				</button>
				<ul class="navbar-nav ml-auto">
					<!-- Nav Item - User Information -->
					<li class="nav-item dropdown no-arrow"><a
						class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <span
							class="mr-2 d-none d-lg-inline text-gray-600 small"><%=ID%>님,
								안녕하세요.</span> <i class="fa fa-user"></i>
					</a> <!-- Dropdown - User Information -->
						<div
							class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
							aria-labelledby="userDropdown">
							<a class="dropdown-item" href="#" data-toggle="modal"
								data-target="#logoutModal"> <i
								class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
								Logout
							</a>
						</div></li>

				</ul>

			</nav>
			<!-- End of Topbar -->
			<!-- Logout Modal-->
			<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">로그아웃을 누르시면, 로그아웃이 진행됩니다.</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">취소</button>
							<a class="btn btn-primary" href="logout.do">로그아웃 후, 메인페이지로
								돌아갑니다.</a>
						</div>
					</div>
				</div>
			</div>