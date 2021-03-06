package jspTest1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	
	//디비연결
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cos", "bitc5600");
			
			return conn;
		} catch (Exception e) {
			System.out.println("디비연결에러 :" + e.getMessage());
		}
		return null;
		
	}
	
	//디비종료
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
	
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("디비종료에러:" + e.getMessage());
		}
	}
}
