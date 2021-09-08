package test;

import java.sql.SQLException;

import model.AccountDAO;

// step7 계좌이체 테스트
public class TestUnit7 {
	public static void main(String[] args) {
		try {
			AccountDAO dao = new AccountDAO();
			String senderAccountNo = "1";
			String password = "1234";
			int money = 100;
			String receiverAccountNo = "2";
			dao.transfer(senderAccountNo, password, money, receiverAccountNo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		//} catch (SQLException e) {
			//e.printStackTrace();
		}
		
	}
}
