package com.javalec.bbs.command;

import java.util.ArrayList;

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
		String userid = (String) session.getAttribute("ID");
		
		NDUserOrdersDao_LYJ ndUserOrdersDao_LYJ = new NDUserOrdersDao_LYJ();
		ArrayList<NDUserOrdersDto_LYJ> ndUserOrdersDto_LYJs = ndUserOrdersDao_LYJ.orderslist(userid);
		session.setAttribute("orderslist", ndUserOrdersDto_LYJs);
		
	}

}
