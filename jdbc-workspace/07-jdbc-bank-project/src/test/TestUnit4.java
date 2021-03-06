package test;

import java.sql.SQLException;

import model.AccountDAO;
import model.AccountNotFoundException;
import model.NotMatchedPasswordException;

// 계좌번호 존재 유무와 비밀번호 일치 여부를 확인하는 메소드
public class TestUnit4 {
	public static void main(String[] args) {
		try {
			AccountDAO dao = new AccountDAO();
			String accountNo = "1";
			String password = "1234";
			dao.checkAccountNoAndPassword(accountNo, password);
			System.out.println("계좌번호가 존재하고 비밀번호가 일치합니다");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(AccountNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(NotMatchedPasswordException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
