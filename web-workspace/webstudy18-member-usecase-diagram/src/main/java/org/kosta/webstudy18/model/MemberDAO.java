package org.kosta.webstudy18.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 	Singleton Design Pattern을 적용: 시스템 상에서 단 한번 객체를 생성해 공유하여 사용하고자 할때 적용하는 설계 패턴
 */
public class MemberDAO {
	// database
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";
	
	// singleton
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null)
			rs.close();
		closeAll(pstmt, con);
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public MemberVO findMemberById(String memberId) throws SQLException {
		MemberVO vo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select id, name, address from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO(rs.getString(1), null, rs.getString(2), rs.getString(3));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
	
	public MemberVO login(String memberId, String memberPass) throws SQLException {
		MemberVO vo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select name, address from member where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO(memberId, memberPass, rs.getString(1), rs.getString(2));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
	
	public ArrayList<MemberVO> findMemberListByAddress(String memberAddress) throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select id, name from member where address=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberAddress);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1), null, rs.getString(2), memberAddress));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}

	public void updateMember(MemberVO memberVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update member set password=?, name=?, address=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getPassword());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getAddress());
			pstmt.setString(4, memberVO.getId());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	public void register(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into member(id, password, name, address) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public int idCheck(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return result;
	}
}
