<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>구매내역</title>

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
	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
	    <div class="container">
	        <div class="row">
	            <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>상품사진</th>
                                    <th>상품명</th>
                                    <th>수량</th>
                                    <th>가격</th>
                                    <th>구매일자</th>
                                    <th>배송상태</th>
                                    <th>환불신청</th>
                                    <th>리뷰작성</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="totalPrice" value="0" />
                                <c:forEach items="${USERORDERLIST}" var="dto">
	                                <input type="hidden" name="userid" value="${sessionScope.ID}">
                                    <input type="hidden" name="ordercode" value="${dto.ordercode}">
                                    <input type="hidden" name="pcode" value="${dto.pcode}">
                                    <tr>
                                        <td><input type="hidden" name="photo"><img src="${dto.photo}" alt="Product"></td>
                                        <td><input type="hidden" name="name" value="${dto.name}">${dto.name}</td>
                                        <td><input type="hidden" id="count" name="count" value="${dto.count}">${dto.count}</td>
                                        <td><input type="hidden" name="totalPrice" value="${dto.count * dto.price}">${dto.count * dto.price}&#8361;</td>
                                        <td><input type="hidden" name="orderdate" value="${dto.orderdate}">${dto.orderdate}</td>
                                        <!-- 현재시간과 비교하여 배송 준비중, 배송 중, 배송 완료 처리 -->
                                     	<td><input type="hidden" name="delivery" value="${dto.deliverydate}">${dto.deliverydate}</td>
                                     	<!-- 환불 신청을 하지 않았다면 환불신청 버튼 노출, 환불신청을 하였다면 환불 신청 완료 -->
                                        <td><input type="hidden" name="refund" value="${dto.refunddate}">${dto.refunddate}</td>
                                        <!-- 리뷰 작성하는 버튼 -->
                                        <td><input type="hidden" name="writeReview" value="">리뷰버튼위치</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
	            </div>
	        </div>
		</div>
	</section>

	
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