package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserDao;
import com.javalec.bbs.dto.NDLoginDto;

public class NDUserSelectCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uid = (String) request.getSession().getAttribute("ID");
		ArrayList<NDLoginDto> dtolist = new ArrayList<>();
		
		NDUserDao dao = new NDUserDao();
		dtolist = dao.userInfo(uid);
		
		HttpSession session = request.getSession();
		session.setAttribute("userinfo", dtolist);
	}

}
