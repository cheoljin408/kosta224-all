package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestBookDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";
	
	public GuestBookDAO() throws ClassNotFoundException {
		Class.forName(driver);
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public void register(GuestBookDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			// String sql = "insert into guestbook(guestbook_no, title, content) values(guestbook_seq.nextval, ?, ?)";
			StringBuilder sql = new StringBuilder();
			sql.append("insert into guestbook(guestbook_no, title, content) ");
			sql.append("values(guestbook_seq.nextval, ?, ?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	
	}

	public ArrayList<GuestBookDTO> getAllGuestBookList() throws SQLException {
		ArrayList<GuestBookDTO> result = new ArrayList<GuestBookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select * from guestbook order by guestbook_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				result.add(new GuestBookDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}

	/*
	 	??? ???????????? db?????? ????????? ????????? ????????? dto??? guestbookNo??? ??????????????????
	 	????????? register???????????? ??????????????? ?????????
	 	Connection
	 	PreparedStatement
	 	insert sql ??????
	 	pstmt.close()
	 	PreparedStatement
	 	select sql ??????
	 	ResultSet
	 	closeAll()
	 */
	public void registerVer2(GuestBookDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String insertSql = "insert into guestbook(guestbook_no, title, content) values(guestbook_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.executeUpdate();
			pstmt.close();
			String selectSql = "select guestbook_seq.currval from dual";
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int guestBookNo = rs.getInt(1); // insert ????????? ???????????? ?????????(guestbook_no??? ????????? ???)??? ???????????? ????????????
				dto.setGuestbookNo(guestBookNo); // dto??? ????????????
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public ArrayList<GuestBookDTO> getGuestBookListLikeKeyword(String keyword) throws SQLException {
		ArrayList<GuestBookDTO> list = new ArrayList<GuestBookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select guestbook_no, title, content from guestbook where title like '%' || ? || '%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new GuestBookDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}
