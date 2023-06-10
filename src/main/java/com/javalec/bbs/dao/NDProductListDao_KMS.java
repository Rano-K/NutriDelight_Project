package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.javalec.bbs.command.NDCommand;
import com.javalec.bbs.dto.NDProductListDto_KMS;

public class NDProductListDao_KMS implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}
	
	DataSource dataSource;
	public NDProductListDao_KMS() {
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
	 * productlist에서 db연결 필요한 작업
	 * 1. 모든 product관련 db를 불러온다.
	 * 2. 정렬시킨다.
	 *  2-1. 칼로리 적은 순으로 정렬
	 *  2-2. 가격 높은순으로 정렬
	 *  2-3. 가격 낮은순으로 정렬
	 * 
	 * 3.정렬시킨 상품을 페이징한다.
	 */

	
	//productList에서 pcode, name, price, photo를 들고 온다.
	public ArrayList<NDProductListDto_KMS> TakeAll() {
		ArrayList<NDProductListDto_KMS> dtos = new ArrayList<NDProductListDto_KMS>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		
		try {
			connection = dataSource.getConnection();
			String query = "select p.pcode, p.name, m.price, p.photo from product as p, manage as m where p.pcode = m.pcode and m.invalidate='1';";			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String pcode = resultSet.getString("pcode");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				String photo = resultSet.getString("photo");
				
				NDProductListDto_KMS dto = new NDProductListDto_KMS(pcode, name, price, photo);
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

	




}//END
