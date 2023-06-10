package com.javalec.bbs.command;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDPlanDao_OKH;
import com.javalec.bbs.dao.NDSubscribeDao_OKH;
import com.javalec.bbs.dto.NDPlanDto_OKH;
import com.javalec.bbs.dto.NDSubscribeDto_OKH;

public class NDSubscribeSearchCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			// TODO Auto-generated method stub
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// DAO
			NDSubscribeDao_OKH subscribeDao = new NDSubscribeDao_OKH();
			NDPlanDao_OKH planDao = new NDPlanDao_OKH();

			// DTO
			ArrayList<NDSubscribeDto_OKH> dtoSubscribe = subscribeDao.searchSubscribe();
			ArrayList<NDPlanDto_OKH> dtoPlanDeliverydate = planDao.searchSubscribeDeliverydate();
			ArrayList<NDPlanDto_OKH> dtoShippingTmw = planDao.searchSubscribeShippingTmw();

			ArrayList<ArrayList<String>> dataSetSubscribe = new ArrayList<ArrayList<String>>();

			for (int i = 0; i < dtoSubscribe.size(); i++) {
				NDSubscribeDto_OKH Subscribedto = dtoSubscribe.get(i);
				NDPlanDto_OKH PlanDeliverydatedto = dtoPlanDeliverydate.get(i);
				NDPlanDto_OKH ShippingTmwdto = dtoShippingTmw.get(i);
				ArrayList<String> row = new ArrayList<String>();

				row.add("'" + Integer.toString(Subscribedto.getScode()) + "'");
				row.add("'" + Subscribedto.getUserid() + "'");
				row.add("'" + dateFormat.format(Subscribedto.getSubscribedate()) + "'");
				row.add("'" + AddDate(dateFormat.format(Subscribedto.getSubscribedate()), 0, 1, 0) + "'");
				row.add("' 일정 보기 '");
				if (PlanDeliverydatedto.getDeliverydate() == null) {
					row.add("'배송 기록 X'");
				} else {
					row.add("'" + dateFormat.format(PlanDeliverydatedto.getDeliverydate()) + "'");
				}
				if (ShippingTmwdto.getName().equals("NULL")) {
					row.add("'배송 품목 X'");
				} else {
					row.add("'" + ShippingTmwdto.getName() + "'");
				}
				row.add("'" + Integer.toString(PlanDeliverydatedto.getPlcode()) + "'");

				dataSetSubscribe.add(row);
			}
			request.setAttribute("dataSetSubscribe", dataSetSubscribe);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String AddDate(String strDate, int year, int month, int day) throws Exception {

		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();

		Date dt = dtFormat.parse(strDate);

		cal.setTime(dt);

		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DATE, day);

		return dtFormat.format(cal.getTime());
	}

}
