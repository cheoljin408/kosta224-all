package test;

/*
 	Nested Class ��øŬ����
 	class ���ο� class�� ����
 	private member�� �ٸ� ũ�������� ������ �� ������ nested class(inner class)������ ���� ����
 	�ݵ�� Outer class�� ��ü ������ ���ؼ� Inner class�� ��ü ������ ����
 */
public class TestNestedClass {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.test();
		outer.writeTest();
		System.out.println("****");
		ClientOuter co = new ClientOuter();
	}
}
