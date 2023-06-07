package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NDWriteReviewPageCommand_KMJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pname = (String) request.getParameter("pname");
		String id = (String) request.getParameter("ID");
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		int ocode = Integer.parseInt(request.getParameter("ocode"));
		System.out.println("커맨드 값 : "+pname+" "+id);
		request.setAttribute("ID", id);
		request.setAttribute("pname", pname);
		request.setAttribute("ocode", ocode);
		request.setAttribute("pcode", pcode);
	}

}
