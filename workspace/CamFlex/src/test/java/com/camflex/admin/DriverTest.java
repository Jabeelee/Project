package com.camflex.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {
	
	public static void main(String[] args) {
		
		Connection con;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.137:1521:XE", "hr", "1234");
			System.out.println("DB 성공");
		}catch(SQLException e) {
			System.out.println("실패");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
