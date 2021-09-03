package test.step2;

import model.DuplicateTelException;
import model.Member;
import model.MemberNotFoundException;
import model.SchoolService;
import model.Student;
import model.Teacher;

public class TestCaseFind {
	public static void main(String[] args) {
		SchoolService service = new SchoolService();
		
		try {
			service.addMember(new Student("011", "아이유", "종로", "21"));
			System.out.println("등록 ok");
		} catch(DuplicateTelException de) { // 기존 tel이 존재하면
			System.out.println(de.getMessage()); // 011 tel 중복되어 등록불가합니다
		}
		
		try {
			service.addMember(new Teacher("016", "RM", "강남", "수학"));
			System.out.println("등록 ok");
		} catch(DuplicateTelException de) { // 기존 tel이 존재하면
			System.out.println(de.getMessage()); // 016 tel 중복되어 등록불가합니다
		}
		
		try {
			service.addMember(new Teacher("011", "장기하", "제주", "영어")); // -> 중복된다
			System.out.println("등록 ok");
		} catch(DuplicateTelException de) { // 기존 tel이 존재하면
			System.out.println(de.getMessage()); // 011 tel 중복되어 등록불가합니다
		}
		
		service.printAll(); // 두 명의 상세정보(toString())가 출력되어야 한다
		System.out.println("**구성원 등록 테스트 완료**");
		
		try {
			String tel = "016"; // 정상 흐름
			// tel = "018"; // 예외 흐름
			Member m = service.findMemberByTel(tel);
			System.out.println("검색ok: " + m); // tel이 존재하면 검색 ok
		} catch(MemberNotFoundException me) {
			System.out.println(me.getMessage()); // 018 tel에 해당하는 구성원 정보가 없습니다!
		}
	}
}
