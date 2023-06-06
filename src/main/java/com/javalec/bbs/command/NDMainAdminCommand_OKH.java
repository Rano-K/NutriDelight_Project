package com.javalec.bbs.command;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDOrdersDao_OKH;
import com.javalec.bbs.dao.NDSubscribeDao_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;

public class NDMainAdminCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DecimalFormat formatter = new DecimalFormat("###,###");

		// DAO
		NDOrdersDao_OKH orderDao = new NDOrdersDao_OKH();
		NDSubscribeDao_OKH subscribeDao = new NDSubscribeDao_OKH();

		// DTO
		// 매출액(월간) 가져오기
		String monthSales = formatter.format(orderDao.searchmonthSales());
		//	매출액(연간) 가져오기
		String yearSales = formatter.format(orderDao.searchyearSalessolo());
		//	남은 주문 처리 비율 가져오기
		int count = orderDao.searchordersHowmany();
		int toDo = orderDao.searchtodo();
		String percenttodo = formatter.format(((double)toDo/count)*100);
		//	이번달 구독갯수
		String subscribeSales = formatter.format(subscribeDao.searchsubscribeSalessolo());

		
		// 매출액그래프 가져오기
		ArrayList<NDOrdersDto_OKH> dtoOrders = orderDao.searchyearsales();

		ArrayList<ArrayList<String>> dataSales = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRow = new ArrayList<String>();
		headerRow.add("'월'");
		headerRow.add("'판매액(₩)'");
		dataSales.add(headerRow);
		for (int i = 0; i < dtoOrders.size(); i++) {
			NDOrdersDto_OKH ordersDto = dtoOrders.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + ordersDto.getMonth() + "'");
			row.add(Integer.toString(ordersDto.getTotalsales()));
			dataSales.add(row);
		}
		
		// SetParam
		request.setAttribute("monthSales", monthSales);
		request.setAttribute("yearSales", yearSales);
		request.setAttribute("percenttodo", percenttodo);
		request.setAttribute("subscribeSales", subscribeSales);
		request.setAttribute("ordersSales", Integer.toString(count));
		request.setAttribute("dataSales", dataSales);
	}
}
