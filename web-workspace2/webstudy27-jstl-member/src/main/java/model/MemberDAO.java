package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataSource;
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public MemberVO findMemberById(String memberId) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select id, name, address, to_char(birthday, 'yyyy.mm.dd'), to_char(regdate, 'yyyy.mm.dd hh24:mm:ss') "
					+ "from mvc_member "
					+ "where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO(rs.getString(1), null, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
	
	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("select name, address, to_char(birthday, 'yyyy-mm-dd') ");
			sql.append("from  mvc_member ");
			sql.append("where id=? and password=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO(id, password, rs.getString(1), rs.getString(2), rs.getString(3), null);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
	
	public ArrayList<MemberVO> findMemberListByAddress(String address) throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("select id, name, to_char(birthday, 'yyyy-mm-dd') ");
			sql.append("from mvc_member ");
			sql.append("where address=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1), null, rs.getString(2), null, rs.getString(3), null));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public void updateMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("update mvc_member set ");
			sql.append("password=?, name=?, address=?, birthday=to_date(?, 'yyyy-mm-dd') where id=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getBirthday());
			pstmt.setString(5, vo.getId());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	public void registerMemner(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("insert into mvc_member(id, password, name, address, birthday, regdate) ");
			sql.append("values(?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'), sysdate)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getBirthday());
			pstmt.executeUpdate();
		} finally {
			
		}
	}

	public boolean idCheck(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("select count(*) from member where id=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next() && rs.getInt(1) == 1) {
				result = true;
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return result;
	}
}
