package step2;

public interface Flyer {
	String ID = "javaking"; // public static final ����� �ڵ� �ν�
	// compile error, �������̽��� ������ �޼ҵ带 ���� �� ����
	// public void test() {}
	public void fly(); // abstract�� ������� �ʾƵ� abstract method�� �ڵ� �ν�
}
