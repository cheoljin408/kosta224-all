package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.GuestBookDAO;
import model.GuestBookDTO;

public class TestGuestBookDAO4 {
	public static void main(String[] args) {
		// like 연산자를 이용해서 방명록 글제목(title)을 이용해 정보를 조회하는 기능을 구현
		try {
			GuestBookDAO dao = new GuestBookDAO();
			String keyword = "불";
			// keyword = "월";
			ArrayList<GuestBookDTO> list = dao.getGuestBookListLikeKeyword(keyword);
			/*
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
			*/
			for(GuestBookDTO dto: list) {
				System.out.println(dto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
