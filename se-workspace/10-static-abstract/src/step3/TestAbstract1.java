package step3;

// abstract class �� abstract method test
// abstract class�� ���� ��üȭ �� �� ����
abstract class Animal {
	Animal() {
		System.out.println("Animal ��ü ����");
	}
	
	// abstract method�� �����ΰ� �������� �ʰ� ���� �Ѵ�
	// �ڽ�(����) Ŭ�������� ������ �����Ѵ�
	public abstract void eat();
}

// Animal�� ��ӹ����� Animal�� abstract method�� �����ϰų� �ƴϸ� �ڽŵ� abstract�� ����Ǿ�� �Ѵ�
class Person extends Animal {
	Person() {
		System.out.println("Person ��ü ����");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("����� �Դ�");
	}
}

public class TestAbstract1 {
	public static void main(String[] args) {
		// abstract class�� ����ȭ �� �� ����(�� ��ü ���� �� �� ����)
		// Animal a = new Animal();
		
		// �ڽ� ��ü ������ super()�� �̿��ؼ� ��ü ������ �ȴ� -> abstract class�� �θ� Ŭ�����μ��� ���ҿ� ����
		Animal a = new Person();
		a.eat();
		
	}
}
