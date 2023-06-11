package com.javalec.bbs.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javalec.bbs.dao.NDBoardDao_OKH;
import com.javalec.bbs.dao.NDNoticeDao_OKH;
import com.javalec.bbs.dao.NDReviewDao_OKH;

public class NDBoardDeleteCommand_OKH implements NDCommand {

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

			int replySelect = Integer.parseInt(receivedData.get("replySelect"));
			int seq = Integer.parseInt(receivedData.get("replySeq"));

			// DAO
			NDBoardDao_OKH boardDao = new NDBoardDao_OKH();
			NDReviewDao_OKH reviewDao = new NDReviewDao_OKH();
			NDNoticeDao_OKH noticeDao = new NDNoticeDao_OKH();

			if (replySelect == 1) {
				boardDao.deleteBoard(seq);
			} else if (replySelect == 2) {
				reviewDao.deleteBoard(seq);
			} else if (replySelect == 3) {
				noticeDao.deleteBoard(seq);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
