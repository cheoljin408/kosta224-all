package test.step2;

import model.Employee;
import model.SchoolService;
import model.SchoolServiceImplVer2;
import model.Student;
import model.Teacher;

public class TestCaseFind {
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
		service.printAll();//6명의 정보가 출력 
		System.out.println("***학교 구성원 등록 완료***");
		String tel="0101231230";//존재하지 않는 번호로 테스트 
		System.out.println(service.findMemberByTel(tel));//null
		tel="0101231237";//존재하는 번호로 테스트 
		System.out.println(service.findMemberByTel(tel));// tel:0101231237 name:김근원 address:화성 department:재무부
	}
}



