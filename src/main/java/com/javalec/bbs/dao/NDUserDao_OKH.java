package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDOrdersDto_OKH;
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

	// USER

	// 유저관련 모든 정보 불러오기 : admin_searchusers.do
	public ArrayList<NDUserDto_OKH> searchUser() {
		ArrayList<NDUserDto_OKH> dtos = new ArrayList<NDUserDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT u.*, IFNULL(SUM(m.price), 0) AS totalbuying" + " FROM user u"
					+ " LEFT JOIN orders o ON u.userid = o.userid" + " LEFT JOIN product p ON o.pcode = p.pcode"
					+ " LEFT JOIN manage m ON p.pcode = m.pcode" + " GROUP BY u.userid";
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
				NDUserDto_OKH dto = new NDUserDto_OKH(userid, userpw, name, gender, birthdate, telno, address, email,
						totalbuying, allergy, insertdate, invalidate);
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

	// USER GRAPH

	// 남녀 성비 정보 불러오기 : admin_graphusers.do
	public ArrayList<NDUserDto_OKH> searchGender() {
		ArrayList<NDUserDto_OKH> dtos = new ArrayList<NDUserDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT gender, COUNT(*) AS count FROM user WHERE invalidate = 1 GROUP BY gender" ;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String gender = resultSet.getString("gender");
				int count = resultSet.getInt("count");
				NDUserDto_OKH dto = new NDUserDto_OKH(gender, count);
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

	// 연령대 별 가입자 불러오기 : admin_graphusers.do

	public ArrayList<NDUserDto_OKH> searchAge() {
		ArrayList<NDUserDto_OKH> dtos = new ArrayList<NDUserDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT age_ranges.age_group , IFNULL(COUNT(user.userid), 0) AS count" + " FROM ("
					+ "        SELECT '20대 미만' AS age_group" + "        UNION ALL SELECT '20대'"
					+ "        UNION ALL SELECT '30대'" + "        UNION ALL SELECT '40대'"
					+ "        UNION ALL SELECT '50대'" + "        UNION ALL SELECT '60대 이상'" + "    ) AS age_ranges"
					+ " LEFT JOIN" + "    user ON CASE"
					+ "        WHEN age_ranges.age_group = '20대 미만' THEN TIMESTAMPDIFF(YEAR, user.birthdate, CURDATE()) < 20"
					+ "        WHEN age_ranges.age_group = '20대' THEN TIMESTAMPDIFF(YEAR, user.birthdate, CURDATE()) BETWEEN 20 AND 29"
					+ "        WHEN age_ranges.age_group = '30대' THEN TIMESTAMPDIFF(YEAR, user.birthdate, CURDATE()) BETWEEN 30 AND 39"
					+ "        WHEN age_ranges.age_group = '40대' THEN TIMESTAMPDIFF(YEAR, user.birthdate, CURDATE()) BETWEEN 40 AND 49"
					+ "        WHEN age_ranges.age_group = '50대' THEN TIMESTAMPDIFF(YEAR, user.birthdate, CURDATE()) BETWEEN 50 AND 59"
					+ "        ELSE TIMESTAMPDIFF(YEAR, user.birthdate, CURDATE()) >= 60" + "    END"
					+ " WHERE invalidate = 1"
					+ " GROUP BY age_ranges.age_group"
					+ " ORDER BY FIELD(age_ranges.age_group, '20대 미만', '20대', '30대', '40대', '50대', '60대 이상')";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String age_group = resultSet.getString("age_group");
				int count = resultSet.getInt("count");
				NDUserDto_OKH dto = new NDUserDto_OKH(count, age_group);
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

	// 유저의 가입자 추이 불러오기 : admin_graphusers.do
	public ArrayList<NDUserDto_OKH> searchInsertdate() {
		ArrayList<NDUserDto_OKH> dtos = new ArrayList<NDUserDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT dates.date, COALESCE(counts.count, 0) AS count"
					+ " FROM ("
					+ "  SELECT DATE(DATE_SUB(CURDATE(), INTERVAL (n.num) DAY)) AS date"
					+ "  FROM ("
					+ "    SELECT 0 AS num UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL"
					+ "    SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6"
					+ "  ) AS n"
					+ " ) AS dates"
					+ " LEFT JOIN ("
					+ "  SELECT DATE(insertdate) AS date, COUNT(*) AS count"
					+ "  FROM user"
					+ "  WHERE insertdate >= DATE_SUB(CURDATE(), INTERVAL 1 WEEK)"
					+ "    AND invalidate = 1"
					+ "  GROUP BY DATE(insertdate)"
					+ " ) AS counts ON dates.date = counts.date"
					+ " ORDER BY dates.date";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Timestamp insertdate = resultSet.getTimestamp("dates.date");
				int count = resultSet.getInt("count");
				NDUserDto_OKH dto = new NDUserDto_OKH(insertdate, count);
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
