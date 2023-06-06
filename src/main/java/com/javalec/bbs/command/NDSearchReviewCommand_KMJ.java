package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDReviewDao_KMJ;
import com.javalec.bbs.dto.NDReviewDto_KMJ;

public class NDSearchReviewCommand_KMJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//int pcode = Integer.parseInt(request.getParameter("pcode"));
		int pcode = 9;
		NDReviewDao_KMJ dao = new NDReviewDao_KMJ();
		ArrayList<NDReviewDto_KMJ> dtos = dao.reviewList(pcode);
		String name = dao.productList(pcode);
		request.setAttribute("RList", dtos);
		request.setAttribute("PList", name);
	}

}
