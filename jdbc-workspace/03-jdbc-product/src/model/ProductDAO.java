package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Data Access Object
public class ProductDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";
	
	public ProductDAO() throws ClassNotFoundException {
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

	public int getProductToCount() throws SQLException {
		// 강사님 코드
		int totalCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) // 조회된 결과가 있으면 true를 반환하고 결과행으로 cursor를 이동
				totalCount = rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return totalCount;
		// 내 코드
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		
		return 0;
		*/
	}

	public boolean existsById(int productId) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from product where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId); // 첫번째 ?에 대해 할당
			rs = pstmt.executeQuery();
			
			if(rs.next() && rs.getInt(1) == 1)
				result = true;
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return result;
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from product where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					return true;
				}
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return false;
		*/
	}

	/*
	 	product table에 product 정보를 insert하는 메소드
	 */
	public void register(ProductDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "insert into product values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getMaker());
			pstmt.setInt(4, dto.getPrice());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	/*
	 	maker의 종류를 조회하여 리스트로 반환하는 메소드
	 */
	public ArrayList<String> getMakerKindList() throws SQLException {
		ArrayList<String> result = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select distinct maker from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString(1));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return result;
	}

	public ArrayList<ProductDTO> findProductListByPriceOderByPriceDesc(int lowPrice, int highPrice) throws SQLException {
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			//String sql = "select * from product where price between ? and ? order by price desc";
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append("from product ");
			sql.append("where price >= ? and price <= ? ");
			sql.append("order by price desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, lowPrice);
			pstmt.setInt(2, highPrice);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.add(new ProductDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
}
