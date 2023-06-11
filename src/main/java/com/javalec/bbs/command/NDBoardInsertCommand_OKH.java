package com.javalec.bbs.command;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import com.javalec.bbs.dao.NDBoardDao_OKH;
import com.javalec.bbs.dao.NDNoticeDao_OKH;
import com.javalec.bbs.dao.NDReviewDao_OKH;

public class NDBoardInsertCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			// Fields
			HttpSession session = request.getSession();

			BufferedReader reader = request.getReader();
			StringBuilder jsonInput = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				jsonInput.append(line);
			}

			String jsonString = jsonInput.toString();

			// JSON 문자열을 Java 객체로 변환
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>() {
			}.getType();
			Map<String, String> receivedData = gson.fromJson(jsonString, type);

			String adminid = (String) session.getAttribute("ID");
			int replySelect = Integer.parseInt(receivedData.get("replySelect"));
			int parent = Integer.parseInt(receivedData.get("replyParent"));
			int layer = Integer.parseInt(receivedData.get("replyLayer"));
			String pcode = receivedData.get("replyPcode");
			String title = receivedData.get("replyTitle");
			String content = receivedData.get("replyContent");

			// DAO
			NDBoardDao_OKH boardDao = new NDBoardDao_OKH();
			int newseqboard = boardDao.searchBoardseq();
			System.out.println("newseqboard"+newseqboard);
			NDReviewDao_OKH reviewDao = new NDReviewDao_OKH();
			int newseqreview = reviewDao.searchBoardseq();
			System.out.println("newseqreview"+newseqreview);
			NDNoticeDao_OKH noticeDao = new NDNoticeDao_OKH();
			int newseqnotice = noticeDao.searchBoardseq();
			System.out.println("newseqnotice"+newseqnotice);
			if (replySelect == 1) {
				boardDao.insertBoard(newseqboard, parent, layer, pcode, adminid, title, content);
			} else if (replySelect == 2) {
				reviewDao.insertBoard(newseqreview, parent, layer, pcode, adminid, content);
			} else if (replySelect == 3) {
				noticeDao.insertBoard(newseqnotice, adminid, title, content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
