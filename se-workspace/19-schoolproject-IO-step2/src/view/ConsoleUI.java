package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.DuplicateTelException;
import model.Employee;
import model.Member;
import model.MemberNotFoundException;
import model.SchoolService;
import model.Student;
import model.Teacher;

// Ǯ�̺� ���� ConsoleInstUI1
public class ConsoleUI {
	private SchoolService service = new SchoolService();
	private Scanner scanner = new Scanner(System.in);
	
	public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
		service.loadData();
		
		System.out.println("*******�л�������α׷��� �����մϴ�******");
		String option;
		exit:
		while(true) {
			System.out.println("1. �߰� 2. ���� 3. �˻� 4. ��üȸ������ 5.����");
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
				System.out.println("**��ü����������**");
				service.printAll();
				break;
			case "5":
				service.saveData();
				System.out.println("*******�л�������α׷��� �����մϴ�******");
				break exit;
			default :
				System.out.println("�߸��� �Է°��Դϴ�!");
			}
		}
		scanner.close();
	}

	public void addView() {
		// 1�� �߰� ��������
		String menu = null;
		while(true) {
			System.out.println("�Է��� �������� ������ �����ϼ��� 1.�л�  2.������ 3.����");
			menu = scanner.nextLine();
			if(menu.equals("1") || menu.equals("2") || menu.equals("3")) {
				break;
			}
			else {
				System.out.println("1. �л�, 2. ������, 3. ���� �� �ϳ��� �޴��� �����ϼ���!");
			}
		}
		
		String tel = null;
		while(true) {
			System.out.println("1. ��ȭ��ȣ�� �Է��ϼ���!");
			tel = scanner.nextLine();
			// SchoolService�� findMemberByTel(tel)�� �̿��غ���
			try {
				service.findMemberByTel(tel);
				System.out.println("�Է��Ͻ� " + tel + " tel ��ȣ�� �ߺ��˴ϴ�. �ٽ� �Է��ϼ���!");
			} catch (MemberNotFoundException e) {
				break;
			}
		}
		
		System.out.println("2. �̸��� �Է��ϼ���!");
		String name = scanner.nextLine();
		
		System.out.println("3. �ּҸ� �Է��ϼ���!");
		String address = scanner.nextLine();
		
		Member member = null;
		
		switch(menu) {
		case "1":
			System.out.println("4. �й��� �Է��ϼ���!");
			String stuId = scanner.nextLine();
			
			member = new Student(tel, name, address, stuId);
			break;
		case "2":
			System.out.println("4. ������ �Է��ϼ���!");
			String subject = scanner.nextLine();
			
			member = new Teacher(tel, name, address, subject);
			break;
		case "3":
			System.out.println("4. �μ��� �Է��ϼ���!");
			String department = scanner.nextLine();
			
			member = new Employee(tel, name, address, department);
			break;
		default :
			System.out.println("�߸��� �Է°��Դϴ�!");
		}
		
		try {
			service.addMember(member); 
			System.out.println("����Ʈ�� �߰�:" + member);
		} catch(DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void findView() {
		System.out.println("��ȸ�� �������� ��ȭ��ȣ�� �Է��ϼ���");
		String tel = scanner.nextLine();
		
		try {
			System.out.println("��ȸ���:" + service.findMemberByTel(tel));
		} catch (MemberNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteView() {
		System.out.println("������ �������� ��ȭ��ȣ�� �Է��ϼ���");
		String tel = scanner.nextLine();
		
		try {
			service.deleteMemberByTel(tel);
			System.out.println(tel + "�� �ش��ϴ� �������� �����Ͽ����ϴ�");
		} catch (MemberNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
