package step7;

class Person {
	String name = "����̸�";
}

class Student extends Person {
	String name = "�л��̸�"; // �θ��� �ν��Ͻ� ������� ����
	
	public void test() {
		System.out.println(name); // �ڽ��� �ν��Ͻ� ������ ���
		System.out.println(super.name); // super keyword�� �η��� �ν��Ͻ� ������ ������ ���
	}
}

public class TestSuper1 {
	public static void main(String[] args) {
		Student s = new Student();
		s.test();
	}
}
