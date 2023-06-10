package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDNoticeDto_OKH;

public class NDNoticeDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDNoticeDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 공지 데이터 테이블로 가져오기
	public ArrayList<NDNoticeDto_OKH> searchBoard() {
		ArrayList<NDNoticeDto_OKH> dtos = new ArrayList<NDNoticeDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT notice.seq,notice.adminid, notice.insertdate, notice.invalidate,"
					+ " nwrite.title AS title, nwrite.context AS context, nwrite.updatedate AS updatedate"
					+ " FROM notice" + " LEFT JOIN nwrite ON notice.seq = nwrite.seq";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int seq = resultSet.getInt("seq");
				String adminid = resultSet.getString("adminid");
				Timestamp insertdate = resultSet.getTimestamp("insertdate");
				int invalidate = resultSet.getInt("invalidate");
				String title = resultSet.getString("title");
				String context = resultSet.getString("context");
				Timestamp updatedate = resultSet.getTimestamp("updatedate");

				NDNoticeDto_OKH dto = new NDNoticeDto_OKH(seq, adminid, insertdate, invalidate, title, context,
						updatedate);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	}
}
