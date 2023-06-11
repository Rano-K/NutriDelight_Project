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

	// 글 작성하기
	public void insertBoard(int seq, String adminid, String title, String context) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String insertBoardQuery = "INSERT INTO notice (seq, adminid, insertdate, invalidate)"
					+ " VALUES (?, ?, now(), 1)";
			String insertBReplyQuery = "INSERT INTO nwrite (seq, adminid, title, context, updatedate) "
					+ " VALUES (?, ?, ?, ?, now())";
			PreparedStatement boardStatement = connection.prepareStatement(insertBoardQuery);
			PreparedStatement bReplyStatement = connection.prepareStatement(insertBReplyQuery);

			boardStatement.setInt(1, seq+1);
			boardStatement.setString(2, adminid);

			bReplyStatement.setInt(1, seq+1);
			bReplyStatement.setString(2, adminid);
			bReplyStatement.setString(3, title);
			bReplyStatement.setString(4, context);
			boardStatement.executeUpdate();
			bReplyStatement.executeUpdate();

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
	}

	// seq값 가져오기
	public int searchBoardseq() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int newseq = 0;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT MAX(seq) AS seq FROM notice";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				newseq = resultSet.getInt("seq") + 1;
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

		return newseq;
	}

	// 수정하기
	public void modifyBoard(int seq, String adminid, String title, String context) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE nwrite SET title = ?, adminid = ?, context = ?, updatedate = now() WHERE seq = ?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, title);
			preparedStatement.setString(2, adminid);
			preparedStatement.setString(3, context);
			preparedStatement.setInt(4, seq);
			preparedStatement.executeUpdate();

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
	}

	// 삭제하기
	public void deleteBoard(int seq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE notice SET invalidate = 0 WHERE seq = ?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, seq);
			preparedStatement.executeUpdate();

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
	}
}
