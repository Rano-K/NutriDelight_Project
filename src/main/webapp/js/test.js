								
						        // 페이지 관련 변수 초기화
						        var currentPage = 1;
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
								
						        // 페이지 표시
						        function displayPage() {
						            // AJAX 요청
						            $.ajax({
						                url: "notice.do", // 데이터를 불러올 URL
						                type: "POST",
						                data: {
						                    page : currentPage.val(),
						                    itemsPerPage : itemsPerPage.val()
						                },
						                
						                dataType:"json",
						                success: function(data) {
						                    // 데이터 표시
						                    
						                    var displayText = "";
						                    data.forEach(function(item) {
						                        displayText += item + ", ";
						                    });
						                    displayText = displayText.slice(0, -2); // 마지막 쉼표와 공백 제거
						                    $("#display").text(displayText);
						                },
						                error: function() {
						                    alert("데이터를 불러오는 데 실패했습니다.");
						                }
						            });
									
						            // 전체 페이지 수 업데이트
						            $.ajax({
						                url: "notice.do", // 전체 페이지 수를 불러올 URL
						                type: "POST",
						                dataType:"json",
						                success: function(data) {
						                    totalPages = xhr.getResponseHeader("totalPages");
						
						                    // 페이지 버튼 활성화/비활성화
						                    $("#prevButton").prop("disabled", currentPage === 1);
						                    $("#nextButton").prop("disabled", currentPage === totalPages);
						
						                    // 페이지 링크 표시
						                    var pageLinks = "";
						                    for (var i = 1; i <= totalPages; i++) {
						                        if (i === currentPage) {
						                            pageLinks += i + " ";
						                        } else {
						                            pageLinks += "<a href='#' class='pageLink' data-page='" + i + "'>" + i + "</a> ";
						                        }
						                    }
						                    $("#pageLinks").html(pageLinks);
						
						                    // 페이지 링크 클릭 이벤트 리스너 등록
						                    $(".pageLink").on("click", function() {
						                        var page = $(this).data("page");
						                        currentPage = page;
						                        displayPage();
						                    });
						                },
						                error: function() {
						                    alert("전체 페이지 수를 불러오는 데 실패했습니다.");
						                }
						            });
						        }
