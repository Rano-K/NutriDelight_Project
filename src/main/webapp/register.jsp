<%@page import="com.javalec.bbs.function.AllergyList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="register">
    <meta name="author" content="okrie">

    <title>Register</title>

    <!-- Custom fonts for this template-->
    <link href="admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
    <script src="js/login.js"></script>
</head>

<body class="bg-gradient-primary">
	<%@ include file="header_login.jsp"%>
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user">
                                <div class="form-group row">
                                	<div class="col-sm-9 mb-3 mb-sm-0">
                                		<input type="hidden" id="uid" value="">
                                   		<input type="text" class="form-control form-control-user" id="userid" placeholder="ID" disabled="disabled">
                                   	</div>
                                   	<div class="col-sm-3">
	                                   	<!-- 사용 가능 확인 터치하여 나왔을 떄 비활성화 처리 해야 함 -->
	                                   	<input type="hidden" id="idCheck" name="idCheck" value="0">
                                   		<a href="#" class="btn btn-primary btn-user btn-block" data-toggle="modal" data-target="#idduplicateModal">ID 중복체크</a>
									</div>
                               	</div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="name" placeholder="Name">
                                </div>
                               	<div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="password1"
                                            placeholder="Password" onkeyup="checkPassword()">
									</div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="password2"
                                            placeholder="Repeat Password" onkeyup="checkPassword()">
									</div>
                                </div>
                                <div class="form-group sm">
                                	<input id="passwordStatus" class="form-control form-control-user" disabled="disabled" placeholder="비밀번호 일치 여부">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="telno" placeholder="Phone Number (ex 010-0000-0000)">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="email" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="address" placeholder="Address" value="api 현재 미적용">
                                </div>
                                <div class="form-group sm">
                                    <input type="text" class="form-control form-control-user" id="age" placeholder="Birthdate ex)2000.01.01">
                                </div>
                                <div class="input-group-text col-sm-12">
                                    <input type="radio" style="margin-left: 20%" id="male" name="gender" value="male" checked="checked"> 남자
                                    <input type="radio" style="margin-left: 30%" id="female" name="gender" value="female"> 여자
                             	</div>
                             	<p></p>
                                <!-- 알러지 모달 -->
                                <input type="hidden" id="allergyCheck" name="allergyCheck" value="0">
                                <div class="form-group">
                                	<a href="#" class="btn btn-primary btn-user btn-block" data-toggle="modal" data-target="#allergyModal" style="margin-left: auto; margin-right: auto;"> 알러지 체크 하기 </a>
                                </div>
                                <hr>
                                <!-- 회원가입 눌렀을 때  -->
                               	<a href="#" class="btn btn-primary btn-user btn-block" onclick="checkMember()"> Register Account </a>
                                <hr>
                                <a href="#" class="btn btn-kakao btn-user btn-block">
                                	<i class="fas fa-comment-dots fa-flip-horizontal"></i> Register with Kakao 미적용
                                </a>
                                <a href="#" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google 미적용
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.do">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
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
				<div class="modal-body">
					<button type="button" onclick="checkTest()" >TEST</button>
					* 중복 체크를 해야 확인 버튼이 노출 됩니다. *
				</div>
				<div class="modal-footer">
					<!-- 여기서 위에 찾은 값이 사용 가능 할 때 확인 버튼 활성화 및 변수 저장하여 위에서 account 버튼 활성화때 이용 -->
					<button class="btn btn-primary" id="modalCheck" style="display: none" type="button" onclick="setStatusVar('idCheck')" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
    <!-- allergy Modal -->
    <div class="modal fade" id="allergyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">알러지 선택하기</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<c:set var="enumValues" value="<%=AllergyList.values()%>"/>
                    	<c:forEach items="${enumValues}" var="enumValue">
							<input type="checkbox" id="allergy" value="${enumValue}">
							${enumValue.label()} <br/>
					</c:forEach>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="button" onclick="setStatusVar('allergyCheck')" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>

    <!-- Bootstrap core JavaScript-->
    <script src="admin/vendor/jquery/jquery.min.js"></script>
    <script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="admin/js/sb-admin-2.min.js"></script>
    <script src="admin/vendor/jquery/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    	function checkTest() {
    		const param =  {
    			id: "test234"
    		}
    	
    		console.log(typeof param);
    		console.log(param);
    		let jsonObj = JSON.stringify(param);
    		console.log(typeof jsonObj);
    		console.log(jsonObj);
    		
    		$.ajax({
			    type: "POST",
			    url: "test.login", // URL 세이브 좆ㄱ타
			    // contentType:"application/json",
			    dataType:"json",
			    data: jsonObj,
			    success: function(result) {
					console.log(result)
				},
				error: function(xhr, status, error) {
				    console.log("에러 발생: " + error); // 오류 메시지 출력
				}
			});
    	}
    </script>

</body>

</html>