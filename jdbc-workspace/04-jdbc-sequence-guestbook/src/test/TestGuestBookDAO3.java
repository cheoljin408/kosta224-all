package test;

import java.sql.SQLException;

import model.GuestBookDAO;
import model.GuestBookDTO;

public class TestGuestBookDAO3 {
	public static void main(String[] args) {
		// guestbook에 insert(guestbook_no는 자동 발행)
		// TestGuestBookDAO1 의 방명록 글등록 기능을 업데이트
		// 글등록을 하고 나면 db에서 발급한 글번호가 GuestBookDTO에 할당이 되어있도록
		// regisgerVer2 메소드를 구현해본다 (sequence의 nextval과 함께 currval을 사용한다)
		try {
			GuestBookDAO dao = new GuestBookDAO();
			GuestBookDTO dto = new GuestBookDTO("불금ver2", "잘먹고 잘놀자ver2");
			System.out.println("글 등록 이전 dto:" + dto);
			dao.registerVer2(dto);
			System.out.println("방명록에 글등록");
			// 여전히 guestbookNo는 0이고, 글등록 후에는 db에서 발급한 sequence 즉 방명록 글번호를 확인하고자 할때는
			// TestGuestBookDAO3의 시퀀스 .currval을 이용하면 된다
			System.out.println("글 등록 이후 dta:" + dto);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
