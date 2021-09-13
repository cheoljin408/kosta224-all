package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";
	
	public EmployeeDAO() throws ClassNotFoundException {
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

	public EmployeeVO findEmployeeByEmpno(int empno) throws SQLException {
		EmployeeVO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			StringBuilder sql = new StringBuilder("select e.empno, e.ename, e.sal");
			sql.append(", d.deptno, d.dname, d.loc, d.tel ");
			sql.append("from k_employee e, department d ");
			sql.append("where e.deptno = d.deptno and e.empno = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, empno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				DepartmentVO dVO = new DepartmentVO(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
				result = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getInt(3), dVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
}
