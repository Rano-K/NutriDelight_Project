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
		//	환불 확인 정보 넣기 : admin_updateorders_checked.do
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
		
			//	배송 확인 정보 넣기 : admin_updateorders_checked.do
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
}
