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
	
		
    <!-- Shoping Cart Section Begin -->
    <!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form id="deleteForm" action="cartdelete.do" method="post">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>상품사진</th>
                                    <th>상품명</th>
                                    <th>수량</th>
                                    <th>가격</th>
                                    <th>총가격</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="totalPrice" value="0" />
                                <c:forEach items="${list}" var="dto">
                                    <input type="hidden" name="userid" value="${dto.userid1}">
                                    <input type="hidden" name="seq" value="${dto.seq}">
                                    <input type="hidden" name="pcode" value="${dto.pcode}">
                                    <input type="hidden" id="count" name="count" value="${dto.count}">
                                    <tr>
                                        <td class="center-align" style="text-align: center;">
                                            <input type="checkbox" name="pcode" value="${dto.pcode}" data-count="${dto.count}">
                                        </td>
                                        <td><input type="hidden" name="photo"><img src="${dto.photo}" alt="Product"></td>
                                        <td><input type="hidden" name="name" value="${dto.name}">${dto.name}</td>
                                        <td>${dto.count}</td>
                                        <td><input type="hidden" name="price" value="${dto.price}">${dto.price}&#8361;</td>
                                        <td><input type="hidden" name="totalPrice" value="${dto.count * dto.price}">${dto.count * dto.price}&#8361;</td>
                                        <td class="shoping__cart__item__close">
                                            <span class="icon_close" onclick="location.href='cartdelete.do?seq=${dto.seq}'"></span>
                                        </td>
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
                    <a href="#" class="primary-btn cart-btn cart-btn-right" onclick="window.location.href='main.do'">메인페이지</a>
                </div>
            </div>
            <div class="col-lg-12">
                <form action="orders.do" method="post">
                    <div class="shoping__checkout">
                        <h5>카트 총 상품가격</h5>
                        <ul>
                            <li>총 상품가격 <span>${totalPrice}&#8361;</span></li>
                            <li>총 주문가격 <span>${totalPrice}&#8361;</span></li>
                        </ul>
                        <a href="#" class="primary-btn" onclick="submitForm('orders.do')">결제페이지로</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

    <!-- Shoping Cart Section End -->
<script>
function submitForm(action) {
	  // 체크된 체크박스 요소들을 선택합니다.
	  var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
	  
	  // 선택된 체크박스들을 반복하며 정보를 저장할 객체를 생성합니다.
	  var data = [];
	  checkboxes.forEach(function(checkbox) {
	    // 필요한 정보들을 추출하여 객체에 저장합니다.
	    var item = {
	      pcode: checkbox.value,
	      count: checkbox.dataset.count
	    };
	    
	    // 객체를 배열에 추가합니다.
	    data.push(item);
	  });
	  
	  // 저장한 정보를 문자열로 변환하여 쿼리스트링 형식으로 만듭니다.
	  var queryString = '';
	  data.forEach(function(item, index) {
	    var prefix = (index === 0) ? '?' : '&';
	    queryString += prefix + 'pcode=' + encodeURIComponent(item.pcode);
	    queryString += '&count=' + encodeURIComponent(item.count);
	  });
	  
	  // 최종적으로 orders.do로 이동합니다.
	  window.location.href = action + queryString;
	}
</script>

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