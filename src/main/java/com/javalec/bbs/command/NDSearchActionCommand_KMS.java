package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDSearchActionDao_KMS;
import com.javalec.bbs.dto.NDSearchActionDto_KMS;

public class NDSearchActionCommand_KMS implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String rice = request.getParameter("rice");
		String cook1 = request.getParameter("cook1");
		String cook2 = request.getParameter("cook2");
		String cook3 = request.getParameter("cook3");
		String soup = request.getParameter("soup");
		
		NDSearchActionDao_KMS dao_KMS = new NDSearchActionDao_KMS();
		ArrayList<NDSearchActionDto_KMS> dao_KMS1 = dao_KMS.searchAction(name, category, rice, cook1, cook2, cook3, soup);
		request.setAttribute("searchAction", dao_KMS1);

	}

}
