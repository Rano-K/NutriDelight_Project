package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public boolean insertOrder(String userid, String pcode, String count, String address) {
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		//ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "Insert into orders (userid, pcode, count, address, orderdate) values(?,?,?,?,now())";
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, userid);
			ps.setString(2, pcode);
			ps.setString(3, count);
			ps.setString(4, address);
			
			ps.executeUpdate();
			
			//rs = ps.executeQuery();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {//finally는 다시 말하지만 에러가 나든 안나든 무조건 실행되는 구문이다 이를 통해 연결들을 해제한다.
			try {
				if(ps != null) ps.close();
				if(conn_mysql != null) conn_mysql.close();
			}catch (Exception e) {
				e.printStackTrace();		// TODO: handle exception
				return false;
			}
		}
		
		return true;
	}

	public ArrayList<NDUserOrdersDto_LYJ> orderslist(String userid) {
		// TODO Auto-generated method stub
		ArrayList<NDUserOrdersDto_LYJ> ndUserOrdersDto_LYJs = new ArrayList<NDUserOrdersDto_LYJ>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// double max = 0;
		
		
		try {
			
			connection = dataSource.getConnection();
		
			String query = "SELECT u.userid, u.name, u.telno, u.address, p.name, m.price, o.count"
			+" FROM orders o"
			+" JOIN user u ON o.userid = u.userid"
			+" JOIN product p ON o.pcode = p.pcode"
			+" JOIN manage m ON p.pcode = m.pcode"
			+" WHERE u.userid = '" + userid + "'";
			
			
			 preparedStatement = connection.prepareStatement(query);
		     resultSet = preparedStatement.executeQuery();
		
		
		
		     while(resultSet.next()) {
		 		
					String userid1 = resultSet.getString("userid");	
					String uname = resultSet.getString("u.name");	
					String telno = resultSet.getString("telno");		
					String address = resultSet.getString("address");	
					String pname = resultSet.getString("p.name");	
					int price = resultSet.getInt("price");
					String count = resultSet.getString("count");	
					
				

					NDUserOrdersDto_LYJ ndUserOrdersDto_LYJ = new NDUserOrdersDto_LYJ(userid1, uname, telno, address, pname, price, count);

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


}
