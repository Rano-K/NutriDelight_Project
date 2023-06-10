package com.javalec.bbs.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDSubscribeDao_OKH;
import com.javalec.bbs.dto.NDSubscribeDto_OKH;

public class NDSubscribeScheduleCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// DAO
		NDSubscribeDao_OKH subscribeDao = new NDSubscribeDao_OKH();

		// DTO
		ArrayList<NDSubscribeDto_OKH> dtoSubscribe = subscribeDao.scheduleSubscribe();

		ArrayList<String> dataSetSubscribe = new ArrayList<String>();

		for (NDSubscribeDto_OKH dto : dtoSubscribe) {
			String deliverycolor;
			if (dto.getDelivery() == 1) {
				deliverycolor = "#000000";
			} else {
				deliverycolor = "#7FAD39";
			}

			String event = "{ \"title\": \"" + dto.getUserid() + "(" + dto.getUname() + ")의 구독\", " +
			        "\"start\": \"" + dateFormat.format(dto.getPlandate()) + "\", " +
			        "\"allday\": true, " +
			        "\"backgroundColor\": \"" + deliverycolor + "\", " +
			        "\"extendedProps\": { " +
			        "\"uname\": \"" + dto.getUname() + "\", " +
			        "\"scode\": \"" + dto.getScode() + "\", " +
			        "\"pname\": \"" + dto.getPname() + "\", " +
			        "\"address\": \"" + dto.getAddress() + "\", " +
			        "\"plcode\": \"" + dto.getPlcode() + "\" " +
			        "}}";


			dataSetSubscribe.add(event);
		}

		request.setAttribute("dataSetSubscribe", dataSetSubscribe);

	}

}
