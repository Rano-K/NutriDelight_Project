<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 확인</title>
</head>
<body>
<% 
	String id = request.getParameter("uid");
	String result = (String)request.getAttribute("CKID");
	
	if(result.equals("1")){
%>
		해당 아이디는 이미 사용 중입니다. <br/>
<%	} else { %>
		해당 아이디는 사용 가능합니다. <br/>
<%	} %>
</body>
</html>