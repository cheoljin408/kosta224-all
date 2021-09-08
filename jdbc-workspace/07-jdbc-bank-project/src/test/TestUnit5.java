package test;

import java.sql.SQLException;

import model.AccountDAO;
import model.AccountNotFoundException;
import model.InsufficientBalanceException;
import model.NoMoneyException;
import model.NotMatchedPasswordException;

// step5 출금 테스트
public class TestUnit5 {
	public static void main(String[] args) {
		try {
			AccountDAO dao = new AccountDAO();
			
			String accountNo = "1"; // 출금 계좌
			String password = "1234"; // 계좌 패스워드
			int money = 1; // 출금액
			System.out.println("출금 전 계좌잔액:" + dao.findBalanceByAccountNo(accountNo, password));
			dao.withdraw(accountNo, password, money);
			System.out.println("출금 후 계좌잔액:" + dao.findBalanceByAccountNo(accountNo, password));
			
		} catch (NoMoneyException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NotMatchedPasswordException e) {
			System.out.println(e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
}
