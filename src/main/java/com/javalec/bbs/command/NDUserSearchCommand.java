package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserDao;

public class NDUserSearchCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String chkId = request.getParameter("userid");

		NDUserDao dao = new NDUserDao();
		boolean result = dao.userCheck(chkId);
		if(result) {
			request.setAttribute("CKID", "1");	// 이미 존재
		} else {
			request.setAttribute("CKID", "2");	// 생성 가능
		}
	}

}
