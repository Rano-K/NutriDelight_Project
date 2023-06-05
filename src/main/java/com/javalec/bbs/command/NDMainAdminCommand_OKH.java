package com.javalec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDOrdersDao_OKH;

public class NDMainAdminCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// DAO
		NDOrdersDao_OKH orderDao = new NDOrdersDao_OKH();

		// DTO
		int[] yearordersdata = orderDao.searchyearorders();
		
		// SetParam
		request.setAttribute("yearordersData", yearordersdata);
	}
}
