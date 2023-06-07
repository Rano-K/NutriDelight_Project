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
										<td>
										<span>리뷰 작성</span>
											<form action="write_review_confirm.do" method="post">
												<p>작성자 : ${ID}</p>
												<p>리뷰 품목 : ${pname}</p>
												<p>사진첨부 : 사진첨부 기능 추가</p>
												<p>리뷰내용 : <textarea rows="5" cols="80" name="content" style="resize: none;"></textarea></p>
												
												<input type="hidden" name="ID" value="${ID}">
												<input type="hidden" name="pname" value="${pname}">
												<input type="hidden" name="pcode" value="${pcode}">
												<input type="hidden" name="ocode" value="${ocode}">
												<input type="hidden" name="image" value="사진 경로">
												
												
												<div align="right">
													<input type="submit" value="작성" class="primary-btn">
												</div>
											</form>
										</td>
								</tr>
							</table>
							<br />
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