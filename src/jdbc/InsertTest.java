package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {

		Connection conn = null; //지역변수는 반드시 초기화해주어야 한다.(=null)
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. Statenemt 준비
			String sql = "insert into emaillist values (seq_emaillist.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 값 바인딩
			pstmt.setString(1, "Kim");
			pstmt.setString(2, "YoungMi");
			pstmt.setString(3, "PyeongChang@korea.com");
			
			//5. SQL문 실행
			int count = pstmt.executeUpdate();
			
			//6. 성공유무
			if (count == 1) {
				System.out.println("Insert Success");
			} else {
				System.out.println("Insert Fail");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 -_-");
			//e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결실패 -_-+");
			//e.printStackTrace();
		} finally {
			//6. 자원정리
			try {
				
				if (pstmt != null) {
					pstmt.close();
				}
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
