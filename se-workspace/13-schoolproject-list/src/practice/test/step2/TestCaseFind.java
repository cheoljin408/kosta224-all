package practice.test.step2;

import practice.model.Employee;
import practice.model.SchoolService;
import practice.model.Student;
import practice.model.Teacher;

public class TestCaseFind {
	public static void main(String[] args) {
		SchoolService service = new SchoolService();
		service.addMember(new Student("0101231234", "������", "����", "17"));
		service.addMember(new Teacher("0101231235", "�ǿ���", "����", "����"));
		service.addMember(new Student("0101231236", "��ٿ�", "����", "16"));
		service.addMember(new Employee("0101231237", "��ٿ�", "ȭ��", "�繫��"));
		service.addMember(new Student("0101231238", "�����", "����", "18"));
		service.addMember(new Teacher("0101231239", "�躴��", "����", "����"));
		service.printAll();//6���� ������ ��� 
		System.out.println("***�б� ������ ��� �Ϸ�***");
		String tel="0101231230";//�������� �ʴ� ��ȣ�� �׽�Ʈ 
		System.out.println(service.findMemberByTel(tel));//null
		tel="0101231237";//�����ϴ� ��ȣ�� �׽�Ʈ 
		System.out.println(service.findMemberByTel(tel));// tel:0101231237 name:��ٿ� address:ȭ�� department:�繫��
	}
}



