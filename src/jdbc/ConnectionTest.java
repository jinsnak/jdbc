package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		
		Connection conn = null; //지역변수는 반드시 초기화해주어야 한다.(=null)
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			System.out.println("연결성공 :)");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 -_-");
			//e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결실패 -_-+");
			//e.printStackTrace();
		} finally {
			try {
				//conn이 null인 상태에서 들어온 경우 Error발생을 막기위해.
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
