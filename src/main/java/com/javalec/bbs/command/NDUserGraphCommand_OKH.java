package com.javalec.bbs.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserDao_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;
import com.javalec.bbs.dto.NDProductDto_OKH;
import com.javalec.bbs.dto.NDUserDto_OKH;

public class NDUserGraphCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//	DAO
		NDUserDao_OKH userDao = new NDUserDao_OKH();
		
		//	DTO
		//	SearchGender
		ArrayList<NDUserDto_OKH> dtoUserGender = userDao.searchGender();
		ArrayList<ArrayList<String>> dataSetGender = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowGender = new ArrayList<String>();
		headerRowGender.add("'성별', '유저수'");
		dataSetGender.add(headerRowGender);
		for (int i = 0; i < dtoUserGender.size(); i++) {
			NDUserDto_OKH userDto = dtoUserGender.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + userDto.getGender() + "'");
			row.add(Integer.toString(userDto.getCount()));
			dataSetGender.add(row);
		}
		
		//	SearchAgegroup
		ArrayList<NDUserDto_OKH> dtoUserAge = userDao.searchAge();
		ArrayList<ArrayList<String>> dataSetAge = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowAge = new ArrayList<String>();
		headerRowAge.add("'연령대'");
		headerRowAge.add("'유저수'");
		dataSetAge.add(headerRowAge);
		for (int i = 0; i < dtoUserAge.size(); i++) {
			NDUserDto_OKH userDto = dtoUserAge.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + userDto.getAge_group() + "'");
			row.add(Integer.toString(userDto.getCount()));
			dataSetAge.add(row);
		}
		
		//	SearchUserInsertdate
		ArrayList<NDUserDto_OKH> dtoUserInsert = userDao.searchInsertdate();
		ArrayList<ArrayList<String>> dataSetInsert = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowInsert = new ArrayList<String>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd (E)");
		
		headerRowInsert.add("'날짜'");
		headerRowInsert.add("'유저수'");
		dataSetInsert.add(headerRowInsert );
		for (int i = 0; i < dtoUserInsert.size(); i++) {
			NDUserDto_OKH userDto = dtoUserInsert.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + dateFormat.format(userDto.getInsertdate()) + "'");
			row.add(Integer.toString(userDto.getCount()));
			dataSetInsert.add(row);
		}
		
		//	SetParam
		request.setAttribute("dataSetGender", dataSetGender);
		request.setAttribute("dataSetAge", dataSetAge);
		request.setAttribute("dataSetInsert", dataSetInsert);
	}

}
