package step8.solution;

import step5.Employee;
import step5.Engineer;
import step5.Manager;

public class TestPolymorphismEx {
	public static void main(String[] args) {
		//CompanyService 는 자신의 instance variable을 
		//10개의 length를 가진 배열로 선언하고 생성자에서 초기화한다  
		CompanyService service
		=new CompanyService(10);
		service.add(new Manager("12","아이유",500,"연구개발"));
		service.add(new Engineer("23","박보검",700,"java"));
		service.add(new Employee("35","강하늘",300));
		service.printAll();
		/*
		 	empNo:12 name:아이유 salary:500 department:연구개발 
		 	empNo:23 name:박보검 salary:700 skill:java
		 	empNo:35 name:강하늘 salary:300 
		 */
		//개발순서 : Employee , Manager, Engineer , CompanyService
		System.out.println("********add 완료***********");
		/*
		String empNo="23";
		Employee emp=service.findEmployeeByEmpNo(empNo);
		System.out.println(emp);
		//empNo:23 name:박보검 salary:700 skill:java
		empNo="35";
		Employee emp2=service.findEmployeeByEmpNo(empNo);
		System.out.println(emp2);
		//empNo:35 name:강하늘 salary:300
		empNo="99";
		Employee emp3=service.findEmployeeByEmpNo(empNo);
		System.out.println(emp3);
		//null 
		System.out.println("********find 완료***********");
		*/
	}
}













