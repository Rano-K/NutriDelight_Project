package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDPlanDao_OKH;

public class NDSubscribeUpdateCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int plcode = Integer.parseInt(request.getParameter("plcode"));
		
		//	DAO
		NDPlanDao_OKH planDao = new NDPlanDao_OKH();
		planDao.updateSubscribe(plcode);
	}

}
