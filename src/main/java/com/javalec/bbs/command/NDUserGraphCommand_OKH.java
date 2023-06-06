package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserDao_OKH;

public class NDUserGraphCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//	DAO
		NDUserDao_OKH userDao = new NDUserDao_OKH();
		
		//	DTO
		

	}

}
