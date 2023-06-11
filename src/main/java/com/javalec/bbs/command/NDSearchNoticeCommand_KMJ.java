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
//		NDNoticeDao_KMJ dao = new NDNoticeDao_KMJ();
//		ArrayList<NDNoticeDto_KMJ> dtos = dao.noticeList();
//		
//		String pageStr="1";
//		String paramCheck = (String)request.getParameter("page");	
//		System.out.println("page 값 : "+paramCheck);
//		if(paramCheck!="null") {
//			pageStr = paramCheck;	
//		}
////		String itemsPerPageStr = (String)request.getParameter("itemsPerPage");
//		String itemsPerPageStr = "3";
//
//		int currentPage = 1;
//		currentPage = Integer.parseInt(pageStr);
//		int itemsPerPage = 3;
//		itemsPerPage = Integer.parseInt(itemsPerPageStr);
//		
//		int startIndex = (currentPage - 1) * itemsPerPage ;
//        int endIndex = Math.min(startIndex + itemsPerPage, dtos.size());
//		int totalPage = 13;
//        ArrayList<NDNoticeDto_KMJ> currentPageItems = new ArrayList<>(dtos.subList(startIndex, endIndex));
//        
//		request.setAttribute("NList", currentPageItems);
//		request.setAttribute("totalPages", Math.ceil((double)dtos.size()/3));
//		
//		ArrayList<Integer> pageDiv = new ArrayList<>();
		
		ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            numbers.add(i);
        }

        int itemsPerPage = 5;
        int totalPages = (int) Math.ceil((double) numbers.size() / itemsPerPage);

        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            int startIndex = (currentPage - 1) * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, numbers.size());
            ArrayList<Integer> currentPageNumbers = new ArrayList<>(numbers.subList(startIndex, endIndex));

            int nextFirstNumber = (endIndex < numbers.size()) ? numbers.get(endIndex) : -1;

            System.out.println("Page " + currentPage + ": " + currentPageNumbers);
            System.out.println("Next first number: " + nextFirstNumber);
            System.out.println();
        }
		
	}
	
}
