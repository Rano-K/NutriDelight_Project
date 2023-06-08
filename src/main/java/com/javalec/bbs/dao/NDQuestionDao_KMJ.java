package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDQuestionDto_KMJ;
import com.javalec.bbs.dto.NDReviewDto_KMJ;

public class NDQuestionDao_KMJ {
	
	DataSource dataSource;
	public NDQuestionDao_KMJ() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights"); 
			//위의 코드는 context.xml의 경로를 찾아서 그 내부에 있는 값들을 가져오는 역할을 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<NDQuestionDto_KMJ> QuestionList(int pcode){
		ArrayList<NDQuestionDto_KMJ> dtos = new ArrayList<NDQuestionDto_KMJ>();
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "SELECT DISTINCT b.userid, b.layer, bw.image, bw.title, bw.context, b.insertdate, bw.updatedate " +
            		"FROM bwrite bw, board b "+
            		"WHERE bw.userid = b.userid and bw.seq = b.seq and b.invalidate = 1 and b.pcode = ?";
                    		
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, pcode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				/*select * from as count*/
				String userid = rs.getString(1);
				int layer = rs.getInt(2);
				String image = rs.getString(3);
				String title = rs.getString(4);
				String context = rs.getString(5);
				String insertdate = rs.getString(6);
				String updatedate = rs.getString(7);
				
				
				NDQuestionDto_KMJ dto = new NDQuestionDto_KMJ(userid, layer, image, title, context,insertdate,updatedate);
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
	
	public void insertBoard(String ID, int pcode, String title, String context, String image){
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		Statement stmt=null;
		ResultSet rs = null;
		int seq=0;
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			
			String query = "INSERT INTO bwrite (seq, userid, title, context, image, updatedate) "+
					"VALUES (?,?,?,?,?,now())";
			
			String query2 = "INSERT INTO board (parent, layer, userid, pcode, insertdate, invalidate) "+
					"VALUES (?,1,?,?,now(),1)";
			
			String query1 = "SELECT MAX(seq) from board"; //원래는 인서트가 두개면 메소드를 나눠야한다...
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
			ps.setString(3, title);
			ps.setString(4, context);
			ps.setString(5, image);
			
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
