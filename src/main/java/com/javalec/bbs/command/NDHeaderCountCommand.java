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
		/*
		 * System.out.println("heartCount=" + countHeart);
		 * System.out.println("cartCount=" + cartCount);
		 * System.out.println("cartTotalPrice=" + cartTotalPrice);
		 */
		session.setAttribute("heartCount", countHeart);
        session.setAttribute("cartCount", cartCount);
        session.setAttribute("cartTotalPrice", cartTotalPrice);

	}

}
