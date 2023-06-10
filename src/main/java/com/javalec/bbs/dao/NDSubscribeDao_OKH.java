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

import com.javalec.bbs.dto.NDSubscribeDto_OKH;

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
	// 이번달 구독갯수 admin_main.do
	public int searchsubscribeSalessolo() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int subscribeSales = 0;

		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT SUM(s.scode) AS subscribeSales" + " FROM subscribe s"
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

	// 구독 목록 가져오기 : admin_searchSubscribe.do
	public ArrayList<NDSubscribeDto_OKH> searchSubscribe() {
		ArrayList<NDSubscribeDto_OKH> dtos = new ArrayList<NDSubscribeDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM subscribe s ORDER BY scode DESC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int scode = resultSet.getInt("scode");
				String userid = resultSet.getString("userid");
				Timestamp subscribedate = resultSet.getTimestamp("subscribedate");
				NDSubscribeDto_OKH dto = new NDSubscribeDto_OKH(scode, userid, subscribedate);
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

	// 구독 일정 데이터 가져오기 : admin_admin_schedulesubscribe.do
	public ArrayList<NDSubscribeDto_OKH> scheduleSubscribe() {
		ArrayList<NDSubscribeDto_OKH> dtos = new ArrayList<NDSubscribeDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT p.plcode, s.userid, s.scode, p.plandate, p.delivery, u.name AS uname, pr.name AS pname, u.address"
					+ " FROM subscribe s" + " LEFT JOIN plan p ON s.scode = p.scode"
					+ " LEFT JOIN user u ON s.userid = u.userid" + " LEFT JOIN product pr ON p.pcode = pr.pcode;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int plcode = resultSet.getInt("plcode");
				String userid = resultSet.getString("userid");
				int scode = resultSet.getInt("scode");
				Timestamp plandate = resultSet.getTimestamp("plandate");
				int delivery = resultSet.getInt("delivery");
				String uname = resultSet.getString("uname");
				String pname = resultSet.getString("pname");
				String address = resultSet.getString("address");
				NDSubscribeDto_OKH dto = new NDSubscribeDto_OKH(plcode, userid, scode, plandate, delivery, uname, pname,
						address);
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