package com.javalec.bbs.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.javalec.bbs.dao.NDNoticeDao_KMJ;
import com.javalec.bbs.dto.NDNoticeDto_KMJ;

public class NDSearchNoticeCommand_KMJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		NDNoticeDao_KMJ dao = new NDNoticeDao_KMJ();
		ArrayList<NDNoticeDto_KMJ> dtos = dao.noticeList();
		
		
		
//		String pageStr = (String)request.getParameter("page");
		String pageStr = "1";
		System.out.println("page 값 : "+pageStr);
//		String itemsPerPageStr = (String)request.getParameter("itemsPerPage");
		String itemsPerPageStr = "3";

		int currentPage = 1;
		currentPage = Integer.parseInt(pageStr);
		int itemsPerPage = 3;
		itemsPerPage = Integer.parseInt(itemsPerPageStr);
		
		int startIndex = (currentPage - 1) * itemsPerPage ;
        int endIndex = Math.min(startIndex + itemsPerPage, dtos.size());
		
        ArrayList<NDNoticeDto_KMJ> currentPageItems = new ArrayList<>(dtos.subList(currentPage, endIndex));
        
		request.setAttribute("NList", currentPageItems);
		request.setAttribute("totalPages", Math.ceil(dtos.size()/3));
		
	}
	
	
	
	public static String readBody(HttpServletRequest request) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }
        return builder.toString();
	}
	
	

}
