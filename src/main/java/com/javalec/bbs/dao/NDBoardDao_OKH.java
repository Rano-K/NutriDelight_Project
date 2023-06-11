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
	public ArrayList<NDBoardDto_OKH> searchBoard(){
		ArrayList<NDBoardDto_OKH> dtos = new ArrayList<NDBoardDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT board.seq AS seq, board.parent AS parent, board.layer AS layer, board.userid AS userid, board.pcode AS pcode, board.adminid AS adminid, board.insertdate AS insertdate, board.invalidate AS invalidate, "
					+ " bwrite.title AS bwtitle, bwrite.context AS bwcontext, bwrite.image AS bwimage, bwrite.updatedate AS bwupdatedate, "
					+ " breply.title AS brtitle, breply.context AS brcontext, breply.updatedate AS brupdatedate "
					+ " FROM board "
					+ " LEFT JOIN bwrite ON board.seq = bwrite.seq "
					+ " LEFT JOIN breply ON board.seq = breply.seq "
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
			    String bwtitle = resultSet.getString("bwtitle");
			    String bwcontext = resultSet.getString("bwcontext");
			    String bwimage = resultSet.getString("bwimage");
			    Timestamp bwupdatedate = resultSet.getTimestamp("bwupdatedate");
			    String brtitle = resultSet.getString("brtitle");
			    String brcontext = resultSet.getString("brcontext");
			    Timestamp brupdatedate = resultSet.getTimestamp("brupdatedate");
			    System.out.println(brupdatedate);

			    NDBoardDto_OKH dto = new NDBoardDto_OKH(seq, parent, layer, userid, pcode, adminid, insertdate, invalidate,
			            bwtitle, bwcontext, bwimage, bwupdatedate, brtitle, brcontext, brupdatedate);
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
