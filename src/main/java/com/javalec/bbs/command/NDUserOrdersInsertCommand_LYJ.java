package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserOrdersDao_LYJ;

public class NDUserOrdersInsertCommand_LYJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String pcode = request.getParameter("pcode");
		String count = request.getParameter("count");
		String address = request.getParameter("address");
		
		NDUserOrdersDao_LYJ ndUserOrdersDao_LYJ = new NDUserOrdersDao_LYJ();
		boolean list = ndUserOrdersDao_LYJ.insertOrder(userid, pcode, count, address);
		
		request.setAttribute("list", list);
	}

}
