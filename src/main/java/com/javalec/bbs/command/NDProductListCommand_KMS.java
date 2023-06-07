package com.javalec.bbs.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDProductListDao_KMS;
import com.javalec.bbs.dto.NDProductListDto_KMS;


public class NDProductListCommand_KMS implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String pcode = null;
		String name = null;
		int price = 0;
		String photo = null;
		
		NDProductListDao_KMS dao_KMS = new NDProductListDao_KMS();
		ArrayList<NDProductListDto_KMS> dto_KMS= dao_KMS.TakeAll(pcode, name, price, photo);
		
		
		session.setAttribute("TakeAll", dto_KMS);

    
}
	
	
	
	
	
	
	
	
	
}
