package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserDao;

public class NDUserLoginCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String result = "";
		
		System.out.println("userid = " + userid);
		System.out.println("userpw = " + userpw);
		
		NDUserDao dao = new NDUserDao();
		boolean temp = dao.isAdmin(userid);
		System.out.println("temp = " + temp);
		if(temp) {
			System.out.println("admin");
			result = dao.loginCheck(userid, userpw, "admin");
		} else {
			System.out.println("user");
			result = dao.loginCheck(userid, userpw, "user");
		}
		
		System.out.println("check in " + getClass().getName());
		System.out.println("login result = " + result);
		System.out.println("ID = " + userid);
		
		HttpSession session = request.getSession();
		session.setAttribute("login", result);
		session.setAttribute("ID", userid);
	}

}
