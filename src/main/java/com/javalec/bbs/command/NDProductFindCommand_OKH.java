package com.javalec.bbs.command;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDManageDao_OKH;
import com.javalec.bbs.dao.NDProductDao_OKH;
import com.javalec.bbs.dto.NDManageDto_OKH;
import com.javalec.bbs.dto.NDProductDto_OKH;

public class NDProductFindCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// Fields
		String pcode = request.getParameter("pcode");

		// DAO
		NDProductDao_OKH productDao = new NDProductDao_OKH();
		NDManageDao_OKH manageDao = new NDManageDao_OKH();

		// DTO
		ArrayList<NDProductDto_OKH> dtoProduct = productDao.findProduct(pcode);
		ArrayList<NDManageDto_OKH> dtoManage = manageDao.findProduct(pcode);

		Timestamp insertdate = dtoProduct.get(0).getInsertdate();
		Timestamp updatedate = dtoManage.get(0).getUpdatedate();
		
		String photo = dtoProduct.get(0).getPhoto();
		photo.substring(4);
		System.out.println("photo"+photo);

		String conditionInsert = "";
		if (insertdate == null) {
			conditionInsert = "입력을 누르시면 자동 완성됩니다.";
		} else {
			conditionInsert = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(insertdate);
		}

		String conditionUpdate = "";
		if (updatedate == null) {
			conditionUpdate = "수정을 누르시면 자동 완성됩니다.";
		} else {
			conditionUpdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(updatedate);
		}

		request.setAttribute("pcode", pcode);
		request.setAttribute("name", dtoProduct.get(0).getName());
		request.setAttribute("category", dtoProduct.get(0).getCategory());
		request.setAttribute("rice", dtoProduct.get(0).getRice());
		request.setAttribute("cook1", dtoProduct.get(0).getCook1());
		request.setAttribute("cook2", dtoProduct.get(0).getCook2());
		request.setAttribute("cook3", dtoProduct.get(0).getCook3());
		request.setAttribute("soup", dtoProduct.get(0).getSoup());
		request.setAttribute("photo", dtoProduct.get(0).getPhoto());
		request.setAttribute("stock", dtoManage.get(0).getStock());
		request.setAttribute("price", dtoManage.get(0).getPrice());
		request.setAttribute("calories", dtoProduct.get(0).getCalories());
		request.setAttribute("insertdate", conditionInsert);
		request.setAttribute("updatedate", conditionUpdate);
		request.setAttribute("invalidate", dtoManage.get(0).getInvalidate());

	}

}
