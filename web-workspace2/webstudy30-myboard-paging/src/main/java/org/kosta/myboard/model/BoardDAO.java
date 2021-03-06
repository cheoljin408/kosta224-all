package org.kosta.myboard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private DataSource dataSource;
	
	private BoardDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	
	public static BoardDAO getInstance() {
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
	
	/**
	 	select b.no, b.title, b.hits, b.time_posted, m.name
		from (
			select row_number() over(order by no desc) as rnum, no, title, hits,
			to_char(time_posted, 'yyyy.mm.dd') as time_posted, id
			from board
		) b, board_member m
		where b.id = m.id and rnum between 1 and 5;
	 */
	public ArrayList<PostVO> getPostingList(PagingBean pagingBean) throws SQLException {
		ArrayList<PostVO> list = new ArrayList<PostVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select b.no, b.title, b.hits, b.time_posted, m.name ");
			sql.append("from ( ");
			sql.append("select row_number() over(order by no desc) as rnum, no, title, hits, ");
			sql.append("to_char(time_posted, 'yyyy.mm.dd') as time_posted, id ");
			sql.append("from board ");
			sql.append(") b, board_member m ");
			sql.append("where b.id = m.id and rnum between ? and ? ");
			sql.append("order by b.no desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pagingBean.getStartRowNumber());
			pstmt.setInt(2, pagingBean.getEndRowNumber());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVO pvo = new PostVO();
				
				pvo.setNo(rs.getInt(1));
				pvo.setTitle(rs.getString(2));
				pvo.setHits(rs.getInt(3));
				pvo.setTimePosted(rs.getString(4));
				
				
				MemberVO mvo = new MemberVO();
				
				mvo.setName(rs.getString(5));
				pvo.setMemberVO(mvo);
				list.add(pvo);
			}
			
 		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public void updateHits(String no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "update board set hits = hits+1 where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	public PostVO getPostingByNo(String no) throws SQLException {
		PostVO pvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select b.no, b.title, m.name, b.content, m.id, b.hits, to_char(b.time_posted, 'yyyy.mm.dd hh24:mi:ss') as time_posted ");
			sql.append("from board b, board_member m ");
			sql.append("where b.id=m.id and b.no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MemberVO mvo = new MemberVO(rs.getString("id"), null, rs.getString("name"));
				pvo = new PostVO(rs.getInt("no"), rs.getString("title"),
						rs.getString("content"), rs.getInt("hits"), rs.getString("time_posted"), mvo);
				
			}
		} finally {
			closeAll(pstmt, con);
		}
		
		return pvo;
	}
	
	public void posting(PostVO postVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "insert into board(no, title, content, time_posted, id) values(board_seq.nextval, ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, postVO.getTitle());
			pstmt.setString(2, postVO.getContent());
			pstmt.setString(3, postVO.getMemberVO().getId());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	public void deletePostByNo(String no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "delete from board where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	public void updatePostByNo(PostVO postVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "update board set title=?, content=? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, postVO.getTitle());
			pstmt.setString(2, postVO.getContent());
			pstmt.setInt(3, postVO.getNo());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * ??? ????????? ?????? ??????<br>
	 * ????????? ????????? ?????? ??????
	 * @return
	 * @throws SQLException
	 */
	public int getTotalPostCount() throws SQLException {
		int totalPostCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalPostCount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return totalPostCount;
	}
 }
