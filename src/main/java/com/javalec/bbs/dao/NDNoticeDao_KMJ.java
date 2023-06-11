package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.NDNoticeDto_KMJ;

public class NDNoticeDao_KMJ {
	
	DataSource dataSource;
	public NDNoticeDao_KMJ() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nutridelights"); 
			//위의 코드는 context.xml의 경로를 찾아서 그 내부에 있는 값들을 가져오는 역할을 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<NDNoticeDto_KMJ> noticeList(){
		ArrayList<NDNoticeDto_KMJ> dtos = new ArrayList<NDNoticeDto_KMJ>();
		Connection conn_mysql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn_mysql = dataSource.getConnection(); //context.xml에 미리 정의해놓은 값을 가져온다
			String query = "SELECT n.adminid, nw.title, nw.context, n.insertdate, nw.updatedate " +
                    		"FROM nwrite nw, notice n "+
                    		"WHERE nw.adminid = n.adminid and invalidate=1 and nw.seq=n.seq order by n.insertdate desc";
                    		
			ps = conn_mysql.prepareStatement(query);
			rs = ps.executeQuery();
			int noticeCount = 0;
			while(rs.next()) {
				/*select * from as count*/
				String id = rs.getString(1);
				String title = rs.getString(2);
				String context = rs.getString(3);
				String insertdate = rs.getString(4);
				String updatedate = rs.getString(5);
				
				noticeCount++;
				
				NDNoticeDto_KMJ dto = new NDNoticeDto_KMJ(noticeCount, id, title, context, insertdate, updatedate);
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

	
}
