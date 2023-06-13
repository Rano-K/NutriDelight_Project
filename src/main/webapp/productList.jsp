<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

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
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

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
<style>
.dropdown-menu {
	display: none;
	/* 드랍다운 메뉴를 기본적으로 숨깁니다 */
	position: absolute;
	background-color: white;
	padding: 10px;
	/* 드랍다운 메뉴의 스타일을 설정합니다 */
	z-index: 1;
	overflow: visible;
}

.hero__search__categories:hover .dropdown-menu {
	display: block;
	/* 마우스를 올리면 드랍다운 메뉴를 보여줍니다 */
}

.hero__item {
	position: relative;
	z-index: 0;
}

.hero__search__form {
	position: relative;
}

.hero__search__form .dropdown-menu {
	top: 100%;
	/* 드랍다운 메뉴를 카테고리 선택 영역 아래에 위치시킵니다 */
}
</style>

<body>
	<%@ include file="header.jsp"%>


	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">

				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__categories">
							<form action="searchActionProductList.do" method="get">
								<div class="hero__categories_all">
									<i class="fa fa-bars"></i> <span>정렬목록</span>
								</div>
								<ul>
									<li><a href="#">모든 제품</a></li>
									<li><a href="#">칼로리 적은순</a></li>
									<li><a href="#">가격 높은순</a></li>
									<li><a href="#">가격 낮은순</a></li>

								</ul>

								<input type="text" name="name" placeholder="What do yo u need?">
								<button type="submit" class="site-btn">SEARCH</button>
							</form>

						</div>

					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->
	<!-- ----------------------------------------------------------------------------------------------------------------------------------------- -->



	<!-- Categories Section Begin -->
	<section class="categories">
		<div class="container">
			<div class="row">
				<div class="categories__slider owl-carousel">
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="http://okrie.kro.kr:25567/images/recommend.png">
							<h5>
								
							</h5>
							<h5><a href="#">추천상품</a></h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="http://okrie.kro.kr:25567/images/all.png">
							<h5>
								<a href="#">모든상품</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="http://okrie.kro.kr:25567/images/diet.png">
							<h5>
								<a href="#">다이어트를 고민하고 있다면?</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="http://okrie.kro.kr:25567/images/lowprice.png">
							<h5>
								<a href="#">가장 저렴한 한끼</a>
							</h5>
						</div>
					</div>
					<!-- <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-5.jpg">
                            <h5><a href="#">당신을 위한 추천상품</a></h5>
                        </div>
                    </div> -->
				</div>
			</div>
		</div>
	</section>
	<!-- Categories Section End -->

	<%@ include file="productView.jsp"%>

	<!-- Banner Begin -->
	<!-- <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div> -->
	<!-- Banner End -->


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