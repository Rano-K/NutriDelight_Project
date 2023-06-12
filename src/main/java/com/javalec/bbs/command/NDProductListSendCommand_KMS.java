package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NDProductListSendCommand_KMS implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		String pcode = request.getParameter("pcode");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String photo = request.getParameter("photo");
		String calories = request.getParameter("calories");
		
		request.setAttribute("pcode", pcode);
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("photo", photo);
		request.setAttribute("calories", calories);
		
	}

}
