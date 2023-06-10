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

function printName()  {
  const parent = document.getElementById('parent').value;
}

function checkOrder(event) {
	var ocodeInput = document.getElementById("ocode");
    var ocode = parseInt(ocodeInput.value);
    
	if (ocode === 0){
    	alert("구매 후 리뷰작성이 가능합니다");
    	event.preventDefault(); // 폼 제출 이벤트 중지
    }
}
</script>
<body>
	<%@ include file="header.jsp"%>
	
	<%-- <%String userid = (String) session.getAttribute("ID"); %> --%>
	
	
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
										<h6>${PList}</h6>
										</p>
										<p>
										<h4>가격 : 받아올 가격</h4>
										</p>
										<p>칼로리 : 받아올 칼로리</p>
										<p>알러지 정보</p>

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
										
										<c:set var="parentInput" value="${dto.parent}" />

										<c:if test="${dto.layer == 1}">
										<c:set var="count" value="${count + 1}" />
											<tr>
												<th scope="row">${count}</th>
												<td colspan="2">
													<table class="table">
														<tr>
															<td>
																<p>
																	${dto.userid}
																	<c:if test="${dto.userid == null}">
																	${dto.adminid}
															</c:if>
																</p>
																<p>${dto.insertdate}</p>
																<p>${PList}</p>
																<p>${dto.image}</p>
																<p>${dto.contexts}</p> <input type="hidden"
																name="parent" value="${dto.parent}">
															</td>
															<td align="right"><a href="#" class="primary-btn">
																	좋아요</a>
																<p>좋아요 수 : ${dto.likes}</p> <a href="#"
																class="primary-btn">댓글 작성</a></td>
														</tr>
														
														<c:forEach items="${RList}" var="dto" varStatus="status">
															<c:if test="${dto.layer != 1}">
																
																<c:if test="${dto.parent == parentInput}">
																	<tr>
																	<td><input value="더보기"
																		onclick="if(this.parentNode.getElementsByTagName('div')[0].style.display != ''){this.parentNode.getElementsByTagName('div')[0].style.display = '';this.value = '숨기기';}else{this.parentNode.getElementsByTagName('div')[0].style.display = 'none'; this.value = '더보기';}"
																		type="button" />
																		<div style="display: none;">

																			<table>
																				<tr>
																					<td>
																						<p>
																							${dto.userid}
																							<c:if test="${dto.userid == null}">
																								${dto.adminid}
																							</c:if>
																						</p>
																						<p>${dto.contexts}</p>
																						<p>
																							좋아요 수 : 0 <a href="#" class="primary-btn">
																								좋아요</a>
																						</p>
																					</td>
																					<td>작성일자 : 23.06.05</td>
																				<tr>
																			</table>

																		</div></td>

																	</tr>
																</c:if>
																
															</c:if>
														</c:forEach>
														
													</table>

												</td>

											</tr>
										</c:if>
									</c:forEach>

									<tr align="right">
										<td colspan="3">
											<form action="write_review.do" method="post">
												<input type="hidden" name="pname" value="${PList}">
												<input type="hidden" name="pcode" value="9">
												<input type="hidden" name="ID" value="dawn7778">
												<input type="hidden" name="ocode" value="${ocode}">
												<input type="submit" value="글쓰기" class="primary-btn" onclick="checkOrder(event)">
											</form>
										</td>
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
								
								<c:if test="${dto1Size == 0}">
									<tr align="center">
										<td>
											해당 상품에 대한 문의가 없습니다.									
										</td>
									</tr>
								</c:if>
								
								<c:forEach items="${QList}" var="dto1" varStatus="status">
									
									
									<c:if test="${dto1.layer == 1}">
										<c:set var="count1" value="${count1 + 1}" />
									<tr>
										<th scope="row">${count1}</th>
										<td colspan="2">
											<table class="table">
												<tr>
													<td>
														<p>${dto1.userid}</p>
														<p>${PList}</p>
														<p>음식사진 위치</p>
														<p>문의 제목 : ${dto1.title}</p>
														<p>문의 내용 : ${dto1.context}</p>
													</td>
												</tr>
												
											</table>
										</td>
									</tr>
										</c:if>
								</c:forEach>
									
									<tr align="right">
										<td colspan="3">
											<form action="write_board.do" method="post">
												<input type="hidden" name="pname" value="${PList}">
												<input type="hidden" name="pcode" value="9">
												<input type="hidden" name="ID" value="dawn7778">
												<input type="submit" value="문의하기" class="primary-btn">
											</form>
										</td>
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