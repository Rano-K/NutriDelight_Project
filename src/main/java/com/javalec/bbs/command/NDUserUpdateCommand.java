package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserDao;
import com.javalec.bbs.dto.NDLoginDto;

public class NDUserUpdateCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String userid = (String) session.getAttribute("ID");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String telno = request.getParameter("telno");
		String address = request.getParameter("address_detail");
		String email = request.getParameter("email");
		String allergy = request.getParameter("allergy");
		
		NDLoginDto dto = new NDLoginDto(name, gender, age, telno, email, address, allergy);
		NDUserDao dao = new NDUserDao();
		dao.myPageUpdate(dto, userid);
	}

}
