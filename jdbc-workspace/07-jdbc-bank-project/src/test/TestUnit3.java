package test;

import java.sql.SQLException;

import model.AccountDAO;
import model.AccountNotFoundException;
import model.NoMoneyException;
import model.NotMatchedPasswordException;

public class TestUnit3 {
	public static void main(String[] args) {
		try {
			AccountDAO dao = new AccountDAO();
			// 대안흐름 테스트
			String accountNo = "1"; // 존재하지 않는 계좌번호
			String password = "1234"; // 패스워드 테스트
			int money = 1; // 입금액 테스트
			System.out.println("입금 전 잔액:" + dao.findBalanceByAccountNo(accountNo, password));
			dao.deposit(accountNo, password, money);
			System.out.println("입금 완료");
			System.out.println("입금 후 잔액:" + dao.findBalanceByAccountNo(accountNo, password));
		} catch(NoMoneyException e) {
			System.out.println(e.getMessage());
		} catch(AccountNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(NotMatchedPasswordException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
