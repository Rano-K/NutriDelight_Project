package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDQuestionDao_KMJ;
import com.javalec.bbs.dao.NDReviewDao_KMJ;
import com.javalec.bbs.dto.NDQuestionDto_KMJ;
import com.javalec.bbs.dto.NDReviewDto_KMJ;

public class NDSearchReviewCommand_KMJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//int pcode = Integer.parseInt(request.getParameter("pcode"));
		//String userid = request.getParameter("ID");
		String userid = "dawn7778";
		int pcode = 9;
		NDReviewDao_KMJ dao = new NDReviewDao_KMJ();
		NDQuestionDao_KMJ dao1 = new NDQuestionDao_KMJ();
		ArrayList<NDReviewDto_KMJ> dtos = dao.reviewList(pcode);
		ArrayList<NDQuestionDto_KMJ> dtos1 = dao1.QuestionList(pcode);
		int ocode = dao.getOrdercode(userid, pcode);
		
		
		System.out.println("dtos 크기"+dtos.size());
		System.out.println("dtos1 내용"+dtos1.size());
		
		String name = dao.productList(pcode);
		request.setAttribute("RList", dtos);
		request.setAttribute("QList", dtos1);
		request.setAttribute("PList", name);
		request.setAttribute("ocode", ocode);
		request.setAttribute("dto1Size", dtos1.size());
	}

}
