package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDManageDto_OKH;
import com.javalec.bbs.dto.NDOrdersDto_OKH;
import com.javalec.bbs.dto.NDProductDto_OKH;

public class NDManageDao_OKH {
	// Field
	DataSource dataSource;

	// Constructor
	public NDManageDao_OKH() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	// 오더관련 재고불러오기 : admin_searchOrders.do
	public ArrayList<NDManageDto_OKH> searchOrders() {
		ArrayList<NDManageDto_OKH> dtos = new ArrayList<NDManageDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT manage.stock" + " FROM orders" + " JOIN product ON orders.pcode = product.pcode"
					+ " JOIN manage ON product.pcode = manage.pcode";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int stock = resultSet.getInt("stock");

				NDManageDto_OKH dto = new NDManageDto_OKH(stock);
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

	// 오더관련 모든 정보 불러오기 : admin_searchOrders.do
	public ArrayList<NDManageDto_OKH> searchupdate(int ordercode) {
		ArrayList<NDManageDto_OKH> dtos = new ArrayList<NDManageDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT manage.stock" + " FROM orders" + " JOIN product ON orders.pcode = product.pcode"
					+ " JOIN manage ON product.pcode = manage.pcode" + " WHERE orders.ordercode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ordercode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int stock = resultSet.getInt("stock");

				NDManageDto_OKH dto = new NDManageDto_OKH(stock);
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

	// 테이블 제품 관련 정보 불러오기 admin_searchProduct.do
	public ArrayList<NDManageDto_OKH> searchProduct() {
		ArrayList<NDManageDto_OKH> dtos = new ArrayList<NDManageDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM manage order by CAST(pcode AS UNSIGNED)";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String adminid = resultSet.getString("adminid");
				String pcode = resultSet.getString("pcode");
				int stock = resultSet.getInt("stock");
				int price = resultSet.getInt("price");
				Timestamp updatedate = resultSet.getTimestamp("updatedate");
				int invalidate = resultSet.getInt("invalidate");
				NDManageDto_OKH dto = new NDManageDto_OKH(adminid, pcode, stock, price, updatedate, invalidate);
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
	public ArrayList<NDManageDto_OKH> findProduct(String pcode) {
		ArrayList<NDManageDto_OKH> dtos = new ArrayList<NDManageDto_OKH>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM manage WHERE pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pcode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String adminid = resultSet.getString("adminid");
				pcode = resultSet.getString("pcode");
				int stock = resultSet.getInt("stock");
				int price = resultSet.getInt("price");
				Timestamp updatedate = resultSet.getTimestamp("updatedate");
				int invalidate = resultSet.getInt("invalidate");
				NDManageDto_OKH dto = new NDManageDto_OKH(adminid, pcode, stock, price, updatedate, invalidate);
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
	//	데이터 입력 하기 : admin_insertproduct.do
	public void insertProduct(String adminid, int stock, int price) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO manage (adminid, pcode, stock, price, updatedate, invalidate)"
					+ " SELECT ?, IFNULL(MAX(CAST(pcode AS UNSIGNED)), 0) + 1, ?, ?, now(), 1 FROM manage";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, adminid);
			preparedStatement.setInt(2, stock);
			preparedStatement.setInt(3, price);
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
	
	//	데이터 수정 하기 : admin_updateproduct.do
	public void updateProduct(String adminid, String pcode, int stock, int price) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE manage SET adminid = ?, stock = ?, price = ?, updatedate = NOW() WHERE pcode = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, adminid);
			preparedStatement.setInt(2, stock);
			preparedStatement.setInt(3, price);
			preparedStatement.setString(4, pcode);
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
	

	// 상품관련 정보 삭제 하기 : admin_deleteproduct.do
	public void deleteProduct(String pcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE manage SET invalidate = 0 WHERE pcode = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pcode);

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

	// 상품관련 정보 복구 하기 : admin_deleteproduct.do
	public void recoverProduct(String pcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE manage SET invalidate = 1 WHERE pcode = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pcode);

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
