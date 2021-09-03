package step3;

class Animal {
	public void eat() {
		System.out.println("�Դ�");
	}
}

class Person extends Animal {
	// �޼ҵ� �����Ƹ���: �θ� �޼ҵ带 �ڽſ� �°� ������
	public void eat() {
		System.out.println("����� ������ ����ϴ�");
		super.eat(); // super keyword
	}
}

class Dog extends Animal {
	// �޼ҵ� �������̵�
	public void eat() {
		System.out.println("�������� ���ٴ��� ����ϴ�");
		super.eat();
	}
}

public class TestOverriding1 {
	public static void main(String[] args) {
		Person p = new Person();
		p.eat(); // �������̵� �� �ڽ��� �޼ҵ尡 ����
		
		Dog d = new Dog();
		d.eat(); // �������̵��� �޼ҵ尡 ����
	}
}
