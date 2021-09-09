package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.EmployeeDAO;

public class TestGroupBy {
	public static void main(String[] args) {
		try {
			EmployeeDAO dao = new EmployeeDAO();
			/*
			 	s_employee의 job별 사원수, 최고 salary를 조회(최고 salary 내림차순)
			 	
			 	job: 총무 사원수: 5명 최고월급: 1100
			 	job: 개발 사원수: 3명 최고월급: 900
			 	job: 영업 사원수: 2명 최고월급: 700
			 */
			ArrayList<HashMap<String, Object>> list = dao.findJobGroupList();
			for(int i=0; i<list.size(); i++) {
				HashMap<String, Object> map = list.get(i);
				System.out.println("job:" + map.get("job") + " 사원수:" + map.get("empcount") + " 최고월급:" + map.get("highestsal"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
