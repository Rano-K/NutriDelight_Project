package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDProductListDto_KMS;

public class MainDao_KMS {
	
	/*
	 * 1.
	 * 2.
	 * 3.
	 * 4.
	 * 5.
	 * 6.
	 * 7.
	 * 8.
	 * 
	 */
	DataSource dataSource;
	public MainDao_KMS() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights"); 
			//위의 코드는 context.xml의 경로를 찾아서 그 내부에 있는 값들을 가져오는 역할을 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//productList에서 pcode, name, price, photo를 들고 온다.
		public ArrayList<NDProductListDto_KMS> TakeAll() {
			ArrayList<NDProductListDto_KMS> dtos = new ArrayList<NDProductListDto_KMS>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
					
			
			try {
				connection = dataSource.getConnection();
				String query = "select p,pcode, p.pname, m.price, p.photo, p.calories from product p, manage m "
						+"where p.pcode = m.pcode and m.invalidate='1'";			
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					String pcode = resultSet.getString("pcode");
					String name = resultSet.getString("name");
					int price = resultSet.getInt("price");
					String photo = resultSet.getString("photo");
					String calories = resultSet.getString("calories");
					
					NDProductListDto_KMS dto = new NDProductListDto_KMS(pcode, name, price, photo, calories);
					dtos.add(dto);
							
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
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
			return dtos;
		}//TakeAll END
	
	
	
	
}//End
