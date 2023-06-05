package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserDao;

public class NDUserLoginCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userid = request.getParameter("uid");
		String userpw = request.getParameter("upw");
		String result = "";
		
		NDUserDao dao = new NDUserDao();
		boolean temp = dao.isAdmin(userid);
		if(temp) {
			result = dao.loginCheck(userid, userpw, "admin");
		} else {
			result = dao.loginCheck(userid, userpw, "user");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("login", result);
		session.setAttribute("ID", userid);
	}

}
