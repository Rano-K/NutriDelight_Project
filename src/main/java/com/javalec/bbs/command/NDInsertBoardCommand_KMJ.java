package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDQuestionDao_KMJ;

public class NDInsertBoardCommand_KMJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("ID");
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		String title = (String) request.getParameter("title");
		String context = (String) request.getParameter("content");
		String img = (String) request.getParameter("image");
		
		NDQuestionDao_KMJ dao = new NDQuestionDao_KMJ();
		dao.insertBoard(id, pcode, title, context, img);
		
		
		request.setAttribute("pcode", pcode);
	}

}
