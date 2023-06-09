package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDOrdersDto_OKH;

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
	// 매출액(월간) 가져오기 admin_main.do
	public int searchmonthSales() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int monthSales = 0;

		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT SUM(o.count*m.price) AS monthSales" + " FROM orders o"
					+ " JOIN manage m ON o.pcode = m.pcode" + " WHERE YEAR(o.orderdate) = YEAR(CURRENT_DATE())"
					+ " AND MONTH(o.orderdate) = MONTH(CURRENT_DATE())" + " AND o.refunddate IS NULL";

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				monthSales = resultSet.getInt("monthSales");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return monthSales;
	}

	// 매출액(연간) 가져오기 admin_main.do
	public int searchyearSalessolo() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int yearSales = 0;

		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT SUM(o.count*m.price) AS yearSales" + " FROM orders o"
					+ " JOIN manage m ON o.pcode = m.pcode" + " WHERE YEAR(o.orderdate) = YEAR(CURRENT_DATE())"
					+ " AND o.refunddate IS NULL";

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				yearSales = resultSet.getInt("yearSales");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return yearSales;
	}

	// 전체 오더갯수 가져오기 admin_main.do
	public int searchordersHowmany() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int count = 0;

		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT COUNT(ordercode) AS count FROM orders o"
					+" WHERE YEAR(o.orderdate) = YEAR(CURRENT_DATE())"
					+" AND MONTH(o.orderdate) = MONTH(CURRENT_DATE())"
					+" AND refunddate IS NULL";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return count;
	}
	
	

	// 할일 갯수 가져오기 admin_main.do
	public int searchtodo() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int toDo = 0;

		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT COUNT(ordercode) AS toDo" + " FROM orders" + " WHERE refunddate IS NOT NULL"
					+ " AND deliverydate IS NULL;";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				toDo = resultSet.getInt("todo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return toDo;
	}
	
	

	// 매출액그래프 가져오기 admin_main.do
	public ArrayList<NDOrdersDto_OKH> searchyearsales() {
		ArrayList<NDOrdersDto_OKH> dtos = new ArrayList<NDOrdersDto_OKH>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT DATE_FORMAT(DATE_ADD(CONCAT(YEAR(CURDATE()), '-01-01'), INTERVAL dates.date - 1 MONTH), '%c월') AS month, "
					+ " COALESCE(SUM(IFNULL(o.count * m.price, 0)), 0) AS totalsales"
					+ " FROM ( SELECT 1 AS date UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4"
					+ " UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8"
					+ " UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 ) dates"
					+ " LEFT JOIN orders o ON MONTH(o.orderdate) = dates.date AND o.refunddate IS NULL"
					+ " LEFT JOIN manage m ON o.pcode = m.pcode GROUP BY dates.date ORDER BY dates.date";

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String month = resultSet.getString("month");
				int totalsales = resultSet.getInt("totalsales");
				NDOrdersDto_OKH dto = new NDOrdersDto_OKH(month, totalsales);
				dtos.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	}
	

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

	// 하나의 오더코드관련 모든 정보 불러오기 : searchOrders.do
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

	// 주간 주문 그래프 확인 : : admin_graphorders.do
	public ArrayList<NDOrdersDto_OKH> searchWeekorders() {
		ArrayList<NDOrdersDto_OKH> dtos = new ArrayList<NDOrdersDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT DATE(dates.date) AS date, IFNULL(COUNT(orders.orderdate), 0) AS ordercount"
					+ " FROM ( " + " SELECT CURDATE() - INTERVAL (a.a + (10 * b.a) + (100 * c.a)) DAY AS date"
					+ " FROM (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS a"
					+ " CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS b"
					+ " CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS c"
					+ " ) AS dates" + " LEFT JOIN orders ON DATE(dates.date) = DATE(orderdate)"
					+ " WHERE dates.date >= CURDATE() - INTERVAL 1 WEEK" + " AND  orders.refunddate IS NULL"
					+ " GROUP BY dates.date" + " ORDER BY dates.date ASC";
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
