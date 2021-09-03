package step3;

import java.io.IOException;

public class TestObjectSerialization2 {
	public static void main(String[] args) {
		String path = "C:\\kosta224\\iotest\\account.obj";
		AccountService service = new AccountService(path);
		
		// 내 풀이
		/*
		 * try { service.saveObject(avo); System.out.println("계좌정보 직렬화하여 파일에 저장"); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		
		// 강사님 풀이
		try {
			AccountVO avo = service.loadObject();
			System.out.println(avo.getName()); // 아이유
			System.out.println(avo.getBalance()); // 200
			System.out.println(avo.getPassword()); // null --> transient 이므로
			System.out.println("계좌정보를 역직렬화하여 메모리에서 확인");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
