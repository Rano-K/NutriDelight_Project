<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>My JSP Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body>
1
<%
	String code = "";
	String error = "";
	String state = "";
	try{
		code = request.getParameter("code");
		error = request.getParameter("error");
		state = request.getParameter("state");
		out.print(code);
		
		if(code != null){ %>
		<script>
			const kakao_url = "https://kauth.kakao.com/oauth/token"
			const client_id = "ef894ee905a0643b7844daf7341d7569"
			const redirect_uri = "http://localhost:8080/Season2_Team4_Main/oauth/kakao/"
			const code = "<%=code%>"
			
			$.ajax({
				url: kakao_url,
				type: 'POST',
				dataType: 'json',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
				},
				data: {
					grant_type: 'authorization_code',
					client_id: client_id,
					redirect_uri: redirect_uri,
					code: code
				},
				success: function(data){
					console.log(data)
					kakao_userinfo(data.access_token)
					
				},
				error : function(e){
					console.log(e)
				}
			});
			
			</script> <%
		}
	}catch(Exception e){
		if(code == null || error != null || state != null){ %>
		<script>
			alert("로그인 실패 다시 시도해주세요.")
			window.location.href = "login.do"
		</script> <%
		}
	}
%>
</body>
</html>