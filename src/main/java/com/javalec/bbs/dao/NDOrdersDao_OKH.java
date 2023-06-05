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
import com.javalec.bbs.dto.NDProductDto_OKH;

public class NDOrdersDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDOrdersDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	//	매출액그래프 가져오기  admin_main.do
	public int[] searchyearorders() {
		int[] data = new int[12];
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT DATE_FORMAT(DATE_ADD(CONCAT(YEAR(CURDATE()), '-01-01'), INTERVAL dates.date - 1 MONTH), '%c월') AS month, "
					+ "       COALESCE(SUM(IFNULL(o.count * m.price, 0)), 0) AS totalsales"
					+ " FROM ( SELECT 1 AS date UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4"
					+ "    UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8"
					+ "    UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 ) dates"
					+ " LEFT JOIN orders o ON MONTH(o.orderdate) = dates.date AND o.refunddate IS NULL"
					+ " LEFT JOIN manage m ON o.pcode = m.pcode\n"
					+ " GROUP BY dates.date"
					+ " ORDER BY dates.date";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int totalsales = resultSet.getInt("totalsales");
				data[resultSet.getInt("month") - 1] = totalsales;
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
		return data;
	}
	
	/*
	 * 여기서 이제, 시작해야한다. 매출액 연간 시작해야한다.
	 */
	
	// 오더관련 모든 정보 불러오기 : searchOrders.do
	public ArrayList<NDOrdersDto_OKH> searchOrders() {
		ArrayList<NDOrdersDto_OKH> dtos = new ArrayList<NDOrdersDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM orders o";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int ordercode = resultSet.getInt("ordercode");
				String userid = resultSet.getString("userid");
				String pcode = resultSet.getString("pcode");
				String address = resultSet.getString("address");
				int count = resultSet.getInt("count");
				Timestamp orderdate = resultSet.getTimestamp("orderdate");
				Timestamp refunddate = resultSet.getTimestamp("refunddate");
				Timestamp deliverydate = resultSet.getTimestamp("deliverydate");
				NDOrdersDto_OKH dto = new NDOrdersDto_OKH(ordercode, userid, pcode, address, count, orderdate,
						refunddate, deliverydate);
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

	// 오더관련 모든 정보 불러오기 : searchOrders.do
	public ArrayList<NDOrdersDto_OKH> searchupdate(int ordercode) {
		ArrayList<NDOrdersDto_OKH> dtos = new ArrayList<NDOrdersDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM orders where ordercode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ordercode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ordercode = resultSet.getInt("ordercode");
				String userid = resultSet.getString("userid");
				String pcode = resultSet.getString("pcode");
				String address = resultSet.getString("address");
				int count = resultSet.getInt("count");
				Timestamp orderdate = resultSet.getTimestamp("orderdate");
				Timestamp refunddate = resultSet.getTimestamp("refunddate");
				Timestamp deliverydate = resultSet.getTimestamp("deliverydate");
				NDOrdersDto_OKH dto = new NDOrdersDto_OKH(ordercode, userid, pcode, address, count, orderdate,
						refunddate, deliverydate);
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

	// 환불 확인 정보 넣기 : admin_updateorders_checked.do
	public void refundupdate(int ordercode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE orders SET refunddate = now() WHERE ordercode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ordercode);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 배송 확인 정보 넣기 : admin_updateorders_checked.do
	public void deliveryupdate(int ordercode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE orders SET deliverydate = now() WHERE ordercode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ordercode);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//	주간 주문 그래프 확인 :  : admin_graphorders.do
	public ArrayList<NDOrdersDto_OKH> searchWeekorders() {
		ArrayList<NDOrdersDto_OKH> dtos = new ArrayList<NDOrdersDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT DATE(dates.date) AS date, IFNULL(COUNT(orders.orderdate), 0) AS ordercount"
					+ " FROM ( "
					+ " SELECT CURDATE() - INTERVAL (a.a + (10 * b.a) + (100 * c.a)) DAY AS date"
					+ " FROM (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS a"
					+ " CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS b"
					+ " CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS c"
					+ " ) AS dates"
					+ " LEFT JOIN orders ON DATE(dates.date) = DATE(orderdate)"
					+ " WHERE dates.date >= CURDATE() - INTERVAL 1 WEEK"
					+ " AND  orders.refunddate IS NULL"
					+ " GROUP BY dates.date"
					+ " ORDER BY dates.date ASC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Timestamp orderdate = resultSet.getTimestamp("date");
				int totalorders = resultSet.getInt("ordercount");
				NDOrdersDto_OKH dto = new NDOrdersDto_OKH(orderdate, totalorders);
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
