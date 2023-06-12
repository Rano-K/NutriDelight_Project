package com.javalec.bbs.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.javalec.bbs.dao.NDUserOrdersDao_LYJ;
import com.javalec.bbs.dto.NDUserOrdersDto_LYJ;

public class NDUserOrdersCommand_LYJ implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	

		
		
		HttpSession session = request.getSession();
		String[] pcodes = request.getParameterValues("pcode");
	    String[] counts = request.getParameterValues("count");
		String userid = (String) session.getAttribute("ID");
		
		
		
	     NDUserOrdersDao_LYJ ndUserOrdersDao_LYJ = new NDUserOrdersDao_LYJ();
	        NDUserOrdersDto_LYJ dto1 = ndUserOrdersDao_LYJ.userInfo(userid);

	        ArrayList<NDUserOrdersDto_LYJ> dtos = new ArrayList<>();
	        if (pcodes != null && counts != null && pcodes.length == counts.length) {
	            for (int i = 0; i < pcodes.length; i++) {
	                String pcode = pcodes[i];
	                String count = counts[i];
	                NDUserOrdersDto_LYJ dto = ndUserOrdersDao_LYJ.productInfo(pcode);
	                dto.setCount(count);
	                dtos.add(dto);
	            }
	        }
			
	        session.setAttribute("cartOrders", dtos);
	        request.setAttribute("uInfo", dto1);
	        request.setAttribute("cartOrders", dtos);
		
		
		// ArrayList<NDUserOrdersDto_LYJ> ndUserOrdersDto_LYJs = ndUserOrdersDao_LYJ.orderslist(userid);
		// session.setAttribute("orderslist", ndUserOrdersDto_LYJs);
	
	
		
	}

}
