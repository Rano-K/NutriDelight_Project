package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDNoticeDao_KMJ;
import com.javalec.bbs.dto.NDNoticeDto_KMJ;

public class NDSearchNoticeCommand_KMJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NDNoticeDao_KMJ dao = new NDNoticeDao_KMJ();
		ArrayList<NDNoticeDto_KMJ> dtos = dao.noticeList();
		
		request.setAttribute("NList", dtos);
	}

}
