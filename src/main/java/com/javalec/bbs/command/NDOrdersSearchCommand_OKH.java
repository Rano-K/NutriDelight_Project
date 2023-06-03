package com.javalec.bbs.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDOrdersDao_OKH;
import com.javalec.bbs.dao.NDManageDao_OKH;
import com.javalec.bbs.dto.NDManageDto_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;

public class NDOrdersSearchCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// DAO
		NDOrdersDao_OKH ordersDao = new NDOrdersDao_OKH();
		NDManageDao_OKH manageDao = new NDManageDao_OKH();

		// DTO
		ArrayList<NDOrdersDto_OKH> dtoOrders = ordersDao.searchOrders();
		ArrayList<NDManageDto_OKH> dtoManage = manageDao.searchOrders();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoOrders.size(); i++) {
			NDOrdersDto_OKH orderDto = dtoOrders.get(i);
			NDManageDto_OKH manageDto = dtoManage.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'"+Integer.toString(orderDto.getOrdercode())+"'");
			row.add("'"+orderDto.getUserid()+"'");
			row.add("'"+orderDto.getPcode()+"'");
			row.add("'"+orderDto.getAddress()+"'");
			row.add("'"+Integer.toString(orderDto.getCount())+"'");
			row.add("'"+Integer.toString(manageDto.getStock())+"'");
			row.add("'"+dateFormat.format(orderDto.getOrderdate())+"'");
			if (orderDto.getRefunddate() != null) {
				row.add("'"+dateFormat.format(orderDto.getRefunddate())+"'");
			} else {
				row.add("'환불되지 않았습니다.'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.				
			}
			if (orderDto.getDeliverydate() != null) {
				row.add("'"+dateFormat.format(orderDto.getDeliverydate())+"'");
			} else {
				row.add("'배송되지 않았습니다.'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.
			}
			dataSet.add(row);
		}

		request.setAttribute("dataSet", dataSet);
	}

}
