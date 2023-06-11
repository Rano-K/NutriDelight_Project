package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class NDHeaderCountDao_KMS  {
	
	DataSource dataSource;
	public NDHeaderCountDao_KMS() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights"); 
			//위의 코드는 context.xml의 경로를 찾아서 그 내부에 있는 값들을 가져오는 역할을 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ndheaderDao가 하는일:
	 * heart에 찜한 갯수를 count출력
	 * cart에 찜한 갯수를 count출력
	 * cart에 담긴 제품의 총합산가격 출력
	 */
	
	//heart에 찜한 갯수 pcode_count 출력
	public int heartCount(String userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query="";
		int countHeart =0;
		
		try {
			connection = dataSource.getConnection();
			
			query = "SELECT COUNT(pcode) AS pcode_count"
					+ " FROM wishlist"
					+ " WHERE userid =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				countHeart = resultSet.getInt("pcode_count");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return countHeart;
	
	
	}//heartCountEnd
	
	public int cartCount(String userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query="";
		int countCart=0;
		
		try {
			connection = dataSource.getConnection();
			query = "SELECT SUM(count) AS total_count FROM cart WHERE userid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				countCart = resultSet.getInt("total_count");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return countCart;
		
	}//cartCountEnd;
	
	public int cartTotalPrice(String userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query="";
		int countTotalPrice=0;
		
		try {
			connection = dataSource.getConnection();
			query = "SELECT SUM(m.price * c.count) AS total_price" + " FROM cart AS c"
                    + "JOIN product AS p ON c.pcode = p.pcode" + " JOIN manage AS m ON p.pcode = m.pcode"
                    + " WHERE c.userid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				countTotalPrice = resultSet.getInt("total_price");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return countTotalPrice;
		
	}//cartTotalPriceEnd
	
}//End
