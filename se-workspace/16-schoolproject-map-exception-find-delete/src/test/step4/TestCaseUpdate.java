package test.step4;

import model.DuplicateTelException;
import model.Employee;
import model.MemberNotFoundException;
import model.SchoolService;
import model.Student;
import model.Teacher;

public class TestCaseUpdate {
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
		service.printAll(); // 두 명의 상세정보(toString())가 출력되어야 한다
		System.out.println("********등록 완료********");
		
		// 수정 정상흐름 테스트
		try {
			// 업데이트 할 객체
			Employee e = new Employee("011", "송흥민", "런던", "연구개발");
			service.updateMember(e);
			System.out.println("수정완료");
		} catch(MemberNotFoundException me) {
			System.out.println(me.getMessage());
		}
		
		// 수정 예외흐름 테스트
		try {
			// 업데이트 할 객체
			Teacher t = new Teacher("018", "이강인", "런던", "수학");
			service.updateMember(t);
			System.out.println("수정완료");
		} catch(MemberNotFoundException me) {
			System.out.println(me.getMessage()); // 018 tel에 해당하는 구성원이 존재하지 않아 수정 불가!
		}
		service.printAll();	
	}
}
