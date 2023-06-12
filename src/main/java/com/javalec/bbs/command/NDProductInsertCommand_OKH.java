package com.javalec.bbs.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDManageDao_OKH;
import com.javalec.bbs.dao.NDProductDao_OKH;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NDProductInsertCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			// Fields
			
			String directory = request.getServletContext().getRealPath("/img");
			String directorysub = "img/";
			int maxSize = 1024 * 1024 * 100;
			String encoding = "UTF-8";
			MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String fileName = multipartRequest.getOriginalFileName("photo");
			String fileRealName = multipartRequest.getFilesystemName("photo");

			String pcode = multipartRequest.getParameter("pcode");
			System.out.println("pcode" + pcode);
			String adminid = (String) request.getSession().getAttribute("ID");
			String name = multipartRequest.getParameter("name");
			String category = multipartRequest.getParameter("category");
			String rice = multipartRequest.getParameter("rice");
			if(rice.equals("")) {
				rice = null;
			}
			String cook1 = multipartRequest.getParameter("cook1");
			if(cook1.equals("")) {
				cook1 = null;
			}
			String cook2 = multipartRequest.getParameter("cook2");
			if(cook2.equals("")) {
				cook2 = null;
			}
			String cook3 = multipartRequest.getParameter("cook3");
			if(cook3.equals("")) {
				cook3 = null;
			}
			String soup = multipartRequest.getParameter("soup");
			if(soup.equals("")) {
				soup = null;
			}

			int stock = Integer.parseInt(multipartRequest.getParameter("stock"));
			int price = Integer.parseInt(multipartRequest.getParameter("price"));
			int calories = Integer.parseInt(multipartRequest.getParameter("calories"));

			String filePath = directorysub + fileRealName; // 파일 경로 생성
			// DAO
			NDProductDao_OKH productDao = new NDProductDao_OKH();
			NDManageDao_OKH manageDao = new NDManageDao_OKH();
			if (pcode.equals("입력을 누르시면 자동 완성됩니다.")) {
				productDao.insertProduct(name, category, rice, cook1, cook2, cook3, soup, filePath,calories);
				manageDao.insertProduct(adminid, stock, price);
			} else {
				productDao.updateProduct(pcode, name, category, rice, cook1, cook2, cook3, soup, filePath,calories);
				manageDao.updateProduct(adminid, pcode, stock, price);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
