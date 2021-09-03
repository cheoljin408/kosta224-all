package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 	DAO: Data Access Object 데이터 엑세스 로직을 정의하는 클래스
 */
public class MemberDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String pass = "tiger";
	
	public MemberDAO() throws ClassNotFoundException {
		Class.forName(driver);
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	
	// 오버로딩
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	/*
	 	DAO의 메소드에서는 Exception을 main으로 throws처리한다
	 	
	 	Connection
	 	insert sql 정의
	 	PreparedStatement
	 	execute
	 	close
	 */
	public void registerMember(MemberVO vo) throws SQLException {
		// 강사님 코드
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "insert into member(id, password, name, address) values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			
			int result = pstmt.executeUpdate();
			System.out.println("insert member " + result);
			
		} finally {
			closeAll(pstmt, con);
		}
		
		// 내 코드
		/*
		Connection con = DriverManager.getConnection(url, username, pass);
		String sql = "insert into member(id, password, name, address) values(?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getAddress());
		
		int result = pstmt.executeUpdate();
		System.out.println("insert member " + result);
		
		pstmt.close();
		con.close();
		*/
	}

	public MemberVO findMemberById(String id) throws SQLException {
		// 강사님 풀이
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "select password, name, address from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id); // 1은 sql의 첫 번째 물음표
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO(id, rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
		
		// 내 코드
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberVO memberVO = new MemberVO();
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memberVO.setId(rs.getString(1));
				memberVO.setPassword(rs.getString(2));
				memberVO.setName(rs.getString(3));
				memberVO.setAddress(rs.getString(4));
			}
		} finally {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
		return memberVO;
		*/
	}

	public ArrayList<MemberVO> getAllMemberList() throws SQLException {
		// 강사님 코드
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "select id, name from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 방법1
				// list.add(new MemberVO(rs.getString(1), null, rs.getString(2), null));
				
				// 방법2
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				list.add(vo);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
	
		return list;
		// 내 코드
		/*
		ArrayList<MemberVO> voList = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "select id, name from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 생성자 오버로딩 필요
				voList.add(new MemberVO(rs.getString(1), rs.getString(2)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return voList;
		*/
	}
}
