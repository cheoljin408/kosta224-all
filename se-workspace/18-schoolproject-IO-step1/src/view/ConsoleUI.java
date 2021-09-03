package view;

import java.util.Scanner;

import model.DuplicateTelException;
import model.Employee;
import model.Member;
import model.MemberNotFoundException;
import model.SchoolService;
import model.Student;
import model.Teacher;

// 풀이본 공유 ConsoleInstUI1
public class ConsoleUI {
	private SchoolService service = new SchoolService();
	private Scanner scanner = new Scanner(System.in);
	
	public void execute() {
		String option;
		
		System.out.println("*******학사관리프로그램을 시작합니다******");
		
		exit:
		while(true) {
			System.out.println("1. 추가 2. 삭제 3. 검색 4. 전체회원보기 5.종료");
			option = scanner.nextLine();
			
			switch(option) {
			case "1":
				addView();
				break;
			case "2":
				deleteView();
				break;
			case "3":
				findView();
				break;
			case "4":
				System.out.println("**전체구성원보기**");
				service.printAll();
				break;
			case "5":
				System.out.println("*******학사관리프로그램을 종료합니다******");
				break exit;
			default :
				System.out.println("잘못된 입력값입니다!");
			}
		}
		scanner.close();
	}

	public void addView() {
		System.out.println("입력할 구성원의 종류를 선택하세요 1.학생  2.선생님 3.직원");
		String menu = scanner.nextLine();
		
		System.out.println("1. 전화번호를 입력하세요!");
		String tel = scanner.nextLine();
		
		System.out.println("2. 이름을 입력하세요!");
		String name = scanner.nextLine();
		
		System.out.println("3. 주소를 입력하세요!");
		String address = scanner.nextLine();
		
		Member member = null;
		
		switch(menu) {
		case "1":
			System.out.println("4. 학번을 입력하세요!");
			String stuId = scanner.nextLine();
			
			member = new Student(tel, name, address, stuId);
			break;
		case "2":
			System.out.println("4. 과목을 입력하세요!");
			String subject = scanner.nextLine();
			
			member = new Teacher(tel, name, address, subject);
			break;
		case "3":
			System.out.println("4. 부서를 입력하세요!");
			String department = scanner.nextLine();
			
			member = new Employee(tel, name, address, department);
			break;
		default :
			System.out.println("잘못된 입력값입니다!");
		}
		
		try {
			service.addMember(member); 
			System.out.println("리스트에 추가:" + member);
		} catch(DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void findView() {
		System.out.println("조회할 구성원의 전화번호를 입력하세요");
		String tel = scanner.nextLine();
		
		try {
			System.out.println("조회결과:" + service.findMemberByTel(tel));
		} catch (MemberNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteView() {
		System.out.println("삭제할 구성원의 전화번호를 입력하세요");
		String tel = scanner.nextLine();
		
		try {
			service.deleteMemberByTel(tel);
			System.out.println(tel + "에 해당하는 구성원을 삭제하였습니다");
		} catch (MemberNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
