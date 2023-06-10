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
	//	리뷰 데이터 테이블로 가져오기
	public ArrayList<NDReviewDto_OKH> searchBoard(){
		ArrayList<NDReviewDto_OKH> dtos = new ArrayList<NDReviewDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT review.seq AS seq, review.parent AS parent, review.layer AS layer, review.userid AS userid, review.pcode AS pcode, review.adminid AS adminid, review.insertdate AS insertdate, review.invalidate AS invalidate,"
					+ " rwrite.context AS rwcontext, rwrite.image AS rwimage, rwrite.updatedate AS rwupdatedate,"
					+ " rreply.context AS rrcontext, rreply.updatedate AS rrupdatedate"
					+ " FROM review"
					+ " LEFT JOIN rwrite ON review.seq = rwrite.seq"
					+ " LEFT JOIN rreply ON review.seq = rreply.seq"
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

			    NDReviewDto_OKH dto = new NDReviewDto_OKH(seq, parent, layer, userid, pcode, adminid, insertdate, invalidate,
			    		rwcontext, rwimage, rwupdatedate, rrcontext, rrupdatedate);
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
