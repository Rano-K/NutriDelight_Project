package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserOrdersDao_LYJ;

public class NDUserInsertOrdersCommand_LYJ implements NDCommand {

	@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			String userid = request.getParameter("ID");
			String pcode = request.getParameter("pcode");
			String count = request.getParameter("count");
			String address = request.getParameter("address");
			
			NDUserOrdersDao_LYJ ndUserOrdersDao_LYJ = new NDUserOrdersDao_LYJ();
			boolean result = ndUserOrdersDao_LYJ.insertOrder(userid, pcode, count, address);
			
			request.setAttribute("result", result);
		}
		
	}


