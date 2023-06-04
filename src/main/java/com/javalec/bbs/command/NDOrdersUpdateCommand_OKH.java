package com.javalec.bbs.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDManageDao_OKH;
import com.javalec.bbs.dao.NDOrdersDao_OKH;
import com.javalec.bbs.dto.NDManageDto_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;

public class NDOrdersUpdateCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int ordercode = Integer.parseInt(request.getParameter("ordercode"));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String Refunddate = "환불되지 않았습니다.";
		String Deliverydate = "배송되지 않았습니다.";
		//	DAO
		NDOrdersDao_OKH ordersDao = new NDOrdersDao_OKH();
		NDManageDao_OKH manageDao = new NDManageDao_OKH();
		
		//	DTO
		ArrayList<NDOrdersDto_OKH> dtoOrders = ordersDao.searchupdate(ordercode);
		ArrayList<NDManageDto_OKH> dtoManage = manageDao.searchupdate(ordercode);
		
		if (dtoOrders.get(0).getRefunddate() != null) {
			Refunddate = dateFormat.format(dtoOrders.get(0).getRefunddate());
		}
		if (dtoOrders.get(0).getDeliverydate() != null) {
			Deliverydate = dateFormat.format(dtoOrders.get(0).getDeliverydate());
		}
		
		request.setAttribute("dtoOrders", dtoOrders);
		request.setAttribute("Refunddate", Refunddate);
		request.setAttribute("Deliverydate", Deliverydate);
		request.setAttribute("Stock", dtoManage.get(0).getStock());
		
	}

}
