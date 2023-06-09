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
			String directory = request.getServletContext().getRealPath("/admin/img");
			String directorysub = "admin/img/";
			int maxSize = 1024 * 1024 * 100;
			String encoding = "UTF-8";
			MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String fileName = multipartRequest.getOriginalFileName("photo");
			String fileRealName = multipartRequest.getFilesystemName("photo");

			String pcode = multipartRequest.getParameter("pcode");
			String adminid = (String) request.getSession().getAttribute("ID");
			String name = multipartRequest.getParameter("name");
			String category = multipartRequest.getParameter("category");
			String rice = multipartRequest.getParameter("rice");
			String cook1 = multipartRequest.getParameter("cook1");
			String cook2 = multipartRequest.getParameter("cook2");
			String cook3 = multipartRequest.getParameter("cook3");
			String soup = multipartRequest.getParameter("soup");

			int stock = Integer.parseInt(multipartRequest.getParameter("stock"));
			int price = Integer.parseInt(multipartRequest.getParameter("price"));

			String filePath = directorysub + fileRealName; // 파일 경로 생성
			// DAO
			NDProductDao_OKH productDao = new NDProductDao_OKH();
			NDManageDao_OKH manageDao = new NDManageDao_OKH();
			if (pcode != null) {
				productDao.updateProduct(pcode, name, category, rice, cook1, cook2, cook3, soup, filePath);
				manageDao.updateProduct(adminid, pcode, stock, price);
			} else {
				productDao.insertProduct(name, category, rice, cook1, cook2, cook3, soup, filePath);
				manageDao.insertProduct(adminid, stock, price);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
