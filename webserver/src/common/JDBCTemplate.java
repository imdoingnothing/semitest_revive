package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
//		Properties의 파일의 경로를 URL객체로 반환해서 getPath()를 쓰면 String형의 경로가 됨
//		System.out.println("url 경로 : " + JDBCTemplate.class.getResource("/sql/driver.properties").getPath());
		String fileName = JDBCTemplate.class.getResource("/sql/driver.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));		
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			
			conn.setAutoCommit(false); 
//			기본값은 true, 원칙은 application에서 제어해야 하므로
//			우리가 나중에 if문으로 처리하자
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if( conn != null && !conn.isClosed() ) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if( stmt != null && !stmt.isClosed() ) {
				stmt.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if( rset != null && !rset.isClosed() ) {
				rset.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}













