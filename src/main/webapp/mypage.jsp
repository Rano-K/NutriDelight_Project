<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MyPage</title>

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
    <script src="js/jquery-3.7.0.min.js"></script>
</head>

<body>
    <%@ include file="header.jsp"%>
    
	<!-- UserPage Section Begin -->
	<section class="product spad">
	<div class="container">
		<div class="row">
		    <div class="col-lg-3 col-md-5">
		        <div class="sidebar">
		            <div class="sidebar__item">
		                <h4>Mypage</h4>
		                <ul>
		                    <li><a href="#">상세정보</a></li>
		                    <li><a href="#">장바구니</a></li>
		                    <li><a href="#">구매내역</a></li>
		                </ul>
		            </div>
		        </div>
		    </div>
		    
		    <div class="col-lg-9 col-md-7">
		    	<div class="filter__item">
		    		<div class="row">
		    			<div class="form-group">
		    				<h5>본인 확인을 위해 비밀번호를 입력하세요.</h5>
		    			</div>
		    		</div>
		    	</div>
		    	<form action="mypageDetail.do" method="post">
	    		<div class="row">
	    			<div class="col-md-6">
	    				<div class="form-group">
	    					<label for="password">비밀번호</label>
	    					<input type="password" class="form-control" id="password" name="password" required>
	    				</div>
	    			</div>
	    			
	    			<div class="col-md-6">
	    				<div class="form-group">
	    					<label for="placholder"> </label>
	    					<br/>
	    					<input type="submit" class="btn btn-primary" value="확인">
	    				</div>
	    			</div>
	    		</div>
	    		</form>
	    	</div>
	    </div>
	</div>
	</section>

	<!-- UserPage Section End -->
	
	
    <!-- Footer Section Begin -->
  	<%@ include file="footer.jsp"%>
    <!-- Footer Section End -->
	
	<!-- Modal section Begin -->
	<!-- ID Duplicate Modal -->
    <div class="modal fade" id="idduplicateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">아이디 중복 확인</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<input type="text" class="col-sm-10" placeholder="사용할 ID를 입력 해주세요." id="inputID" name="inputID">
					<button type="button" onclick="checkDuplicate()" name="dbCheckId">중복체크</button>
					* 중복 체크를 해야 확인 버튼이 노출 됩니다. *
				</div>
				<div class="modal-footer">
					<!-- 여기서 위에 찾은 값이 사용 가능 할 때 확인 버튼 활성화 및 변수 저장하여 위에서 account 버튼 활성화때 이용 -->
					<button class="btn btn-primary" id="modalCheck" style="display: none" type="button" onclick="setStatusVar('idCheck')" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal section End -->
	
	
	
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