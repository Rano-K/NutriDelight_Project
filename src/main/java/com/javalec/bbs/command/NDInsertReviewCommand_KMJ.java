package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDReviewDao_KMJ;

public class NDInsertReviewCommand_KMJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("ID");
		String pcodetemp = (String) request.getParameter("pcode");
		
		System.out.println("커맨드 pcode 확인 : "+pcodetemp+id);
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		int ocode = Integer.parseInt(request.getParameter("ocode"));
		String contexts = (String) request.getParameter("content");
		String img = (String) request.getParameter("image");
		
		NDReviewDao_KMJ dao = new NDReviewDao_KMJ();
		dao.insertReview(id, pcode, ocode, contexts, img);
		
		
		request.setAttribute("pcode", pcode);
	}

}
