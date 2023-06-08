<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
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

	<%@ include file="header.jsp"%>
	
		<!-- Hero Section Begin -->
  
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li>로그인한 id표시</li>
                                <li>구독상품 며칠남았는지 표시</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                           <!--  <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div> -->
                            <!-- <div class="header__top__right__language">
                                <img src="img/language.png" alt="">
                                <div>English</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Spanis</a></li>
                                    <li><a href="#">English</a></li>
                                </ul>
                            </div> -->
                            <div class="header__top__right__auth">
                                <a href="#"><i class="fa fa-user"></i> 로그인안했을 때: Login,로그인했을 때:Logout</a>
                                <a href="#"><i class="fa fa-user"></i> 로그인안했을 때: 회원가입,로그인했을 때:myPage</a>
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
                        <a href="./index.html"><img src="./img/featured/로고.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="./index.html">Home</a></li>
                            <!-- <li><a href="./shop-grid.html">체험단</a></li> -->
                            <li><a href="#">상품구매</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./shop-details.html">구독상품구매</a></li>
                                    <li><a href="./shoping-cart.html">일반상품구매</a></li>
                                    <li><a href="./checkout.html"></a></li>
                                    <li><a href="./blog-details.html"></a></li>
                                </ul>
                            </li>
                            <li><a href="./blog.html">고객센터</a></li>
                            <!-- <li><a href="./contact.html">Contact</a></li> -->
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">총금액 <span>32,000</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>제품목록</span>
                        </div>
                        <ul>
                            <li><a href="#">한끼대용상품</a></li>
                            <li><a href="#">구독상품</a></li>
                            <!-- <li><a href="#">Fruit & Nut Gifts</a></li>
                            <li><a href="#">Fresh Berries</a></li>
                            <li><a href="#">Ocean Foods</a></li>
                            <li><a href="#">Butter & Eggs</a></li>
                            <li><a href="#">Fastfood</a></li>
                            <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li> -->
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">검색</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                          <!--   <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                 <form id="deleteForm" action="cartdelete.do" method="get">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                               		<th>상품사진</th>
                                    <th >상품명</th>
                                    <th>가격</th>
                                    <th>수량</th>
                                    <th>총가격</th>
                               
                                </tr>
                            </thead>
                            <tbody>
                            
                            <c:set var="totalPrice" value="0" />
                            
                              <c:forEach items="${list}" var="dto">
                   				<input type="hidden" name="userid" value="${dto.userid1}">
                   				<input type="hidden" name="seq" value="${dto.seq}">
                      			<input type="hidden" name="pcode" value="${dto.pcode}">
                                <tr>
                                <td ><input type="hidden" name="photo"><img src="${dto.photo}" alt="Product"></td>
                        		<td ><input type="hidden" name="name" value="${dto.name}">${dto.name}</td>
                        		<td ><input type="hidden" name="count" value="${dto.count}">${dto.count}&#8361;</td>
                        		<td ><input type="hidden" name="price" value="${dto.price}">${dto.price}</td>
                        		<td ><input type="hidden" name="count" value="${dto.count}">${dto.count * dto.price}&#8361;</td>
                        		
                                <td class="shoping__cart__item__close"><span class="icon_close" onclick="location.href='cartdelete.do?seq=${dto.seq}'">
                                </span></td>
                                
                                </tr>
                                 
                                 <c:set var="totalPrice" value="${totalPrice + (dto.count * dto.price)}" />
                                
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    </form> 
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="#" class="primary-btn cart-btn cart-btn-right" onclick="window.location.href='index.html'">메인페이지</a>
                    </div>
                </div>
          
                <div class="col-lg-12">
                    <div class="shoping__checkout">
                        <h5>카트 총 상품가격</h5>
                        <ul>
                            <li>총 상품가격 <span>${totalPrice}&#8361;</span></li>
                            <li>총 주문가격 <span>${totalPrice}&#8361;</span></li>
                        </ul>
                        <a href="#" class="primary-btn" href="orders.jsp?userid=${dto.userid1}" onclick="window.location.href='orders.do'">결제페이지로 이동</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->


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