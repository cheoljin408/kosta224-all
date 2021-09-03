package step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 	MEMBER ID로 SELECT
 	ID는 PRIMARY KEY(PK, 기본키, 주키 ..) 이므로 SQL을 실행하면
 	1명의 회원정보가 존재하거나 존재하지 않는다
 */
public class TestJDBC3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 회원 아이디를 입력하세요:");
		String id = scanner.nextLine();
		scanner.close();
		
		System.out.println(id + " 아이디 회원정보를 db에서 조회");
		
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			String sql = "select name, address from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			else {
				System.out.println(id + " 아이디를 가진 회원은 존재하지 않습니다");
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
