package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDPlanDto_OKH;
import com.javalec.bbs.dto.NDSubscribeDto_OKH;

public class NDPlanDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDPlanDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	// 구독 목록 가져오기 - 마지막 배송 날짜 : admin_searchSubscribe.do
	public ArrayList<NDPlanDto_OKH> searchSubscribeDeliverydate() {
		ArrayList<NDPlanDto_OKH> dtos = new ArrayList<NDPlanDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT COALESCE(t.plcode, t2.plcode_today) AS plcode, t.deliverydate" 
				    + " FROM ("
				    + "    SELECT scode, "
				    + "           MAX(CASE WHEN delivery = 1 THEN plcode END) AS plcode, "
				    + "           MAX(CASE WHEN delivery = 1 THEN plandate END) AS deliverydate"
				    + "    FROM plan"
				    + "    GROUP BY scode"
				    + " ) AS t"
				    + " LEFT JOIN ("
				    + "    SELECT scode, MAX(plcode) AS plcode_today"
				    + "    FROM plan"
				    + "    WHERE DATE(plandate) = CURDATE() AND delivery = 1"
				    + "    GROUP BY scode"
				    + " ) AS t2 ON t.scode = t2.scode"
				    + " ORDER BY t.scode DESC";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int plcode = resultSet.getInt("plcode");
				Timestamp deliverydate = resultSet.getTimestamp("deliverydate");
				NDPlanDto_OKH dto = new NDPlanDto_OKH(plcode, deliverydate);
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

	// 구독 목록 가져오기 - 내일 배송품목 : admin_searchSubscribe.do
	public ArrayList<NDPlanDto_OKH> searchSubscribeShippingTmw() {
		ArrayList<NDPlanDto_OKH> dtos = new ArrayList<NDPlanDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT COALESCE(p.name, 'NULL') AS pname" + "	FROM subscribe AS s" + "	LEFT JOIN ("
					+ "	  SELECT pl.scode, MAX(pl.plandate) AS last_delivery_date" + "	  FROM plan AS pl"
					+ "	  WHERE pl.delivery = 1" + "	  GROUP BY pl.scode"
					+ "	) AS last_delivery ON s.scode = last_delivery.scode\n"
					+ "	LEFT JOIN plan AS pl ON last_delivery.scode = pl.scode AND last_delivery.last_delivery_date = pl.plandate"
					+ "	LEFT JOIN product AS p ON pl.pcode = p.pcode AND DATE(pl.plandate) = CURDATE()"
					+ "	ORDER BY s.scode DESC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("pname");
				NDPlanDto_OKH dto = new NDPlanDto_OKH(name);
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

	// 배송처리 하기 : admin_updatesubscribe.do
	public void updateSubscribe(int plcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE plan SET delivery =1 WHERE plcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, plcode);
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
