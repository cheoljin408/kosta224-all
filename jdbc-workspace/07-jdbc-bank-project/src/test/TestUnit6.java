package test;

import java.sql.SQLException;

import model.AccountDAO;

// step6 계좌번호 존재 유무를 확인하는 메소드 테스트
public class TestUnit6 {
	public static void main(String[] args) {
		try {
			AccountDAO dao = new AccountDAO();
			String accountNo = "1";
			accountNo = "11";
			boolean result = dao.existsAccountNo(accountNo);
			if(result) {
				System.out.println(accountNo + " 계좌가 존재합니다");
			}
			else {
				System.out.println(accountNo + " 계좌가 존재하지 않습니다");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
