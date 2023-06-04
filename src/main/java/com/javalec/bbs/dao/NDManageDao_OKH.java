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
		// 오더관련 재고불러오기 : searchOrders.do
		public ArrayList<NDManageDto_OKH> searchOrders() {
			ArrayList<NDManageDto_OKH> dtos = new ArrayList<NDManageDto_OKH>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {
				connection = dataSource.getConnection();
				String query = "SELECT manage.stock"
						+ " FROM orders"
						+ " JOIN product ON orders.pcode = product.pcode"
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
		
		// 오더관련 모든 정보 불러오기 : searchOrders.do
				public  ArrayList<NDManageDto_OKH> searchupdate(int ordercode) {
					 ArrayList<NDManageDto_OKH> dtos = new ArrayList<NDManageDto_OKH>();
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;

					try {
						connection = dataSource.getConnection();
						String query = "SELECT manage.stock"
								+ " FROM orders"
								+ " JOIN product ON orders.pcode = product.pcode"
								+ " JOIN manage ON product.pcode = manage.pcode"
								+ " WHERE orders.ordercode = ?";
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
}
