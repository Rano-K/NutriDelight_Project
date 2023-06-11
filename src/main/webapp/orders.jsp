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
    
		
			
			<style>
			.row {
			  display: flex;
			  justify-content: flex-start;
			}
			
			.table1 {
			  margin-left: 100px;
			}
			</style>
    
</head>
<%
	Boolean result = (Boolean) request.getAttribute("list");
%>

<script>
function checkResult(event) {
    var sendResult = '<%=result %>';
    
    if (sendResult === 'false'){
    	alert("주문에 실패했습니다.");
    	event.preventDefault(); // 폼 제출 이벤트 중지
    }else {
    	alert("주문이 완료되었습니다.");
    }
}
</script>

<body>   
    <%@ include file="header.jsp"%>

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
	    		<%
					String login = (String)session.getAttribute("ID"); 
				%>
                <div class="row">
                	<div class="col-lg-12">
                	<form action="insertorders.do" method="post">
						<input type="hidden" name="userid" value="<%= login %>">
						<input type="hidden" name="pcode" value="${info.pcode}">
						<input type="hidden" name="count" value="${num}">
						<table class="table1">

							
							<tr>
							
								<td colspan="3">
									<div class="product-info">
									
										<p>수령인 : ${uInfo.name}</p>
										<p>수령인 전화번호 : ${uInfo.telno}</p>
										<p>배송지 : <input type="text" name="address" value="${uInfo.address}"></p>
										<p>이메일 : ${uInfo.email}</p>
										<img src="${info.photo}" alt="Product">
										<p>품목명 : ${info.name}</p>
										<p>수량 : ${num}</p>	
										<p>가격 : ${info.price * num}</p>
																												
									</div>
								</td>
							</tr>
					</table>
					<button type="submit" onclick="submitForm('insertorders.do')">결제하기</button>
					
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
                 
                    <div class="shoping__checkout">
                        <h5>카트 총 상품가격</h5>
                        <ul>
                        <li>총 상품가격 : <fmt:formatNumber value="${info.price * num}" type="number" pattern="#,##0" />원</li>
                        <li>총주문가격 : <fmt:formatNumber value="${info.price * num}" type="number" pattern="#,##0" />원</li>
                        </ul>
                       
                        <a class="primary-btn" onclick="window.location.href='insertorders.do'">결제하기</a>
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