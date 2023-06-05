package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserCartDao_LYJ;
import com.javalec.bbs.dto.NDUserCartDto_LYJ;


public class NDUserCartListCommand_LYJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("ID");
		
		NDUserCartDao_LYJ sUserCartDao_LYJ = new NDUserCartDao_LYJ();
		ArrayList<NDUserCartDto_LYJ> sUserCartDto_LYJ = sUserCartDao_LYJ.list(userid);
		session.setAttribute("list", sUserCartDto_LYJ);
		
		
	}

}
