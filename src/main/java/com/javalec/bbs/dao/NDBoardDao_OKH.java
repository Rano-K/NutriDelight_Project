package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDBoardDto_OKH;

public class NDBoardDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDBoardDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	public ArrayList<NDBoardDto_OKH> searchBoard() {
		ArrayList<NDBoardDto_OKH> dtos = new ArrayList<NDBoardDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT board.seq AS seq, board.parent AS parent, board.layer AS layer, board.userid AS userid, board.pcode AS pcode, board.adminid AS adminid, board.insertdate AS insertdate, board.invalidate AS invalidate, "
					+ " bwrite.title AS bwtitle, bwrite.context AS bwcontext, bwrite.image AS bwimage, bwrite.updatedate AS bwupdatedate, "
					+ " breply.title AS brtitle, breply.context AS brcontext, breply.updatedate AS brupdatedate "
					+ " FROM board " + " LEFT JOIN bwrite ON board.seq = bwrite.seq "
					+ " LEFT JOIN breply ON board.seq = breply.seq " + " ORDER BY parent";
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
				String bwtitle = resultSet.getString("bwtitle");
				String bwcontext = resultSet.getString("bwcontext");
				String bwimage = resultSet.getString("bwimage");
				Timestamp bwupdatedate = resultSet.getTimestamp("bwupdatedate");
				String brtitle = resultSet.getString("brtitle");
				String brcontext = resultSet.getString("brcontext");
				Timestamp brupdatedate = resultSet.getTimestamp("brupdatedate");
				System.out.println(brupdatedate);

				NDBoardDto_OKH dto = new NDBoardDto_OKH(seq, parent, layer, userid, pcode, adminid, insertdate,
						invalidate, bwtitle, bwcontext, bwimage, bwupdatedate, brtitle, brcontext, brupdatedate);
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
	public void insertBoard(int seq, int parent, int layer, String pcode, String adminid, String title,
			String context) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String insertBoardQuery = "INSERT INTO board (seq, parent, layer, userid, pcode, adminid, insertdate, invalidate)"
					+ " VALUES (?, ?, ?, NULL, ?, ?, now(), 1)";
			String insertBReplyQuery = "INSERT INTO breply (seq, adminid, title, context, updatedate) "
					+ " VALUES (?, ?, ?, ?, now())";
			PreparedStatement boardStatement = connection.prepareStatement(insertBoardQuery);
			PreparedStatement bReplyStatement = connection.prepareStatement(insertBReplyQuery);

			boardStatement.setInt(1, seq);
			boardStatement.setInt(2, parent);
			boardStatement.setInt(3, (layer + 1));
			boardStatement.setString(4, pcode);
			boardStatement.setString(5, adminid);

			bReplyStatement.setInt(1, seq);
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
			String query = "SELECT MAX(seq) AS seq FROM board";
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
			String query = "UPDATE breply SET title = ?, adminid = ?,context = ?, updatedate = now() WHERE seq = ?";

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
	
	//	삭제하기
	public void deleteBoard(int seq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE board SET invalidate = 0 WHERE seq = ?";

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
