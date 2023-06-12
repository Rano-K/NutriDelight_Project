package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NDRemainDateDao_KMS {

	DataSource dataSource;
	public NDRemainDateDao_KMS() {
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
	 * public Timestamp remainDate(String userid) { Connection connection = null;
	 * PreparedStatement preparedStatement = null; ResultSet resultSet = null;
	 * Timestamp remainDate = null;
	 * 
	 * try { connection = dataSource.getConnection(); String query =
	 * "SELECT subscribedate FROM subscribe WHERE userid = ?"; preparedStatement =
	 * connection.prepareStatement(query); preparedStatement.setString(1, userid);
	 * resultSet = preparedStatement.executeQuery();
	 * 
	 * if (resultSet.next()) { Timestamp subscribeDate =
	 * resultSet.getTimestamp("subscribedate");
	 * 
	 * // endDate 계산: subscribeDate + 30일 LocalDateTime subscribeDateTime =
	 * subscribeDate.toLocalDateTime(); LocalDateTime endDate =
	 * subscribeDateTime.plusDays(30); Timestamp endDateTimestamp =
	 * Timestamp.valueOf(endDate);
	 * 
	 * 
	 * // 현재 날짜와 endDateTimestamp 간의 차이 계산 LocalDateTime currentDateTime =
	 * LocalDateTime.now(); Period period =
	 * Period.between(currentDateTime.toLocalDate(), endDate.toLocalDate()); int
	 * remainingDays = period.getDays();
	 * 
	 * 
	 * // remainDate 계산: endDate - 현재 시간 + 남은 일 수 LocalDateTime remainDateTime =
	 * endDate.plusDays(remainingDays); remainDate =
	 * Timestamp.valueOf(remainDateTime);
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); } finally { try { if
	 * (resultSet != null) resultSet.close(); if (preparedStatement != null)
	 * preparedStatement.close(); if (connection != null) connection.close(); }
	 * catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * return remainDate; }
	 */

	public String remainDate(String userid) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    String remainDate = null;

	    try {
	        connection = dataSource.getConnection();
	        String query = "SELECT subscribedate FROM subscribe WHERE userid = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, userid);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            Timestamp subscribeDate = resultSet.getTimestamp("subscribedate");

	            // endDate 계산: subscribeDate + 30일
	            LocalDateTime subscribeDateTime = subscribeDate.toLocalDateTime();
	            LocalDateTime endDate = subscribeDateTime.plusDays(30);

	            // 현재 날짜와 endDate 간의 차이 계산
	            LocalDate currentDate = LocalDate.now();
	            LocalDate endDateDate = endDate.toLocalDate();
	            Duration duration = Duration.between(currentDate.atStartOfDay(), endDateDate.atStartOfDay());
	            long remainingDays = duration.toDays();

	            remainDate = String.valueOf(remainingDays);
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
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return remainDate;
	}
	
}//END
