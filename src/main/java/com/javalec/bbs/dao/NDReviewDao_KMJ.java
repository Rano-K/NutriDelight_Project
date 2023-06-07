package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDReviewDto_KMJ;

public class NDReviewDao_KMJ {
	
	DataSource dataSource;
	public NDReviewDao_KMJ() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights"); 
			//위의 코드는 context.xml의 경로를 찾아서 그 내부에 있는 값들을 가져오는 역할을 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public ArrayList<NDReviewDto_KMJ> reviewList(int pcode){
		ArrayList<NDReviewDto_KMJ> dtos = new ArrayList<NDReviewDto_KMJ>();
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "SELECT DISTINCT r.userid, rw.likes, rw.contexts, r.insertdate, rw.updatedate, rw.image, r.parent, r.layer " +
                    		"FROM rwrite rw, review r "+
                    		"WHERE rw.userid = r.userid and rw.pcode = r.pcode and rw.seq = r.seq and r.pcode = ? and r.invalidate = 1";
                    		
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, pcode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				/*select * from as count*/
				String userid = rs.getString(1); //번호대신 이렇게 받을 수도 있다.
				int likes = rs.getInt(2);
				String contexts = rs.getString(3);
				String insertdate = rs.getString(4);
				String updatedate = rs.getString(5);
				String image = rs.getString(6);
				int parent = rs.getInt(7);
				int layer = rs.getInt(8);
				
				NDReviewDto_KMJ dto = new NDReviewDto_KMJ(userid, likes, contexts, insertdate, updatedate, image, parent, layer);
				dtos.add(dto);
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
		
		return dtos;
	}// list
	
	public String productList(int pcode){
		String name = "";
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "SELECT name, photo FROM product WHERE pcode = ?";
                    		
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, pcode);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				/*select * from as count*/
				name = rs.getString(1); //번호대신 이렇게 받을 수도 있다.
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
		
		return name;
	}
	
	public ArrayList<NDReviewDto_KMJ> QuestionList(int pcode){
		ArrayList<NDReviewDto_KMJ> dtos = new ArrayList<NDReviewDto_KMJ>();
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "SELECT DISTINCT r.userid, rw.likes, rw.contexts, rw.updatedate, rw.image, r.layer, r.adminid, r.parent " +
                    		"FROM rwrite rw, review r "+
                    		"WHERE rw.userid = r.userid and r.pcode = ?";
                    		
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, pcode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				/*select * from as count*/
				String userid = rs.getString(1); //번호대신 이렇게 받을 수도 있다.
				int likes = rs.getInt(2);
				String contexts = rs.getString(3);
				String date = rs.getString(4);
				String image = rs.getString(5);
				int layer = rs.getInt(6);
				String adminid = rs.getString(7);
				int parent = rs.getInt(8);
				
				//NDReviewDto_KMJ dto = new NDReviewDto_KMJ(userid, likes, contexts, date, image, layer, adminid, parent);
				//dtos.add(dto);
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
		
		return dtos;
	}// list
	
}
