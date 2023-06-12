package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDSearchActionDto_KMS;

public class NDSearchActionDao_KMS {

	DataSource dataSource;
	public NDSearchActionDao_KMS() {
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
	 * 검색쿼리
	 * select로 product 에 있는 name, category, rice, cook1, cook2, cook3, soup을 검색한다.
	 */
	
	public ArrayList<NDSearchActionDto_KMS> searchAction(String name, String category, String rice, String cook1, String cook2, String cook3, String soup) {
	    ArrayList<NDSearchActionDto_KMS> dtos = new ArrayList<NDSearchActionDto_KMS>();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = dataSource.getConnection();
	        String searchActionQuery = "SELECT * FROM product WHERE ";

	        if (name != null) {
	            searchActionQuery += "name LIKE '%" + name + "%' AND ";
	        }

	        if (category != null) {
	            searchActionQuery += "category LIKE '%" + category + "%' AND ";
	        }

	        if (rice != null) {
	            searchActionQuery += "rice LIKE '%" + rice + "%' AND ";
	        }

	        if (cook1 != null) {
	            searchActionQuery += "cook1 LIKE '%" + cook1 + "%' AND ";
	        }

	        if (cook2 != null) {
	            searchActionQuery += "cook2 LIKE '%" + cook2 + "%' AND ";
	        }

	        if (cook3 != null) {
	            searchActionQuery += "cook3 LIKE '%" + cook3 + "%' AND ";
	        }

	        if (soup != null) {
	            searchActionQuery += "soup LIKE '%" + soup + "%' AND ";
	        }

	        if (searchActionQuery.endsWith("AND ")) {
	            searchActionQuery = searchActionQuery.substring(0, searchActionQuery.length() - 4);
	        }

	        preparedStatement = connection.prepareStatement(searchActionQuery);
	        resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            String resultName = resultSet.getString("name");
	            String resultCategory = resultSet.getString("category");
	            String resultRice = resultSet.getString("rice");
	            String resultCook1 = resultSet.getString("cook1");
	            String resultCook2 = resultSet.getString("cook2");
	            String resultCook3 = resultSet.getString("cook3");
	            String resultSoup = resultSet.getString("soup");

	            NDSearchActionDto_KMS dto = new NDSearchActionDto_KMS(resultName, resultCategory, resultRice, resultCook1, resultCook2, resultCook3, resultSoup);
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
	/*
	 *  public List<Recipe> searchRecipes(String keyword) {
        List<Recipe> recipes = new ArrayList<>();

        try {
            // 쿼리 작성
            String query = "SELECT * FROM recipes WHERE name LIKE ? OR category LIKE ? OR rice LIKE ? OR cook1 LIKE ? OR cook2 LIKE ? OR cook3 LIKE ? OR soup LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // 파라미터 설정
            String searchKeyword = "%" + keyword + "%";
            statement.setString(1, searchKeyword);
            statement.setString(2, searchKeyword);
            statement.setString(3, searchKeyword);
            statement.setString(4, searchKeyword);
            statement.setString(5, searchKeyword);
            statement.setString(6, searchKeyword);
            statement.setString(7, searchKeyword);
            // 쿼리 실행
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // 결과 처리
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                String rice = resultSet.getString("rice");
                String cook1 = resultSet.getString("cook1");
                String cook2 = resultSet.getString("cook2");
                String cook3 = resultSet.getString("cook3");
                String soup = resultSet.getString("soup");

                Recipe recipe = new Recipe(name, category, rice, cook1, cook2, cook3, soup);
                recipes.add(recipe);
            }

            // 리소스 해제
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipes;
    }이게 되나?
	 */
	
	
	
	
	
	
}//End
