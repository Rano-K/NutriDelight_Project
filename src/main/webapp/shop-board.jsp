<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Neutri Delights">
<meta name="keywords" content="html, delight, neutri">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>하루를 신선하게</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<script>
// $(function(){
//     $("div").slice(0, 1).show(); // 초기갯수
//     $("#load").click(function(e){ // 클릭시 more
//         e.preventDefault();
//         $("div:hidden").slice(0, 1).show(); // 클릭시 more 갯수 지저정
//         if($("div:hidden").length == 0){ // 컨텐츠 남아있는지 확인
//             alert("게시물의 끝입니다."); // 컨텐츠 없을시 alert 창 띄우기 
//         }
//     });
// });
</script>
<body>
	<%@ include file="header.jsp"%>
	
	<input type="hidden" name="pcode" value="1">
	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>제품목록</span>
						</div>
						<ul>
							<li><a href="#">한끼대용상품</a></li>
							<li><a href="#">구독상품</a></li>
						</ul>
					</div>
				</div>

				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									All Categories <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="What do yo u need?">
								<button type="submit" class="site-btn">SEARCH</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<!-- <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div> -->
						</div>
					</div>


					<div align="center">
						<div class="hero__text">
							<table>
								<tr>
									<td><img src="admin/img/admin_img.png" alt="Product 3"></td>
									<td><span>Product Info</span>
										<p>
										<h6>내가 클릭한 음식 이름</h6>
										</p>
										<p>
										<h4>가격 : 받아올 가격</h4>
										</p>
										<p>칼로리 : 받아올 칼로리</p>


										<div class="quantity">
											수량 :
											<div class="pro-qty">
												<input type="text" name="qty" value="1">
											</div>
											<a href="#" class="primary-btn">Buy Now</a> <a href="#"
												class="primary-btn">Add Cart</a>
										</div></td>
								</tr>
							</table>
							<br />
						</div>
					</div>

					<div class="container">
						<div class="row">
							<p>
							<h3>상품리뷰</h3>
							</p>
							<table class="table">
								<thead>

								</thead>
								<tbody>
								<c:forEach items="${RList}" var="dto" varStatus="status">
								
								<%-- <c:if test="${dto.layer eq 1}"> --%>
									<tr>
										<th scope="row">${status.count}</th>
										<td colspan="2">
											<table class="table">
												<tr>
													<td>
														<p>
															${dto.userid}
															<%-- <c:if test="${dto.userid eq null}">
																	${dto.adminid}
															</c:if> --%>
														</p>
														<p>${dto.date}</p>
														<p>${PList}</p>
														<p>${dto.image}</p>
														<p>${dto.contexts}</p>
														<input type="hidden" name="parent" value="${dto.parent}">
													</td>
													<td align="right"><a href="#" class="primary-btn">어우
															좋아요</a>
														<p>좋아요 수 : ${dto.likes}</p> <a href="#" class="primary-btn">댓글 작성</a>
													</td>
												</tr>
												<tr>
													<td>
														<input value="더보기" onclick="if(this.parentNode.getElementsByTagName('div')[0].style.display != ''){this.parentNode.getElementsByTagName('div')[0].style.display = '';this.value = '숨기기';}else{this.parentNode.getElementsByTagName('div')[0].style.display = 'none'; this.value = '더보기';}" type="button" />
														<div style="display:none;">
<%-- 														<c:if test="${dto.layer!=1}"> --%>
<%-- 															<c:if test="${param.parent eq dto.parent}"> --%>
																<table>
																		<tr>
																			<td>
																				<p>댓글 쓴 사람 아이디</p>
																				<p>댓글 내용</p>
																				<p>
																					좋아요 수 : 0 <a href="#" class="primary-btn">어우 좋아요</a>
																				</p>
																			</td>
																			<td>작성일자 : 23.06.05</td>
																		<tr>
																</table>
<%-- 															</c:if> --%>
<%-- 														</c:if> --%>
															
														</div>
														
													</td>
												</tr>
												
											</table>
											
										</td>

									</tr>
								<%-- </c:if> --%>
									
									
									</c:forEach>
									
									<tr align="right">
										<td colspan="3"><a href="#" class="primary-btn">글쓰기</a></td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>

					<div class="container">
						<div class="row" style="border: 2px solid">
							<p>
							<h3>상품문의</h3>
							</p>
							<table class="table">
								<thead>
									<tr>
<!-- 										<th scope="col">#</th> -->
<!-- 										<th scope="col">First</th> -->
<!-- 										<th scope="col">Last</th> -->
<!-- 										<th scope="col">Handle</th> -->
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td colspan="2">
											<table class="table">
												<tr>
													<td>
														<p>작성한 고객 아이디 : Mark</p>
														<p>클릭한 음식 이름</p>
														<p>음식사진 위치</p>
														<p>문의내용</p>

													</td>
													<td align="right">
														<p>작성일자 : 23.06.05</p>
														<a href="#" class="primary-btn">답변 작성</a>
													</td>

												</tr>

												<tr align="right">
													<td align="left">
														<p>댓글 쓴 사람 아이디 : 댓글 내용</p>
													</td>
													<td>작성일자 : 23.06.05</td>
												</tr>
											</table>
										</td>

									</tr>
									<tr>
										<th scope="row">2</th>
										<td colspan="2">
											<table class="table">
												<tr>
													<td>
														<p>작성한 고객 아이디 : Yass</p>
														<p>클릭한 음식 이름</p>
														<p>음식사진 위치</p>
														<p>문의내용</p>

													</td>
													<td align="right">
														<p>작성일자 : 23.06.05</p>
														<a href="#" class="primary-btn">답변 작성</a>
													</td>

												</tr>

												<tr align="right">
													<td align="left">
														<p>댓글 쓴 사람 아이디 : 댓글 내용</p>
													</td>
													<td>작성일자 : 23.06.05</td>
												</tr>
											</table>
										</td>

									</tr>
									<tr>
										<th scope="row">3</th>
										<td colspan="2">
											<table class="table">
												<tr>
													<td>
														<p>작성한 고객 아이디 : What</p>
														<p>클릭한 음식 이름</p>
														<p>음식사진 위치</p>
														<p>문의내용</p>

													</td>
													<td align="right">
														<p>작성일자 : 23.06.05</p>
														<a href="#" class="primary-btn">답변 작성</a>
													</td>

												</tr>

												<tr align="right">
													<td align="left">
														<p>댓글 쓴 사람 아이디 : 댓글 내용</p>
													</td>
													<td>작성일자 : 23.06.05</td>
												</tr>
											</table>
										</td>

									</tr>
									<tr align="right">
										<td colspan="3"><a href="#" class="primary-btn">문의하기</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->
	<!-- ----------------------------------------------------------------------------------------------------------------------------------------- -->

	<!-- Featured Section Begin -->
	<section class="featured spad"></section>
	<!-- Featured Section End -->

	<!-- Footer Section Begin -->
	<%@ include file="footer.jsp"%>

	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>

</body>

</html>