package test.step0;

import model.Employee;
import model.SchoolService;
import model.SchoolServiceImplVer2;
import model.Student;
import model.Teacher;

public class TestCaseFindIndex {
	public static void main(String[] args) {
		// 리팩토링 대상 SchoolServiceImplVer2를 테스트
		SchoolService service = new SchoolServiceImplVer2();
		
		service.addMember(new Student("0101231234", "곽승진", "용인", "17"));
		service.addMember(new Teacher("0101231235", "권용은", "수지", "국어"));
		service.addMember(new Student("0101231236", "김근영", "수원", "16"));
		service.addMember(new Employee("0101231237", "김근원", "화성", "재무부"));
		service.addMember(new Student("0101231238", "김민주", "용인", "18"));
		service.addMember(new Teacher("0101231239", "김병준", "용인", "수학"));
		
		System.out.println("**findIndexByTel test 시작**");
		int index = service.findIndexByTel("7777"); // 존재하지 않는 tel로 테스트
		System.out.println("index:" + index); // -1
		index = service.findIndexByTel("0101231236"); // 존재하는 tel로 테스트
		System.out.println("index:" + index); // 2
		System.out.println("**findIndexByTel test 종료**");

	}
}
