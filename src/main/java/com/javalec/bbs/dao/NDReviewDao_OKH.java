package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDReviewDto_OKH;

public class NDReviewDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDReviewDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	// 리뷰 데이터 테이블로 가져오기
	public ArrayList<NDReviewDto_OKH> searchBoard() {
		ArrayList<NDReviewDto_OKH> dtos = new ArrayList<NDReviewDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT review.seq AS seq, review.parent AS parent, review.layer AS layer, review.userid AS userid, review.pcode AS pcode, review.adminid AS adminid, review.insertdate AS insertdate, review.invalidate AS invalidate,"
					+ " rwrite.context AS rwcontext, rwrite.image AS rwimage, rwrite.updatedate AS rwupdatedate,"
					+ " rreply.context AS rrcontext, rreply.updatedate AS rrupdatedate" + " FROM review"
					+ " LEFT JOIN rwrite ON review.seq = rwrite.seq" + " LEFT JOIN rreply ON review.seq = rreply.seq"
					+ " ORDER BY parent";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int seq = resultSet.getInt("seq");
				int parent = resultSet.getInt("parent");
				int layer = resultSet.getInt("layer");
				String userid = resultSet.getString("userid");
				String pcode = resultSet.getString("pcode");
				String adminid = resultSet.getString("adminid");
				Timestamp insertdate = resultSet.getTimestamp("insertdate");
				int invalidate = resultSet.getInt("invalidate");
				String rwcontext = resultSet.getString("rwcontext");
				String rwimage = resultSet.getString("rwimage");
				Timestamp rwupdatedate = resultSet.getTimestamp("rwupdatedate");
				String rrcontext = resultSet.getString("rrcontext");
				Timestamp rrupdatedate = resultSet.getTimestamp("rrupdatedate");

				NDReviewDto_OKH dto = new NDReviewDto_OKH(seq, parent, layer, userid, pcode, adminid, insertdate,
						invalidate, rwcontext, rwimage, rwupdatedate, rrcontext, rrupdatedate);
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

	// 답글 작성하기
	public void insertBoard(int seq, int parent, int layer, String pcode, String adminid, String context) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String insertBoardQuery = "INSERT INTO review (seq, parent, layer, userid, pcode, adminid, insertdate, invalidate)"
					+ " VALUES (?, ?, ?, NULL, ?, ?, now(), 1)";
			String insertBReplyQuery = "INSERT INTO rreply (seq, adminid, context, updatedate) "
					+ " VALUES (?, ?, ?, now())";
			PreparedStatement boardStatement = connection.prepareStatement(insertBoardQuery);
			PreparedStatement bReplyStatement = connection.prepareStatement(insertBReplyQuery);

			boardStatement.setInt(1, seq);
			boardStatement.setInt(2, parent);
			boardStatement.setInt(3, (layer + 1));
			boardStatement.setString(5, pcode);
			boardStatement.setString(6, adminid);

			bReplyStatement.setInt(1, seq);
			bReplyStatement.setString(2, adminid);
			bReplyStatement.setString(3, context);
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
			String query = "SELECT MAX(seq) AS seq FROM review";
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
	public void modifyBoard(int seq, String adminid, String context) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE rreply SET context = ?, adminid =?, updatedate = now() WHERE seq = ?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, context);
			preparedStatement.setString(2, adminid);
			preparedStatement.setInt(3, seq);
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
			String query = "UPDATE review SET invalidate = 0 WHERE seq = ?";

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
