package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	public int getOrdercode(String userid, int pcode) {
		int ocode=0;
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "SELECT ordercode FROM orders WHERE userid = ? and pcode = ?";
                    		
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, userid);
			ps.setInt(2, pcode);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				/*select * from as count*/
				ocode = rs.getInt(1); //번호대신 이렇게 받을 수도 있다.
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
		
		return ocode;
	}
	
	public void insertReview(String ID, int pcode, int ordercode, String contexts, String image){
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		Statement stmt=null;
		ResultSet rs = null;
		int seq=0;
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			
			String query = "INSERT INTO rwrite (seq, userid, ordercode, pcode, likes, contexts, image, updatedate) "+
					"VALUES (?,?,?,?,0,?,?,now())";
			
			String query2 = "INSERT INTO review (parent, layer, userid, pcode, insertdate, invalidate) "+
					"VALUES (?,1,?,?,now(),1)"; //원래는 인서트가 두개면 메소드를 나눠야한다...
			
			String query1 = "SELECT MAX(seq) from review";
            stmt = conn_mysql.createStatement();
			
			rs = stmt.executeQuery(query1);
			
			if(rs.next()) {
				/*select * from as count*/
				seq = rs.getInt(1);
			}
			
			System.out.println("Dao 값 확인 : " + seq);
			
			ps1 = conn_mysql.prepareStatement(query2); 
			ps1.setInt(1, seq+1);
			ps1.setString(2, ID);
			ps1.setInt(3, pcode);
			
			ps = conn_mysql.prepareStatement(query); 
			ps.setInt(1, seq+1);
			ps.setString(2, ID);
			ps.setInt(3, ordercode);
			ps.setInt(4, pcode);
			ps.setString(5, contexts);
			ps.setString(6, image);
			
			ps1.executeUpdate();
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {//finally는 다시 말하지만 에러가 나든 안나든 무조건 실행되는 구문이다. 이를 통해 연결들을 해제한다.
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(ps != null) ps1.close();
				if(conn_mysql != null) conn_mysql.close();
			}catch (Exception e) {
				e.printStackTrace();		// TODO: handle exception
			}
		}
		
	}// list
	
}
