package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
	public AccountDAO() throws ClassNotFoundException {
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
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DbInfo.URL, DbInfo.USERNAME, DbInfo.PASSWORD);
	}

	public void createAccount(AccountVO vo) throws CreateAccountException, SQLException {
		// exception throw
		if(vo.getBalance() < 1000)
		{
			throw new CreateAccountException("계좌 개설시 초기 납입금은 1000원 이상이어야 합니다");
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into account(account_no, name, password, balance) values(account_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setInt(3, vo.getBalance());
			
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * 계좌의 잔액을 조회하는 메소드
	 * 계좌번호에 해당하는 계좌가 없으면 AccountNotFoundException을 발생시키고 전파한다
	 * 패스워드가 일치하지 않으면 NotMatchedPasswordException을 발생시키고 전파한다
	 * 계좌번호에 해당하는 계좌가 존재하고 비밀번호가 일치하면 잔액을 반환한다
	 * @param accountNo
	 * @param password
	 * @return balance
	 * @throws SQLException
	 * @throws AccountNotFoundException
	 * @throws NotMatchedPasswordException
	 */
	public int findBalanceByAccountNo(String accountNo, String password) throws SQLException, AccountNotFoundException, NotMatchedPasswordException {
		int balance = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder("select * from account ");
			sql.append("where account_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, accountNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(3).equals(password)) {
					balance = rs.getInt(4);
				}
				else {
					throw new NotMatchedPasswordException("잘못된 비밀번호를 입력하셨습니다");  
				}
			}
			else {
				throw new AccountNotFoundException(accountNo + "계좌번호에 해당하는 계좌가 존재하지 않습니다");
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return balance;
	}
	
	/**
	 * 계좌번호 유무와 계좌번호에 따른 비밀번호 일치여부를 확인하는 메소드
	 * 매개변수에 전달된 계좌번호가 존재하지 않으면 AccountNotFoundException을 발생시키고 전파
	 * 매개변수에 전달된 계좌번호에 대한 비밀번호가 일치하지 않으면 NotMatchedPasswordException을 발생시키고 전파
	 * @param accountNo
	 * @param password
	 * @throws SQLException
	 * @throws AccountNotFoundException
	 * @throws NotMatchedPasswordException
	 */
	public void checkAccountNoAndPassword(String accountNo, String password) throws SQLException, AccountNotFoundException, NotMatchedPasswordException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select password from account where account_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(password) == false) {
					throw new NotMatchedPasswordException("잘못된 비밀번호를 입력하셨습니다");
				}
			}
			else {
				throw new AccountNotFoundException(accountNo + "계좌번호에 해당하는 계좌가 존재하지 않습니다");
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	/**
	 * 계좌에 입금하는 메소드
	 * 입금액이 0원 이하이면 NoMoneyException을 발생시키고 전파
	 * 계좌번호가 존재하지 않으면 AccountNotFoundException을 발생시키고 전파
	 * 패스워드가 일치하지 않으면 NotMatchedPasswordException을 발생시키고 전파
	 * 입금액이 0원을 초과하고 계좌번호가 존재하고 패스워드가 일치하면 입금처리
	 * @param accountNo
	 * @param password
	 * @param money
	 * @throws SQLException 
	 * @throws NotMatchedPasswordException 
	 * @throws AccountNotFoundException 
	 */
	public void deposit(String accountNo, String password, int money) throws NoMoneyException, SQLException, NotMatchedPasswordException, AccountNotFoundException {
		if(money <= 0) {
			throw new NoMoneyException("입금액은 0원을 초과해야 합니다");
		}
		
		checkAccountNoAndPassword(accountNo, password);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update account set balance = balance+? where account_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, accountNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * 계좌 출금 처리를 하는 메소드
	 * 
	 * 출금액이 0원 이하이면 NoMoneyException을 발생시키고 전파
	 * 
	 * 아래 두 예외는 findBalanceByAccountNo()를 호출하면 처리된다
	 * 존재하지 않는 계좌번호이면 AccountNotFoundException을 발생시키고 전파
	 * 계좌 비밀번호가 일치하지 않으면 NotMatchedPasswordException 발생, 전파
	 * 
	 * findBalanceByAccountNo()를 호출해서 받환받은 balance 정보를 이용해서
	 * 잔액 충분 여부를 판단하면 된다
	 * 출금액보다 잔액이 작으면 InsufficientBalanceException 발생, 전파
	 * 
	 * 출금처리: 기존 잔액에서 출금액을 마이너스하는 update sql을 실행한다
	 * @param accountNo
	 * @param password
	 * @param money
	 * @throws NoMoneyException
	 * @throws SQLException
	 * @throws AccountNotFoundException
	 * @throws NotMatchedPasswordException
	 * @throws InsufficientBalanceException
	 */
	public void withdraw(String accountNo, String password, int money) throws NoMoneyException, SQLException, AccountNotFoundException, NotMatchedPasswordException, InsufficientBalanceException {
		int balance = findBalanceByAccountNo(accountNo, password);
		if(money <= 0) {
			throw new NoMoneyException("출금액은 0원을 초과해야 합니다");
		}
		if(balance < money) {
			throw new InsufficientBalanceException("계좌 잔액보다 많은 액수는 출금할 수 없습니다");
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update account set balance = balance-? where account_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, accountNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * 계좌번호가 존재하는 지 유무를 판단해서 계좌번호에 따른 계좌가 존재하면 true, 없으면 false를 반환하는 메소드
	 * @param accountNo
	 * @return
	 * @throws SQLException
	 */
	public boolean existsAccountNo(String accountNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select count(*) from account where account_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next() && rs.getInt(1) == 1) {
				return true;
			}
			else {
				return false;
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public void transfer(String senderAccountNo, String password, int money, String receiverAccountNo) {
		
	}
	
	
}
