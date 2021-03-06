package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO {

	public CardDAO() throws ClassNotFoundException {
		Class.forName(DbInfo.DRIVER);
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
	}
	
	/*
	 	트랜잭션 처리작업을 하지 않아서 문제 발생되는 메소드의 예
	 	
	 	카드 발급 작업
	 	1. 카드 등록
	 	2. 포인트 등록
	 */
	public void registerCardAndPointVer1(String id, String name, String pointType, int point) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(DbInfo.URL, DbInfo.USERNAME, DbInfo.PASSWORD);
			String insertCardSql = "insert into card(id, name) values(?, ?)";
			String insertPointSql = "insert into point(id, point_type, point) values(?, ?, ?)";
			pstmt = con.prepareStatement(insertCardSql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			int result = pstmt.executeUpdate();
			System.out.println("카드 등록 ok " + result);
			pstmt.close();
			pstmt = con.prepareStatement(insertPointSql);
			pstmt.setString(1, id);
			pstmt.setString(2, pointType);
			pstmt.setInt(3, point);
			int result2 = pstmt.executeUpdate();
			System.out.println("포인트 등록 ok " + result2);
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/*
	 	트랜잭션 처리작업을 해서 카드 및 포인트 등록시점에 모든 세부적인 작업이 정상적으로 진행되면 commit 해서 실제 db에 반영
	 	세부 작업 중 하나라도 문제가 발생하면 진행되었던 작업은 rollback하여 작업을 취소하고 원상태로 되돌린다
	 	
	 	카드 발급 작업
	 	try {
	 		connection.setAutoCommit(false); 자동 커밋 모드를 해제
	 		1. 카드 등록
	 		2. 포인트 등록
	 		connection.commit();
	 	} catch(Exception e) {
	 		connection.rollback();
	 	} finally {
	 		closeAll();
	 	}
	 */
	public void registerCardAndPointVer2(String id, String name, String pointType, int point) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(DbInfo.URL, DbInfo.USERNAME, DbInfo.PASSWORD);
			
			// 트랜잭션 처리 작업을 위해 수동모드로 커밋 설정한다
			con.setAutoCommit(false);
			
			String insertCardSql = "insert into card(id, name) values(?, ?)";
			String insertPointSql = "insert into point(id, point_type, point) values(?, ?, ?)";
			pstmt = con.prepareStatement(insertCardSql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			int result = pstmt.executeUpdate();
			System.out.println("카드 등록 ok " + result);
			pstmt.close();
			pstmt = con.prepareStatement(insertPointSql);
			pstmt.setString(1, id);
			pstmt.setString(2, pointType);
			pstmt.setInt(3, point);
			int result2 = pstmt.executeUpdate();
			System.out.println("포인트 등록 ok " + result2);
			// 트랜잭션(카드등록 트랜잭션)내의 모든 작업이 정상적으로 진행되면 commit
			con.commit(); // 실제 db에 작업 결과를 반영
			System.out.println("**card와 point 등록 작업이 정상적으로 진행되어 commit**");
		} catch(Exception e) {
			con.rollback(); // 작업 내용을 취소하고 원상태로 되돌린다
			System.out.println("**card등록 트랜잭션 내에서 예외 발생하여 rollback**");
			throw e; // 호출한 측으로 예외 상활을 전파한다
		} finally {
			closeAll(pstmt, con);
		}
	}
}
