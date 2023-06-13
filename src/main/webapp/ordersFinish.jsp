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

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Shopping OrdersFinish</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shopping OrdersFinish</span>
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
    <% String login = (String) session.getAttribute("ID"); %>
    <div class="row">
        <div class="col-lg-12">
        
            <form id="checkoutForm" action="insertorders.do" method="post" onsubmit="submitForm()">
                <input type="hidden" name="userid" value="<%= login %>">
             
                      <div class="text-center">
                        <h4>주문 완료</h4>
                  	  </div>
                    
                 <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                   
                                    <th>상품사진</th>
                                    <th>상품명</th>
                                   
                                    <th>수량</th>
                                    <th>가격</th>
                                </tr>
                            </thead>
                    <tbody>
                    
                        <c:set var="totalPrice" value="0" />
                        <c:forEach items="${cartOrders}" var="dto" varStatus="status">
                            <tr>
                                <td><input type="hidden" name="photo"><img src="${dto.photo}" alt="Product"></td>
                                <td><input type="hidden" name="name" value="${dto.name}">${dto.name}</td>
             
                                <td><input type="hidden" name="count" value="${dto.count}">${dto.count}</td>
                                <td>${dto.count * dto.price}&#8361;</td>
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
      <a href="#" class="primary-btn cart-btn cart-btn-right" onclick="window.location.href='userorderinfo.do'">결제내역</a>
    </div>
  </div>
</div>


        <div class="col-lg-12">
            <div class="shoping__checkout">
                <h5>결제정보</h5>
                <ul>
                    <li><fmt:formatNumber value="${totalPrice}" type="number" pattern="#,##0" />원 결제 하셨습니다.</li>
                </ul>
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