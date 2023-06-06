package com.javalec.bbs.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javalec.bbs.dao.NDOrdersDao_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;

public class NDMainAdminCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// DAO
		NDOrdersDao_OKH orderDao = new NDOrdersDao_OKH();

		// DTO
		ArrayList<NDOrdersDto_OKH> dtoOrders = orderDao.searchyearorders();
		
		Gson gson = new Gson();
        String json = gson.toJson(dtoOrders);
        
        System.out.println(json);
		// SetParam
	}
}
