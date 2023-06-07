package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDOrdersDao_OKH;

public class NDOrdersCheckCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int ordercode = Integer.parseInt(request.getParameter("ordercode"));
		int insertmode = Integer.parseInt(request.getParameter("insertmode"));
		
		//	DAO
		NDOrdersDao_OKH ordersDao_OKH = new NDOrdersDao_OKH();
		if(insertmode == 1) {
			ordersDao_OKH.refundupdate(ordercode);
		}else {
			ordersDao_OKH.deliveryupdate(ordercode);
		}
		
	}

}
