package step1;

public class Person extends Animal {
	@Override // @: ������̼�(�ǹ��ִ� �ּ�, �����ϰ� ��Ÿ�ӿ� ������ �ش�)
	// @Override: �޼ҵ� �������̵� �� ������ ������ �������̵� ������ üũ
	public void eat() { // �޼ҵ� �������̵��� �θ� �޼ҵ带 �ڽſ� �°� ������ ���ش�
		System.out.println("����� ������ �Դ�");
	}
}
