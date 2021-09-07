package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	
	public EmployeeDAO() throws ClassNotFoundException {
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
		closeAll(pstmt, con);
	}

	public void register(Employee emp) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, DbInfo.USERNAME, DbInfo.PASSWORD);
			String sql = "insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getSalary());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public ArrayList<Employee> getEmployeeListByHighSalAndJob(String job) throws SQLException {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(DbInfo.URL, DbInfo.USERNAME, DbInfo.PASSWORD);
			// 내 sql
			/*
			String sql = "select * from ("
					+ "select * from S_EMPLOYEE where job = ?) "
					+ "where salary = ("
					+ "select max(salary) from (select * from S_EMPLOYEE where job = ?))";
			*/
			
			// 강사님 sql
			StringBuilder sql = new StringBuilder("select empno, name, job, salary ");
			sql.append("from s_employee ");
			sql.append("where job = ? ");
			sql.append("and salary = (select max(salary) from s_employee where job = ?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, job);
			pstmt.setString(2, job);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

}
