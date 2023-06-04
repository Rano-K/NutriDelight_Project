package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserDao;
import com.javalec.bbs.dto.NDLoginDto;

public class NDUserInsertCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String telno = request.getParameter("telno");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String allergy = request.getParameter("allergy");
		
		NDLoginDto dto = new NDLoginDto(userid, userpw, name, gender, age, telno, email, address, allergy);
		NDUserDao dao = new NDUserDao();
		boolean result = dao.userCheck(userid);

		if(result) {
			result = dao.userInsert(dto);
			request.setAttribute("LOGIN_RESULT", result);
		} else {
			request.setAttribute("LOGIN_RESULT", "fail");
		}
	}
}
