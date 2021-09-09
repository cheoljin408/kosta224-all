package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

	public ArrayList<HashMap<String, Object>> findJobGroupList() throws SQLException {
		//HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select job, count(*), max(salary) as highestsal "
					+ "from s_employee "
					+ "group by job "
					+ "order by highestsal desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getInt(3));
				HashMap<String, Object> map = new HashMap<String, Object>();

				map.put("job", rs.getString(1));
				map.put("empcount", rs.getInt(2));
				map.put("highestsal", rs.getInt(3));
				list.add(map);
				/*
				for(int i=0; i<list.size(); i++) {
					HashMap<String, Object> map2 = list.get(i);
					System.out.println("job:" + map2.get("job") + " 사원수:" + map2.get("empcount") + " 최고월급:" + map2.get("highestsal"));
				}
				System.out.println();
				*/
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}
