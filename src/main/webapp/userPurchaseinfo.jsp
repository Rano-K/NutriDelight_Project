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
	<%@ include file="userSidebar.jsp" %>
	<!-- Shoping Cart Section Begin -->
	<!-- <section class="shoping-cart spad">
	    <div class="container">
	        <div class="row"> -->
	            <div class="col-lg-10 col-md-11">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr class="">
                                    <th><p>상품사진</p></th>
                                    <th><p>상품명</p></th>
                                    <th><p>수량</p></th>
                                    <th><p>가격</p></th>
                                    <th><p>구매일자</p></th>
                                    <th><p>배송상태</p></th>
                                    <th><p>환불신청</p></th>
                                    <th><p>리뷰작성</p></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="totalPrice" value="0" />
                                <c:forEach items="${USERORDERLIST}" var="dto">
	                                <input type="hidden" name="userid" value="${sessionScope.ID}">
                                    <input type="hidden" id="ordercode" name="ordercode" value="${dto.ordercode}">
                                    <input type="hidden" name="pcode" value="${dto.pcode}">
                                    <input type="hidden" name="photo">
                                    <input type="hidden" name="name" value="${dto.name}">
                                    <input type="hidden" name="count" value="${dto.count}">
                                    <input type="hidden" name="totalPrice" value="${dto.count * dto.price}">
                                    <input type="hidden" name="orderdate" value="${dto.orderdate}">
                                    <input type="hidden" name="delivery" value="${dto.deliverydate}">
                                    <input type="hidden" name="refund" value="${dto.refunddate}">
                                    <input type="hidden" name="writeReview" value="">
                                    <tr class="order-row" data-delivery-date="${dto.deliverydate}" data-refund-date="${dto.refunddate}">
                                        <td><a href="productInformSend.do?pcode=${dto.pcode}"><img src="${dto.photo}" alt="Product" width="50%"></a></td>
                                        <td>${dto.name}</td>
                                        <td>${dto.count}</td>
                                        <td>${dto.count * dto.price}&#8361;</td>
                                        <td>${dto.orderdate}</td>
                                        <!-- 현재시간과 비교하여 배송 준비중, 배송 중, 배송 완료 처리 -->
                                     	<td class="delivery-status"></td>
                                     	<!-- 환불 신청을 하지 않았다면 환불신청 버튼 노출, 환불신청을 하였다면 환불 신청 완료 -->
                                        <td class="refund-status">
                                        	<a href="#" class="btn btn-primary btn-user btn-block refund_btn" data-toggle="modal" data-target="#refundmodal" data-ordercode="${dto.ordercode}" onclick="openRefundModal(this)">${dto.refunddate}</a>
                                        </td>
                                        <!-- 리뷰 작성하는 버튼 -->
                                        <td>
                                        <a href="productInformSend.do?pcode=${dto.pcode}" class="btn btn-primary btn-user btn-block">제품<br/>페이지</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
	            </div>
	        </div>
		</div>
	</section>
	<!-- Refund Modal -->
    <div class="modal fade" id="refundmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">환불신청</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                정말 환불 하시겠습니까?
            </div>
            <input type="hidden" id="refundOrderCode">
            <div class="modal-footer">
                <!-- 여기서 위에 찾은 값이 사용 가능 할 때 확인 버튼 활성화 및 변수 저장하여 위에서 account 버튼 활성화때 이용 -->
                <button class="btn btn-primary" id="modalCheck" type="button" onclick="refundRequest()" data-dismiss="modal">확인</button>
                <button class="btn btn-primary" type="button" data-dismiss="modal">취소</button>
            </div>
        </div>
    </div>
</div>
	<script>
function processDeliveryStatus() {
	  var orders = document.getElementsByClassName("order-row");

	  for (var i = 0; i < orders.length; i++) {
	    var deliveryDate = orders[i].getAttribute("data-delivery-date");
	    var refundDate = orders[i].getAttribute("data-refund-date");
	    var now = new Date();
	    var statusElement = orders[i].querySelector(".delivery-status");
	    var refundButton = orders[i].querySelector(".refund_btn");

	    if (deliveryDate) {
	      var deliveryDateTime = new Date(deliveryDate);

	      if (deliveryDateTime < now) {
	        statusElement.textContent = "배송 완료";
	      } else {
	        statusElement.textContent = "배송 중";
	      }
	    } else {
	      statusElement.textContent = "배송 전";
	    }

	    if (refundDate) {
	      refundButton.textContent = "환불 완료";
	      refundButton.classList.add("disabled");
	      refundButton.addEventListener("click", function(event) {
	        event.preventDefault();
	      });
	    } else {
	      refundButton.textContent = "환불 신청";
	    }
	}
}

function openRefundModal(refundButton) {
	  var orderCode = refundButton.dataset.ordercode;
	  $("#refundOrderCode").text(orderCode);
	  $("#modalCheck").attr("data-ordercode", orderCode);
	  $('#refunmodal').modal('show');
}


function refundRequest(){
	var orderCode = document.getElementById('refundOrderCode').textContent;
	var refundButton = document.querySelector('.refund_btn');
	
    $.ajax({
	    type: "POST",
	    url: "NDRefund", // URL
	    data: { ordercode : orderCode },
	    success: function(result) {
	    	console.log(result)
			if (Number(result) == Number(0)) {
				alert("환불 신청 완료 되었습니다.");
		        refundButton.classList.add('disabled'); // 버튼 비활성화를 위한 클래스 추가
		        window.location.reload();
			}else{
				alert("환불 신청 실패 하였습니다. 다시 시도해주세요.");
			}
		},
		error: function(xhr, status, error) {
		    console.log("에러 발생: " + error); // 오류 메시지 출력
		}
	});
    $('#refundmodal').modal('hide');
}

// 페이지 로드 후 배송 상태 처리 실행
window.addEventListener("load", function() {
    processDeliveryStatus();
});
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