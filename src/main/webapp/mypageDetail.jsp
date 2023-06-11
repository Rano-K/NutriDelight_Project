<%@page import="com.javalec.bbs.function.AllergyList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 상세정보</title>
<script src="js/login.js"></script>
<script src="js/jquery-3.7.0.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
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
            
                <!-- Nested Row within Card Body -->
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">회원 상세정보</h1>
                            </div>
                            <form class="user" action="userinfoupdate.do" method="get" name="user">
							<c:forEach items="${userinfo}" var="user">
                            	<div class="form-group">
                                	<input type="text" class="form-control form-control-user" name="userid" id="userid" placeholder="ID" readonly="readonly" value="${sessionScope.ID}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="name" placeholder="Name" name="name" value="${user.name}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="telno" placeholder="Phone Number (ex 010-0000-0000)" name="telno" value="${user.telno}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="email" placeholder="Email" name="email" value="${user.email}">
                                </div>
                                <div class="form-group row">
                                	<div class="col-sm-9 mb-3 mb-sm-0">
                                    	<input type="text" class="form-control form-control-user" id="address_kakao" placeholder="address" readonly="readonly" name="address_kakao" value="${user.address}">
                                    </div>
                                    <div class="col-sm-3">
                                    	<a href="#" id="addressbtn" class="btn btn-primary btn-user btn-block" onclick="addressbtn()">주소 찾기</a>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="address_detail" placeholder="Address" name="address_detail" value="${user.address}">
                                </div>
                                <div class="form-group sm">
                                    <input type="text" class="form-control form-control-user" id="age" placeholder="Birthdate ex)2000.01.01" name="age" onkeyup="formatBirthdate(this)" value="${user.age}">
                                </div>
                                <div class="form-group sm">
                                    <input type="text" class="form-control form-control-user" name="gender" value="${user.gender}" readonly="readonly">
                             	</div>
                             	<p></p>
                                <!-- 알러지 모달 -->
                                <input type="hidden" id="allergyCheck" name="allergyCheck" value="0">
                                <div class="form-group">
                                	<a href="#" class="btn btn-primary btn-user btn-block" data-toggle="modal" data-target="#allergyModal" style="margin-left: auto; margin-right: auto;"> 알레르기 정보 </a>
                                </div>
                                <hr>
							</c:forEach>
                            </form>
                            <!--  회원가입 눌렀을 때 -->
                           	<a href="#" class="btn btn-primary btn-user btn-block" onclick="updateMember()"> 수정 </a>
                            <hr>
							<input type="hidden">
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
														<input type="checkbox" id="allergy" value="'${enumValue.label()}'" name="allergy">
														${enumValue.label()} <br/>
													</c:forEach>
											</div>
											<div class="modal-footer">
												<button class="btn btn-primary" type="button" onclick="setStatusVar('allergyCheck')" data-dismiss="modal">확인</button>
											</div>
										</div>
									</div>
								</div>
                            
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
	<%@ include file="footer.jsp"%>
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>