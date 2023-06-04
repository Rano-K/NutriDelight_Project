package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDUserDto_OKH;

public class NDUserDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDUserDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 오더관련 모든 정보 불러오기 : searchOrders.do
	public ArrayList<NDUserDto_OKH> searchUser() {
		ArrayList<NDUserDto_OKH> dtos = new ArrayList<NDUserDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT u.*, IFNULL(SUM(m.price), 0) AS totalbuying"
					+ " FROM user u"
					+ " LEFT JOIN orders o ON u.userid = o.userid"
					+ " LEFT JOIN product p ON o.pcode = p.pcode"
					+ " LEFT JOIN manage m ON p.pcode = m.pcode"
					+ " GROUP BY u.userid";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String userid = resultSet.getString("userid");
				String userpw = resultSet.getString("userpw");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				Timestamp birthdate = resultSet.getTimestamp("birthdate");
				String telno = resultSet.getString("telno");
				String address = resultSet.getString("address");
				String email = resultSet.getString("email");
				String allergy = resultSet.getString("allergy");
				Timestamp insertdate = resultSet.getTimestamp("insertdate");
				int invalidate = resultSet.getInt("invalidate");
				int totalbuying = resultSet.getInt("totalbuying");
				NDUserDto_OKH dto = new NDUserDto_OKH(userid, userpw, name, gender, birthdate, telno, address, email, totalbuying, allergy, insertdate, invalidate);
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
