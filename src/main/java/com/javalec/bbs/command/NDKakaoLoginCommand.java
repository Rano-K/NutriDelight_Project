package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserDao;

public class NDKakaoLoginCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		
		NDUserDao dao = new NDUserDao();
		boolean result = dao.userCheck(userid);
		String wkResult = result == true ? "user" : "admin";
		
		HttpSession session = request.getSession();
		session.setAttribute("login", wkResult);
		session.setAttribute("ID", userid);
	}

}
