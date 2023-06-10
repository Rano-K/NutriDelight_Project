package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDHeaderCountDao_KMS;

public class NDHeaderCountCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("ID");
		
		NDHeaderCountDao_KMS dao_KMS = new NDHeaderCountDao_KMS();
		int countHeart = dao_KMS.heartCount(userid);
		int cartCount = dao_KMS.cartCount(userid);
		int cartTotalPrice = dao_KMS.cartTotalPrice(userid);
		request.setAttribute("heartCount", countHeart);
        request.setAttribute("cartCount", cartCount);
        request.setAttribute("cartTotalPrice", cartTotalPrice);

	}

}
