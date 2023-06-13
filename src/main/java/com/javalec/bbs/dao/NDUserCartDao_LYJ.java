package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDUserCartDto_LYJ;




public class NDUserCartDao_LYJ {
DataSource dataSource;


	public NDUserCartDao_LYJ() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


public ArrayList<NDUserCartDto_LYJ> list(String userid) {
	
	ArrayList<NDUserCartDto_LYJ> ndUserCartDto_LYJs = new ArrayList<NDUserCartDto_LYJ>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	// double max = 0;
	
	
	try {
		
		connection = dataSource.getConnection();
		
		String query = "SELECT cart.userid, cart.seq, product.pcode, product.name, product.photo, manage.price, cart.count"
		+ " FROM product"
		+ " JOIN cart ON product.pcode = cart.pcode"
		+ " JOIN manage ON product.pcode = manage.pcode"
		+ " WHERE cart.userid = '"+ userid +"'";
		 preparedStatement = connection.prepareStatement(query);
	     resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
		
			String userid1 = resultSet.getString("userid");	
			int seq = resultSet.getInt("seq");	
			String pcode = resultSet.getString("pcode");	
			String photo = resultSet.getString("photo");	
			String name = resultSet.getString("name");		
			int price = resultSet.getInt("price");
			String count= resultSet.getString("count");	
		
	

			NDUserCartDto_LYJ ndUserCartDto_LYJ = new NDUserCartDto_LYJ(userid1, seq, pcode, photo, name, price, count);
			ndUserCartDto_LYJs.add(ndUserCartDto_LYJ);	         
	         
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
	
	return ndUserCartDto_LYJs;
}


public void delete(String seq) {
	
	
	
	Connection connection = null;						
	PreparedStatement preparedStatement = null;			
	
	try {
		connection = dataSource.getConnection();			
		String query = "DELETE FROM cart WHERE seq = ?";		
		preparedStatement = connection.prepareStatement(query);	
	    preparedStatement.setString(1, seq);
	    preparedStatement.executeUpdate();	
		
	} catch (Exception e) {		
		e.printStackTrace();	
	
		
	}finally {  

		try {
			
			if(preparedStatement != null) preparedStatement.close();	
			if(connection != null) connection.close();					
		}catch (Exception e) {			
			e.printStackTrace();		
		}
	}
	

}
}