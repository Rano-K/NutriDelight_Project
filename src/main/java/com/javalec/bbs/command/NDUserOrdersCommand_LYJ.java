package com.javalec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserOrdersDao_LYJ;
import com.javalec.bbs.dto.NDUserOrdersDto_LYJ;

public class NDUserOrdersCommand_LYJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String pcode = request.getParameter("pcode");
		String count = request.getParameter("count");
		String userid = (String) session.getAttribute("ID");
		
		NDUserOrdersDao_LYJ ndUserOrdersDao_LYJ = new NDUserOrdersDao_LYJ();
		NDUserOrdersDto_LYJ dto = ndUserOrdersDao_LYJ.productInfo(pcode);
		NDUserOrdersDto_LYJ dto1 =ndUserOrdersDao_LYJ.userInfo(userid);
			
		request.setAttribute("uInfo", dto1);
		request.setAttribute("info", dto);
		request.setAttribute("num", count);
		
		
		// ArrayList<NDUserOrdersDto_LYJ> ndUserOrdersDto_LYJs = ndUserOrdersDao_LYJ.orderslist(userid);
		// session.setAttribute("orderslist", ndUserOrdersDto_LYJs);
	
	
		
	}

}
