<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta name="description" content="Nutri Delights">
    <meta name="keywords" content="html, delight, neutri">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

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
    <script src="js/login.js"></script>
</head>
<body>
<!-- Featured Section Begin -->
<section class="featured spad">
	<div class="container">
		<div class="row">
		<div class="col-lg-12">
		<div class="row">
		<c:forEach items="${searchAction}" var="dto" begin="0" end="29">
				<div class="col-lg-3 col-md-4 col-sm-6 mix">
					<div class="featured__item">
						<div class="featured__item__pic set-bg" data-setbg="${dto.photo}">
							<ul class="featured__item__pic__hover">
								<li><a href="heart.do"><i class="fa fa-heart"></i></a></li>
								<li><a href="#" onclick="NDCartInsertFn(${dto.pcode})"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<input type="hidden" name="name" value ="${dto.name}"><a href="#"></a>
								<a href="productInformSend.do?pcode=${dto.pcode}">${dto.name}</a> 
								<input type="hidden" name ="pcode" value ="${dto.pcode}">
								<input type="hidden" name ="photo" value ="${dto.photo}">
								
							</h6>
							<h5><input type="hidden" name="price" value ="${dto.price}">가격: ${dto.price}</h5>
							<h5><input type="hidden" name="calories" value ="${dto.calories}">칼로리: ${dto.calories}</h5>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
			</div>
		
			<div class="col-lg-12">
				<div class="section-title">
					<h2>한끼 식사</h2>
				</div>
				<div class="featured__controls">
					<ul>
						<li class="active" data-filter="*">All</li>
						<li data-filter=".mostheart">가장 많이 찜한상품</li>
						<li data-filter=".mostpurchase">md추천상품</li>
						<li data-filter=".lowcal">저칼로리상품</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row featured__filter">
		<% String[] filtername = {"mostheart", "mostpurchase", "lowcal"}; %>
			<c:forEach items="${TakeAll}" var="dto" begin="0" end="29">
				<% int rn =(int) (Math.random()*3);  %>
				<div class="col-lg-3 col-md-4 col-sm-6 mix <%=filtername[rn]%>">
					<div class="featured__item">
						<div class="featured__item__pic set-bg" data-setbg="${dto.photo}">
							<ul class="featured__item__pic__hover">
								<li><a href="heart.do"><i class="fa fa-heart"></i></a></li>
								<li><a href="#" onclick="cartInsertFn(${dto.pcode})"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<input type="hidden" name="name" value ="${dto.name}"><a href="#"></a>
								<a href="productInformSend.do?pcode=${dto.pcode}">${dto.name}</a> 
								<input type="hidden" name ="pcode" value ="${dto.pcode}">
								<input type="hidden" name ="photo" value ="${dto.photo}">
								
							</h6>
							<h5><input type="hidden" name="price" value ="${dto.price}">가격: ${dto.price}</h5>
							<h5><input type="hidden" name="calories" value ="${dto.calories}">칼로리: ${dto.calories}</h5>
						</div>
					</div>
				</div>
			</c:forEach>
			<%-- <c:forEach items="${TakeAll }"var="item" begin="1" end="8">
				<div class="col-lg-3 col-md-4 col-sm-6 fresh-meat">
					<div class="featured__item">
						<div class="featured__item__pic set-bg" data-setbg="${item.photo }">
							<ul class="featured__item__pic__hover">
								<li><a href="heart.do"><i class="fa fa-heart"></i></a></li>
								<li><a href="cart.do"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<input type="hidden" name="name" value ="${item.name}"><a href="#">"${item.name}"</a>
							</h6>
							<h5><input type="hidden" name="price" value ="${item.price}">"${item.name}"</h5>
						</div>
					</div>
				</div>
			</c:forEach> --%>
		</div>
	</div>
</section>
<!-- Featured Section End -->
</body>
</html>