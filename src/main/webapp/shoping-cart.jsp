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
                                    <th >상품명</th>
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
                      			<input type="hidden" name="count" value="${dto.count}">
                                <tr>
                                 <td class="center-align" style="text-align: center;">
                           			<input type="checkbox" name="pcode" value="${dto.pcode}" data-count="${dto.count}">
                           			

                      			 </td>
                                <td ><input type="hidden" name="photo"><img src="${dto.photo}" alt="Product"></td>
                        		<td ><input type="hidden" name="name" value="${dto.name}">${dto.name}</td>
								<td >${dto.count}</td>
								<td ><input type="hidden" name="price" value="${dto.price}">${dto.price}&#8361;</td>
								<td ><input type="hidden" name="totalPrice" value="${dto.count * dto.price}">${dto.count * dto.price}&#8361;</td>

								                        		
                        		
                                <td class="shoping__cart__item__close"><span class="icon_close" onclick="location.href='cartdelete.do?seq=${dto.seq}'">
                                </span></td>
                                
                                </tr>
                                 
                                 <c:set var="totalPrice" value="${totalPrice + (dto.count * dto.price)}" />
                          
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
                      <button type="button" onclick="submitForm('orders.do')">결제페이지로</button>
                    </form> 
                    	<script>
function submitForm(action) {
	function submitForm(action) {
	    var checkboxes = document.getElementsByName('pcode');
	    var selectedPcode = null;
	    var selectedCount = null;

	    for (var i = 0; i < checkboxes.length; i++) {
	        if (checkboxes[i].checked) {
	            selectedPcode = checkboxes[i].value;
	            selectedCount = checkboxes[i].getAttribute('data-count');
	            break; // 첫 번째로 선택된 체크박스만 처리하고 종료
	        }
	    }

	    if (selectedPcode && selectedCount) {
	        var form = document.getElementById('deleteForm');
	        form.action = action + '?pcode=' + selectedPcode + '&count=' + selectedCount;
	        form.submit();
	    } else {
	        // 선택된 체크박스가 없을 때 처리할 내용
	    }
	}
}
</script>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                    
                        <a href="#" class="primary-btn cart-btn cart-btn-right" onclick="window.location.href='main.do'">메인페이지</a>
                    </div>
                </div>
          
                <div class="col-lg-12">
                <form action="ordes.do" method="post">
                    <div class="shoping__checkout">
                    
                    	<input type="hidden" name="userid" value="${dto.userid1}">
                    	<input type="hidden" name="count" value="${dto.count}">
                    	
                        <h5>카트 총 상품가격</h5>
                        <ul>
                            <li>총 상품가격 <span>${totalPrice}&#8361;</span></li>
                            <li>총 주문가격 <span>${totalPrice}&#8361;</span></li>
                        </ul>
                        
                        
                   <button type="submit" onclick="submitForm('orders.do')">결제페이지로</button>


						
						
                    </div>
               
                    </form>
                    
                        		<script>
										function submitForm(action) {
										  var checkboxes = document.getElementsByName('pcode');
										  var selectedPcodes = [];
										  
										  for (var i = 0; i < checkboxes.length; i++) {
										    if (checkboxes[i].checked) {
										      selectedPcodes.push(checkboxes[i].value);
										    }
										  }
										  
										  var form = document.getElementById('deleteForm');
										  form.action = action + '?pcode=' + selectedPcodes.join(',');
										  form.submit();
										}
										</script>
										
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