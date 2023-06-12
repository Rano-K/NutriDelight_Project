package com.javalec.bbs.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDRemainDateDao_KMS;

public class NDRemainDateCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("ID");
		
		NDRemainDateDao_KMS dao_KMS = new NDRemainDateDao_KMS();
		Timestamp remainDate = dao_KMS.remainDate(userid);
		
		session.setAttribute("remainDate", remainDate);
	}

}
