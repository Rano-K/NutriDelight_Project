package com.javalec.bbs.command;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NDLogoutCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			String requestURL = "https://kapi.kakao.com/v1/user/logout";
			
			if(session.getAttribute("social") != null) {
				String accessToken = (String)session.getAttribute("social");
				URL url = new URL(requestURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				String headers = "Authorization=Bearer " + accessToken;
				bufferedWriter.write(headers);
				bufferedWriter.flush();
				
				int responseCode = conn.getResponseCode();
				System.out.println("responseCode : " + responseCode);
				
				if(responseCode == 200) {
					bufferedWriter.close();
					System.out.println("Kakao session invalidate..");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		session.invalidate();
	}

}
