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
		
		String pcode = request.getParameter("pcode");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String photo = request.getParameter("photo");
				
		String productList="";
		NDProductListDao_KMS dao_KMS = new NDProductListDao_KMS();
		ArrayList<NDProductListDto_KMS> productListDto = dao_KMS.TakeAll(pcode, name, price, photo);
		// productListDto 리스트에 있는 각 항목을 가져와서 productList 문자열에 추가
		for (int n = 0; n < productListDto.size(); n++) {
		    NDProductListDto_KMS dto = productListDto.get(n);
		    productList += dto.getPcode() + ", " + dto.getName() + ", " 
		    + dto.getPrice() + ", " + dto.getPhoto() + "\n";
		    
		}

		System.out.println(productList);
		
		

    
}
	
	
	
	
	
	
	
	
	
}
