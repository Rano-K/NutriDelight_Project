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
			String query = "SELECT * FROM product order by CAST(pcode AS UNSIGNED)";
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
				int calories = resultSet.getInt("calories");
				NDProductDto_OKH dto = new NDProductDto_OKH(pcode, name, category, rice, cook1, cook2, cook3, soup,
						photo, insertdate, calories);
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

	// 업데이트관련 상품 관련 정보 불러오기 : admin_findproduct.do
	public ArrayList<NDProductDto_OKH> findProduct(String pcode) {
		ArrayList<NDProductDto_OKH> dtos = new ArrayList<NDProductDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM product WHERE pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pcode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				pcode = resultSet.getString("pcode");
				String name = resultSet.getString("name");
				String category = resultSet.getString("category");
				String rice = resultSet.getString("rice");
				String cook1 = resultSet.getString("cook1");
				String cook2 = resultSet.getString("cook2");
				String cook3 = resultSet.getString("cook3");
				String soup = resultSet.getString("soup");
				String photo = resultSet.getString("photo");
				Timestamp insertdate = resultSet.getTimestamp("insertdate");
				int calories = resultSet.getInt("calories");
				NDProductDto_OKH dto = new NDProductDto_OKH(pcode, name, category, rice, cook1, cook2, cook3, soup,
						photo, insertdate,calories);
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

	// 데이터 입력 하기 : admin_insertproduct.do
	public void insertProduct(String name, String category, String rice, String cook1, String cook2, String cook3,
			String soup, String photo, int calories) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO product (pcode, name, category, rice, cook1, cook2, cook3, soup, photo, insertdate, calories)"
					+ " SELECT IFNULL(MAX(CAST(pcode AS UNSIGNED)), 0) + 1, ?, ?, ?, ?, ?, ?, ?, ?, NOW(),? FROM product";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, category);
			preparedStatement.setString(3, rice);
			preparedStatement.setString(4, cook1);
			preparedStatement.setString(5, cook2);
			preparedStatement.setString(6, cook3);
			preparedStatement.setString(7, soup);
			preparedStatement.setString(8, photo);
			preparedStatement.setInt(9, calories);
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

	// 데이터 입력 하기 : admin_updateproduct.do
	public void updateProduct(String pcode, String name, String category, String rice, String cook1, String cook2,
			String cook3, String soup, String photo, int calories) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE product SET name = ?, category = ?, rice = ?, cook1 = ?, cook2 = ?, cook3 = ?, "
					+ " soup = ?, photo = ?, calories = ? WHERE pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, category);
			preparedStatement.setString(3, rice);
			preparedStatement.setString(4, cook1);
			preparedStatement.setString(5, cook2);
			preparedStatement.setString(6, cook3);
			preparedStatement.setString(7, soup);
			preparedStatement.setString(8, photo);
			preparedStatement.setInt(9, calories);
			preparedStatement.setString(10, pcode);
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

	// pcode로 name 알아내기
	public String getPname(String pcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String name = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT name FROM product WHERE pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pcode);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("name");
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
		return name;
	}
}
