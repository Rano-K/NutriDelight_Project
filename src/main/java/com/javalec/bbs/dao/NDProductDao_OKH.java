package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDProductDto_OKH;

public class NDProductDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDProductDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	// 그래프 주문관련 정보 불러오기 : admin_graphorders.do
	public ArrayList<NDProductDto_OKH> searchOrders() {
		ArrayList<NDProductDto_OKH> dtos = new ArrayList<NDProductDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT p.name, SUM(o.count) AS totalorders" + "	FROM product p"
					+ "	JOIN orders o ON p.pcode = o.pcode" + "	WHERE o.refunddate IS NULL" + "	GROUP BY p.name";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				int totalorders = resultSet.getInt("totalorders");
				NDProductDto_OKH dto = new NDProductDto_OKH(name, totalorders);
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

	// 테이블 상품 관련 정보 불러오기 : admin_searchproduct.do
	public ArrayList<NDProductDto_OKH> searchProduct() {
		ArrayList<NDProductDto_OKH> dtos = new ArrayList<NDProductDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM product order by pcode";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String pcode = resultSet.getString("pcode");
				String name = resultSet.getString("name");
				String category = resultSet.getString("category");
				String rice = resultSet.getString("rice");
				String cook1 = resultSet.getString("cook1");
				String cook2 = resultSet.getString("cook2");
				String cook3 = resultSet.getString("cook3");
				String soup = resultSet.getString("soup");
				String photo = resultSet.getString("photo");
				Timestamp insertdate = resultSet.getTimestamp("insertdate");
				NDProductDto_OKH dto = new NDProductDto_OKH(pcode, name, category, rice, cook1, cook2, cook3, soup,
						photo, insertdate);
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
