<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Dont Touch!!!!!!!!!!!!! -->
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Nutri Delights">
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

<body>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><%session.getAttribute("userid"); %></li>
                                <li>구독상품 30일 남았습니다</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__auth">
                            	<c:if test="${not empty sessionScope.ID}">
                            		<a href="logout.do"><i class="fa fa-user">Logout</i></a>
									<a href="mypage.do"><i class="fa fa-user">MyPage</i></a>
								    <!-- id session이 있는  처리할 내용 -->
								</c:if>
								<c:if test="${empty sessionScope.ID}">
									<a href="login.do"><i class="fa fa-user">Login</i></a>
									<a href="registerPage.do"><i class="fa fa-user">Register</i></a>
								    <!-- id session이 없는 경우 처리할 내용 -->
								</c:if>
                              
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./main.do"><img src="http://okrie.kro.kr:25567/images/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="/main.do">Home</a></li>
                            <!-- <li><a href="./shop-grid.html">체험단</a></li> -->
                            <li><a href="#">상품구매</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="subscribe.do">구독상품구매</a></li>
                                    <li><a href="productList.do">일반상품구매</a></li>
                                </ul>
                            </li>
                            <li><a href="notice.do">고객센터</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="heart.do"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="Cart.do"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">총금액 <span>32,000</span></div>
                    </div>
                </div>
    </header>
    <!-- Header Section End -->
</html>