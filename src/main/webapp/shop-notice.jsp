<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Neutri Delights">
<meta name="keywords" content="html, delight, neutri">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>하루를 신선하게</title>
<style>
	    table, th, td {
	       border: 1px solid #bcbcbc;
	    }
	    .jb-th-1{
	    	width : 200px;
	    }
	    a:link {
		  color : black;
		}
		a:visited {
		  color : black;
		}
		a:hover {
		  color : black;
		}
		a:active {
		  color : black;
		}
		.btn-1{
			background-color:white;
			border: none;
		}
		.btn-2{
			background-color:white;
			border-color:black;
		}
</style>
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
	
	
</head>

<body>
	<%@ include file="header.jsp"%>
	
    

    
	<input type="hidden" name="pcode" value="1">
	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>제품목록</span>
						</div>
						<ul>
							<li><a href="productList.do">한끼대용상품</a></li>
							<li><a href="subscribe.do">구독상품</a></li>
						</ul>
					</div>
				</div>

				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="searchActionProductList.do" method="get">
								<!-- <div class="hero__search__categories">
									All Categories <span class="arrow_carrot-down"></span>
								</div> -->
								<input type="text" name ="name" placeholder="What do yo u need?">
								<button type="submit" class="site-btn">SEARCH</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<!-- <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div> -->
						</div>
					</div>
							<table class="table table-striped" style="text-align:center;">
						
								<thead>
									<tr>
										<th scope="col">no</th>
										<th scope="col">글쓴이</th>
										<th scope="col">제목</th>
										<th class="jb-th-1" scope="col">등록날짜</th>
										<th class="jb-th-1" scope="col">수정날짜</th>
									</tr>
								</thead>
								<tbody>
										
								<c:forEach items="${NList}" var="dto" varStatus="status">
									
									<c:set var="count1" value="${count1 + 1}" />
									<tr>
										<td>
											${dto.noticeCount}
										</td>
										<td>
											${dto.id}
											<input type="hidden" name = "" id = "id" value="${dto.id}">
										</td>
										<td>
											
												
												<a href = "shop-noticeView.jsp?ID=${dto.id}&count=${dto.noticeCount}&title=${dto.title}&context=${dto.context}&insertdate=${insertdate}&updatedate=${updatedate}">
													${dto.title}
												</a>
												
											
										</td>
										<td>
											${dto.insertdate}
										</td>
										<td>
											${dto.updatedate}
										</td>
									</tr>
										
								</c:forEach>
								
								
								</tbody>
							</table> 
							<div id="pagination">
						        <button id="prevButton" disabled>Previous</button>
						        <c:forEach begin = "1" end = "${totalPages}" var="i">
						        	<c:if test = "${param.page == i}"><input type="button" name = "pageButton" class = "btn-1" value="${i}" disabled="disabled"></c:if>
						    		<c:if test = "${param.page != i}"><a href="notice.do?page=${i}"><input type="button" name = "pageButton" class = "btn-2" value="${i}"></a></c:if>
						    	</c:forEach>
						        <button id="nextButton">Next</button>
						    </div>
						    
							<div align="right">
								<c:if test="${sessionScope.ID!=null}">
									<c:if test="${sessionScope.login=='admin'}">
										<form action="write_notice.do" method="post">
											<input type="hidden" name="pname" value="${PList}">
											<input type="hidden" name="ID" value="${sessionScope.ID}">
											<input type="submit" value="공지작성" class="primary-btn">
										</form>
									</c:if>
								</c:if>
							</div>
							 <script src="js/jquery-3.7.0.min.js"></script>
							<script>
								
						        // 페이지 관련 변수 초기화
						        var currentPage = ${page};
						        var itemsPerPage = 3;
						        var totalPages;
						        var dataInput;
						        // 초기 페이지 표시
						        displayPage();
						
						        // 이벤트 리스너 등록
						        $("#prevButton").on("click", showPreviousPage);
						        $("#nextButton").on("click", showNextPage);
						
						        // 이전 페이지 보여주기
						        function showPreviousPage() {
						            if (currentPage > 1) {
						                currentPage--;
						                displayPage();
						            }
						        }
						
						        // 다음 페이지 보여주기
						        function showNextPage() {
						            if (currentPage < totalPages) {
						                currentPage++;
						                displayPage();
						            }
						        }
								
						        
						        
// 						        // 페이지 표시
// 						        function displayPage() {
// 						            // AJAX 요청
// 						            $.ajax({
// 						                url: "http://localhost:8080/Season2_Team4_Main/notice.do", // 데이터를 불러올 URL
// 						                type: "GET",
// 						                dataType: "json",
// 						                success: function(data) {
// 						                    // 데이터 표시
// 						                    var displayText = "";
// 						                    data.forEach(function(item) {
// 						                        displayText += item + ", ";
// 						                    });
// 						                    displayText = displayText.slice(0, -2); // 마지막 쉼표와 공백 제거
// 						                    $("#display").text(displayText);
// 						                    alert("연결은 됐다 임마.");
// 						                },
// 						                error: function() {
// 						                    alert("데이터를 불러오는 데 실패했습니다.");
// 						                }
// 						            });
									
// 						            // 전체 페이지 수 업데이트
// 						            $.ajax({
// 						                url: "http://localhost:8080/Season2_Team4_Main/notice.do", // 전체 페이지 수를 불러올 URL
// 						                type: "GET",
// 						                success: function(data) {
// 						                    totalPages = xhr.getResponseHeader("totalPages");
						
// 						                    // 페이지 버튼 활성화/비활성화
// 						                    $("#prevButton").prop("disabled", currentPage === 1);
// 						                    $("#nextButton").prop("disabled", currentPage === totalPages);
						
// 						                    // 페이지 링크 표시
// 						                    var pageLinks = "";
// 						                    for (var i = 1; i <= totalPages; i++) {
// 						                        if (i === currentPage) {
// 						                            pageLinks += i + " ";
// 						                        } else {
// 						                            pageLinks += "<a href='#' class='pageLink' data-page='" + i + "'>" + i + "</a> ";
// 						                        }
// 						                    }
// 						                    $("#pageLinks").html(pageLinks);
						
// 						                    // 페이지 링크 클릭 이벤트 리스너 등록
// 						                    $(".pageLink").on("click", function() {
// 						                        var page = $(this).data("page");
// 						                        currentPage = page;
// 						                        displayPage();
// 						                    });
// 						                },
// 						                error: function() {
// 						                    alert("전체 페이지 수를 불러오는 데 실패했습니다.");
// 						                }
// 						            });
// 						        }
						    </script>
						    
							
						   
					</div>
				
				
			</div>
		</div>
	</section>
	<!-- Hero Section End -->
	<!-- ----------------------------------------------------------------------------------------------------------------------------------------- -->

	<!-- Featured Section Begin -->
	<section class="featured spad"></section>
	<!-- Featured Section End -->

	<!-- Footer Section Begin -->
	<%@ include file="footer.jsp"%>

	<!-- Footer Section End -->
	
	<!-- Js Plugins -->
	
	

</body>

</html>