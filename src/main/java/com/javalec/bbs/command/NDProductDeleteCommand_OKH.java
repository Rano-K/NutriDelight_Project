package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDManageDao_OKH;

public class NDProductDeleteCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// Fields
		String pcode = request.getParameter("pcode");
		int invalidate = Integer.parseInt(request.getParameter("invalidate"));

		// DAO
		NDManageDao_OKH manageDao = new NDManageDao_OKH();
		if (invalidate == 1) {
			manageDao.deleteProduct(pcode);
		} else if(invalidate == 0){
			manageDao.recoverProduct(pcode);
		}
	}

}
