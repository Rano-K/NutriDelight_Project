package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// mport java.util.ArrayList;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDUserOrdersDto_LYJ;


public class NDUserOrdersDao_LYJ {
	DataSource dataSource;
	
	public NDUserOrdersDao_LYJ() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public NDUserOrdersDto_LYJ productInfo(String pcode){
		
		NDUserOrdersDto_LYJ dto = new NDUserOrdersDto_LYJ();
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "SELECT p.name, p.photo, m.price " +
            		"FROM product p " +
            		"INNER JOIN manage m ON p.pcode = m.pcode " + 
            		"WHERE p.pcode = ?";
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, pcode);
			rs = ps.executeQuery();
			
			if(rs.next()) { //1개만 찾는거면 while말고 if쓰면 된다
				/*select * from as count*/
				String name = rs.getString(1);
				String photo = rs.getString(2);
				int price = rs.getInt(3);
				
				
				
				dto = new NDUserOrdersDto_LYJ(pcode, name, photo, price);
				
			
			}
			
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {//finally는 다시 말하지만 에러가 나든 안나든 무조건 실행되는 구문이다. 이를 통해 연결들을 해제한다.
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn_mysql != null) conn_mysql.close();
			}catch (Exception e) {
				e.printStackTrace();		// TODO: handle exception
			}
		}
		
		return dto;
	}
		
	
	
	
	
	public NDUserOrdersDto_LYJ userInfo(String userid){
		NDUserOrdersDto_LYJ dto1 = new NDUserOrdersDto_LYJ();
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); 
			String query = "SELECT name, telno, address, email from user where userid = ?";
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) { 
				String name = rs.getString(1);
				String telno = rs.getString(2);
				String address = rs.getString(3);
				String email = rs.getString(4);
				
				dto1 = new NDUserOrdersDto_LYJ(name, telno, address, email);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn_mysql != null) conn_mysql.close();
			}catch (Exception e) {
				e.printStackTrace();		
			}
		}
		
		return dto1;
	}
	
	
	
	
	
	
	
	
	
	public boolean insertOrder(String userid, String pcode, int count, String address) {
		Connection conn_mysql = null;
		PreparedStatement ps = null;
	
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "Insert into orders (userid, pcode, count, address, orderdate) values(?,?,?,?,now())";
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, userid);
			ps.setString(2, pcode);
			ps.setInt(3, count);
			ps.setString(4, address);
			
			ps.executeUpdate();
			
		
		
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(ps != null) ps.close();
				if(conn_mysql != null) conn_mysql.close();
			}catch (Exception e) {
				e.printStackTrace();	
				return false;
			}
		}
		
		return true;
	}

	public ArrayList<NDUserOrdersDto_LYJ> cartOrders(String pcode) {
		// TODO Auto-generated method stub
		ArrayList<NDUserOrdersDto_LYJ> dtos = new ArrayList<NDUserOrdersDto_LYJ>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			connection = dataSource.getConnection();
			String querydata = "SELECT pr.photo, pr.name, c.count, m.price "
					+ "FROM user u "
					+ "JOIN cart c ON u.userid = c.userid "
					+ "JOIN product pr ON c.pcode = pr.pcode "
					+ "JOIN manage m ON pr.pcode = m.pcode "
					+ "WHERE pr.pcode = ?;";
			preparedStatement = connection.prepareStatement(querydata);
			preparedStatement.setString(1, pcode);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String name = resultSet.getString(1);
				String photo = resultSet.getString(2);
				int price = resultSet.getInt(3);
				String count = resultSet.getString(4);
			
				
				NDUserOrdersDto_LYJ dto = new NDUserOrdersDto_LYJ(name, photo, price, count);
				dtos.add(dto);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return dtos;
	}
		
	
	
	
	
	
	
	
	
	
	/*

	public ArrayList<NDUserOrdersDto_LYJ> orderslist(String userid) {
		// TODO Auto-generated method stub
		ArrayList<NDUserOrdersDto_LYJ> ndUserOrdersDto_LYJs = new ArrayList<NDUserOrdersDto_LYJ>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// double max = 0;
		
		
		try {
			
			connection = dataSource.getConnection();
		
			String query = "SELECT u.userid, u.name, u.telno, u.address"
			+" FROM user u "
			+" WHERE u.userid = '" + userid + "'";
			
			
			 preparedStatement = connection.prepareStatement(query);
		     resultSet = preparedStatement.executeQuery();
		
		
		
		     while(resultSet.next()) {
		 		
					String userid1 = resultSet.getString("userid");	
					String uname = resultSet.getString("u.name");	
					String telno = resultSet.getString("telno");		
					String address = resultSet.getString("address");	
					
					
				

					NDUserOrdersDto_LYJ ndUserOrdersDto_LYJ = new NDUserOrdersDto_LYJ(userid1, uname, telno, address);

					ndUserOrdersDto_LYJs.add(ndUserOrdersDto_LYJ);	         
			         
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return ndUserOrdersDto_LYJs;
		}
*/

}
