package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.GuestBookDAO;
import model.GuestBookDTO;

public class TestGuestBookDAO1 {
	public static void main(String[] args) {
		// guestbook에 insert(guestbook_no는 자동 발행)
		try {
			GuestBookDAO dao = new GuestBookDAO();
			GuestBookDTO dto = new GuestBookDTO("불금", "잘먹고 잘놀자");
			dao.register(dto);
			System.out.println("방명록에 글등록");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
// register method sql
// insert into guestbook(guestbook_no, title, content)
// values(guestbook_seq.nextval, ?, ?)
