package test.step1;

import model.Employee;
import model.SchoolService;
import model.SchoolServiceImplVer2;
import model.Student;
import model.Teacher;

public class TestCaseAdd {
	public static void main(String[] args) {
		// SchoolService service = new SchoolServiceImpl();
		// 리팩토링 대상 SchoolServiceImplVer2를 테스트
		SchoolService service = new SchoolServiceImplVer2();
		
		service.addMember(new Student("0101231234", "곽승진", "용인", "17"));
		service.addMember(new Teacher("0101231235", "권용은", "수지", "국어"));
		service.addMember(new Student("0101231236", "김근영", "수원", "16"));
		service.addMember(new Employee("0101231237", "김근원", "화성", "재무부"));
		service.addMember(new Student("0101231238", "김민주", "용인", "18"));
		service.addMember(new Teacher("0101231239", "김병준", "용인", "수학"));
		
		service.printAll(); // 6명의 정보가 출력
		
		// 아래는 중복 테스트
		// 0101231234 tel 이 중복되어 추가될 수 없습니다
		service.addMember(new Student("0101231234", "아이유", "잠실", "18"));
		
		System.out.println("***학교 구성원 등록 완료***");
		
		service.printAll();// 6명 출력

	}
}



