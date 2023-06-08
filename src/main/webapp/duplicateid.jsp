<%@page import="com.javalec.bbs.dao.NDUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	
	NDUserDao dao = new NDUserDao();
	boolean result = dao.userCheck(id);
	String wkResult = result == true ? "1" : "0";

	
	response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
	response.getWriter().write(wkResult);
	

%>
