package com.javalec.bbs.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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

	
	
	
	
	
	
}//End
