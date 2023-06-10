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
		String age = request.getParameter("age");
		String telno = request.getParameter("telno");
		String address = request.getParameter("address_kakao") + " " + request.getParameter("address_detail");
		String email = request.getParameter("email");
		String allergy = request.getParameter("allergy");
		
		NDLoginDto dto = new NDLoginDto(userid, userpw, name, gender, age, telno, email, address, allergy);
		NDUserDao dao = new NDUserDao();
		dao.userInsert(dto);
	}
}
