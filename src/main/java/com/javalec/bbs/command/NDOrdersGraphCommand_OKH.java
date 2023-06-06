package com.javalec.bbs.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDOrdersDao_OKH;
import com.javalec.bbs.dao.NDProductDao_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;
import com.javalec.bbs.dto.NDProductDto_OKH;

public class NDOrdersGraphCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// DAO
		NDProductDao_OKH ndProductDao_OKH = new NDProductDao_OKH();
		NDOrdersDao_OKH ndOrdersDao_OKH = new NDOrdersDao_OKH();

		// DTO
		ArrayList<NDProductDto_OKH> dtoProduct = ndProductDao_OKH.searchOrders();
		ArrayList<ArrayList<String>> dataSetup = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRow = new ArrayList<String>();
		headerRow.add("'음식 이름'");
		headerRow.add("'주문 개수'");
		dataSetup.add(headerRow);
		for (int i = 0; i < dtoProduct.size(); i++) {
			NDProductDto_OKH productDto = dtoProduct.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + productDto.getName() + "'");
			row.add(Integer.toString(productDto.getTotalorders()));
			dataSetup.add(row);
		}
		
		ArrayList<NDOrdersDto_OKH> dtoOrder = ndOrdersDao_OKH.searchWeekorders();
		ArrayList<ArrayList<String>> dataSetbelow = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowbelow = new ArrayList<String>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd (E)");
		
		headerRowbelow.add("'날짜'");
		headerRowbelow.add("'주문 개수'");
		dataSetbelow.add(headerRow);
		for (int i = 0; i < dtoOrder.size(); i++) {
			NDOrdersDto_OKH ordersDto = dtoOrder.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + dateFormat.format(ordersDto.getOrderdate()) + "'");
			row.add(Integer.toString(ordersDto.getCount()));
			dataSetbelow.add(row);
		}
		
		//	SetParam
		request.setAttribute("dataSetup", dataSetup);
		request.setAttribute("dataSetbelow", dataSetbelow);
	}

}
