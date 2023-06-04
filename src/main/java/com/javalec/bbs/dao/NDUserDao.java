package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDLoginDto;


public class NDUserDao {
	DataSource dataSource;
	
	public NDUserDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Method
	// 회원가입
	public boolean userInsert(NDLoginDto dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO user (userid, userpw, name, gender, age, telno, address, email, allergy, insertdate, invalidate)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, now(), 1)";
			preparedStatement = connection.prepareStatement(query);
				
			preparedStatement.setString(1, dto.getUserid());
			preparedStatement.setString(2, dto.getUserpw());
			preparedStatement.setString(3, dto.getName());
			preparedStatement.setString(4, dto.getGender());
			preparedStatement.setInt(5, dto.getAge());
			preparedStatement.setString(6, dto.getTelno());
			preparedStatement.setString(7, dto.getAddress());
			preparedStatement.setString(8, dto.getAllergy());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
		
		return true;
	}
	
	// 로그인 시도시 정보 확인, 어드민 로그인 성공 = 1, 유저 로그인 성공 = 2, 로그인 실패 = 0
	public String loginCheck(String uid, String upassword, String isWho) {
		String idCheck = "";
		String pwCheck = "";
		String invali = "";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query;
		String result = "";
		
		try {
			connection = dataSource.getConnection();
			if(isWho.equals("admin")) {
				query = "SELECT adminid, adminpw FROM admin WHERE adminid='" + uid + "';";
			} else {
				query = "SELECT userid, userpw, invalidate FROM user WHERE userid='" + uid + "';";
			}
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				idCheck = uid.equals(resultSet.getString(1)) ? "success" : "fail";
				pwCheck = upassword.equals(resultSet.getString(2)) ? "success" : "fail";
				if(isWho.equals("user")) {
					invali = resultSet.getString(3).equals("0") ? "fail" : "success";
					System.out.println(resultSet.getString(3));
					System.out.println(invali);
				}
			}
			
			if((idCheck.equals("success") && pwCheck.equals("success") && isWho.equals("admin"))) {
				result = "admin";
			} else if((idCheck.equals("success") && pwCheck.equals("success")) && isWho.equals("user") && invali.equals("success")) {
				result = "user";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//어드민 인지 판별
	public boolean isAdmin(String uid) {
		String idCheck = "";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT adminid FROM admin WHERE adminid='" + uid + "';";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				idCheck = uid.equals(resultSet.getString(1)) ? "success" : "fail";
			}
			return idCheck.equals("success") ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 유저 이미 있는지 확인
	public boolean userCheck(String userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean result = true;
		String uid = "";
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT userid FROM user WHERE userid='" + userid + "';";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				uid = resultSet.getString(1);
			}
			
			return userid.equals(uid) ? true : false;
		} catch (Exception e) {
			return result;
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
