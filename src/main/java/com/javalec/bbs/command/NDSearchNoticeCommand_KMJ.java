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
		
		
		String pageStr="1";
		String paramCheck = (String)request.getParameter("page");	
		System.out.println("page 값 : "+paramCheck);
		if(paramCheck!="null") {
			pageStr = paramCheck;	
		}
//		String itemsPerPageStr = (String)request.getParameter("itemsPerPage");
		String itemsPerPageStr = "3";

		int currentPage = 1;
		currentPage = Integer.parseInt(pageStr);
		int itemsPerPage = 3;
		itemsPerPage = Integer.parseInt(itemsPerPageStr);
		
		int startIndex = (currentPage - 1) * itemsPerPage ;
        int endIndex = Math.min(startIndex + itemsPerPage, dtos.size());
		
        ArrayList<NDNoticeDto_KMJ> currentPageItems = new ArrayList<>(dtos.subList(startIndex, endIndex));
        
		request.setAttribute("NList", currentPageItems);
		request.setAttribute("totalPages", Math.ceil((double)dtos.size()/3));
		
	}
	
	
	

}
