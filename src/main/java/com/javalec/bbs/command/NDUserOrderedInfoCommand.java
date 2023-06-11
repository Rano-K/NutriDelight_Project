package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserDao;
import com.javalec.bbs.dto.NDUserOrdersDto;

public class NDUserOrderedInfoCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("ID");
		
		NDUserDao dao = new NDUserDao();
		ArrayList<NDUserOrdersDto> dtos = dao.mypageUserOrderinfo(userid); 
		session.setAttribute("USERORDERLIST", dtos);

	}

}
