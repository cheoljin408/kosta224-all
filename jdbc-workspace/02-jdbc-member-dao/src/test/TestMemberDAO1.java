package test;

import java.sql.SQLException;

import model.MemberDAO;
import model.MemberVO;

/*
 	회원정보를 member table에 insert하는 예제
 */
public class TestMemberDAO1 {
	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			// insert 즉 등록할 회원정보
			MemberVO vo = new MemberVO("servlet", "a", "이상순", "애월읍");
			if(dao.findMemberById(vo.getId()) != null) {
				System.out.println("아이디가 존재하여 등록 불가!");
			}
			else {
				dao.registerMember(vo);
				System.out.println("등록완료");
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
