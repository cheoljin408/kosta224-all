package practice.test.step1;

import practice.model.Employee;
import practice.model.SchoolService;
import practice.model.Student;
import practice.model.Teacher;

public class TestCaseAdd {
	public static void main(String[] args) {
		SchoolService service = new SchoolService();
		
		service.addMember(new Student("0101231234", "������", "����", "17"));
		service.addMember(new Teacher("0101231235", "�ǿ���", "����", "����"));
		service.addMember(new Student("0101231236", "��ٿ�", "����", "16"));
		service.addMember(new Employee("0101231237", "��ٿ�", "ȭ��", "�繫��"));
		service.addMember(new Student("0101231238", "�����", "����", "18"));
		service.addMember(new Teacher("0101231239", "�躴��", "����", "����"));
		
		service.printAll(); // 6���� ������ ���
		
		// �Ʒ��� �ߺ� �׽�Ʈ
		// 0101231234 tel �� �ߺ��Ǿ� �߰��� �� �����ϴ�
		service.addMember(new Student("0101231234", "������", "���", "18"));
		
		System.out.println("***�б� ������ ��� �Ϸ�***");
		
		service.printAll();// 6�� ���

	}
}



