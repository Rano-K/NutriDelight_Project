package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDLoginDto;
import com.javalec.bbs.dto.NDUserOrdersDto;


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
			String query = "INSERT INTO user (userid, userpw, name, gender, birthdate, telno, address, email, allergy, insertdate, invalidate)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, now(), 1)";
			preparedStatement = connection.prepareStatement(query);
				
			preparedStatement.setString(1, dto.getUserid());
			preparedStatement.setString(2, dto.getUserpw());
			preparedStatement.setString(3, dto.getName());
			preparedStatement.setString(4, dto.getGender());
			preparedStatement.setString(5, dto.getAge());
			preparedStatement.setString(6, dto.getTelno());
			preparedStatement.setString(7, dto.getAddress());
			preparedStatement.setString(8, dto.getEmail());
			preparedStatement.setString(9, dto.getAllergy());
			
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
		boolean result;
		String uid = "";
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT userid FROM user WHERE userid='" + userid + "';";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				uid = resultSet.getString(1);
			}
			
//			System.out.println("dao userid = " + userid + " uid = " + uid);
			if(userid.equals(uid)) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// 유저가 없을때도 여기로 체크
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
	
	// 유저 정보 받아 오기
	public ArrayList<NDLoginDto> userInfo(String userid){
		ArrayList<NDLoginDto> dtos = new ArrayList<NDLoginDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM user WHERE userid='" + userid + "';";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				String birthdate = resultSet.getString("birthdate");
				String telno = resultSet.getString("telno");
				String address = resultSet.getString("address");
				String email = resultSet.getString("email");
				String allergy = resultSet.getString("allergy");
				
				NDLoginDto dto = new NDLoginDto(name, gender, birthdate.substring(0, 10).replaceAll("-", "."), telno, email, address, allergy);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	// mypage user 정보
	public String mypageUserinfoCheck(String userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String result = "";
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT userpw FROM user WHERE userid='" + userid + "';";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String userpw = resultSet.getString("userpw");
				result = userpw;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "false";
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
	
	// 유저 정보 변경
	public void myPageUpdate(NDLoginDto dto, String id){//수정클릭시 작동
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String queryUpdate = "update user set name = ?, telno = ?, address = ?, email = ?, allergy = ? where userid =?";
			preparedStatement = connection.prepareStatement(queryUpdate);
			
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getTelno());
			preparedStatement.setString(3, dto.getAddress());
			preparedStatement.setString(4, dto.getEmail());
			preparedStatement.setString(5, dto.getAllergy());
			preparedStatement.setString(6, id);
			
			preparedStatement.executeUpdate();
			
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
		
	}
	
	// 유저의 구매내역 가져오기
	public ArrayList<NDUserOrdersDto> mypageUserOrderinfo(String userid) {
		ArrayList<NDUserOrdersDto> dtos = new ArrayList<NDUserOrdersDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String querydata = "SELECT o.ordercode, pr.photo, pr.name, o.count, m.price, o.orderdate, o.deliverydate, o.refunddate "
					+ "FROM user u "
					+ "JOIN orders o ON u.userid = o.userid "
					+ "JOIN product pr ON o.pcode = pr.pcode "
					+ "JOIN manage m ON pr.pcode = m.pcode "
					+ "WHERE u.userid = ?;";
			preparedStatement = connection.prepareStatement(querydata);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int ordercode = resultSet.getInt(1);
				String photo = resultSet.getString(2);
				String name = resultSet.getString(3);
				int count = resultSet.getInt(4);
				int price = resultSet.getInt(5);
				Timestamp orderdate = resultSet.getTimestamp(6);
				Timestamp deliverydate = resultSet.getTimestamp(7);
				Timestamp refunddate = resultSet.getTimestamp(8);
				
				NDUserOrdersDto dto = new NDUserOrdersDto(ordercode, count, orderdate, refunddate, deliverydate, photo, name, price);
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
	
}
