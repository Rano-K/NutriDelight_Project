package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class NDSubscribeDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDSubscribeDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	//	이번달 구독갯수 admin_main.do
	public int searchsubscribeSalessolo() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int subscribeSales = 0;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT SUM(s.scode) AS subscribeSales"
					+ " FROM subscribe s"
					+ " WHERE YEAR(s.subscribedate) = YEAR(CURRENT_DATE())"
					+ " AND MONTH(s.subscribedate) = MONTH(CURRENT_DATE())";

			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				subscribeSales = resultSet.getInt("subscribeSales");
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

		return subscribeSales;
	}
}