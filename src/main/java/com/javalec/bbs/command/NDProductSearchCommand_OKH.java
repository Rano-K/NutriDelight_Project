package com.javalec.bbs.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDManageDao_OKH;
import com.javalec.bbs.dao.NDProductDao_OKH;
import com.javalec.bbs.dto.NDManageDto_OKH;
import com.javalec.bbs.dto.NDProductDto_OKH;

public class NDProductSearchCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// DAO
		NDProductDao_OKH productDao = new NDProductDao_OKH();
		NDManageDao_OKH manageDao = new NDManageDao_OKH();

		// DTO
		ArrayList<NDProductDto_OKH> dtoproduct = productDao.searchProduct();
		ArrayList<NDManageDto_OKH> dtoManage = manageDao.searchProduct();

		ArrayList<ArrayList<String>> dataSetProduct = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoproduct.size(); i++) {
			NDProductDto_OKH productDto = dtoproduct.get(i);
			NDManageDto_OKH manageDto = dtoManage.get(i);
			ArrayList<String> row = new ArrayList<String>();
			
			
			
			row.add("'" + productDto.getPcode() + "'");
			row.add("'" + productDto.getName() + "'");
			row.add("'" + productDto.getCategory() + "'");
			row.add("'" + productDto.getRice() + "'");
			if (productDto.getCook1() != null) {
				row.add("'" + productDto.getCook1() + "'");
			} else {
				row.add("'해당사항없음'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.				
			}
			if (productDto.getCook2() != null) {
				row.add("'" + productDto.getCook2() + "'");
			} else {
				row.add("'해당사항없음'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.				
			}
			if (productDto.getCook3() != null) {
				row.add("'" + productDto.getCook3() + "'");
			} else {
				row.add("'해당사항없음'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.				
			}
			if (productDto.getSoup() != null) {
				row.add("'" + productDto.getSoup() + "'");
			} else {
				row.add("'해당사항없음'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.				
			}
			row.add("'" + Integer.toString(manageDto.getStock()) + "세트'");
			row.add("'" + String.format("%,d 원",manageDto.getPrice()) + "'");
			row.add("'" + dateFormat.format(productDto.getInsertdate()) + "'");
			row.add("'" + dateFormat.format(manageDto.getUpdatedate()) + "'");
			if (manageDto.getInvalidate() != 0) {
				row.add("'판매 상품'");
			} else {
				row.add("'비판매 상품'"); 
			}
			dataSetProduct.add(row);
		}

		request.setAttribute("dataSetProduct", dataSetProduct);
	}

}
