package com.javalec.bbs.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDProductListDao_KMS;
import com.javalec.bbs.dto.NDProductListDto_KMS;


public class NDProductListCommand_KMS implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		NDProductListDao_KMS dao_KMS = new NDProductListDao_KMS();
		ArrayList<NDProductListDto_KMS> dao_KMS1 = dao_KMS.TakeAll(); 
		request.setAttribute("TakeAll", dao_KMS1);
		
		
		
	}
	
	
}
