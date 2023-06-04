package com.javalec.bbs.command;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDOrdersDao_OKH;
import com.javalec.bbs.dao.NDUserDao_OKH;
import com.javalec.bbs.dto.NDManageDto_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;
import com.javalec.bbs.dto.NDUserDto_OKH;

public class NDUserSearchCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		LocalDateTime now =LocalDateTime.now();
		
		// DAO
		NDUserDao_OKH userDao = new NDUserDao_OKH();
		
		//	DTO
		ArrayList<NDUserDto_OKH> dtoUser = userDao.searchUser();
		ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoUser.size(); i++) {
			NDUserDto_OKH userDto = dtoUser.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'"+userDto.getUserid()+"'");
			row.add("'"+userDto.getName()+"'");
			row.add("'"+userDto.getGender()+"'");
//			수정 필요
			row.add("'"+Integer.toString(Period.between(userDto.getBirthdate().toLocalDateTime().toLocalDate(), now.toLocalDate()).getYears())+"세'");
//			
			row.add("'"+userDto.getTelno()+"'");
			row.add("'"+userDto.getAddress()+"'");
			row.add("'"+userDto.getEmail()+"'");
			row.add("'"+String.format("%,d 원",userDto.getTotalbuying())+"'");
			if (userDto.getAllergy() == null) {
				row.add("'알러지가 없습니다.'");
			} else {
				row.add("'"+userDto.getAllergy()+"'");
			}
			row.add("'"+dateFormat.format(userDto.getInsertdate())+"'");
			if (userDto.getInvalidate() == 1) {
				row.add("'회원'");
			} else {
				row.add("'회원 탈퇴 중'"); 
			}
			dataSet.add(row);
		}
		
		request.setAttribute("dataSet", dataSet);
	}

}
