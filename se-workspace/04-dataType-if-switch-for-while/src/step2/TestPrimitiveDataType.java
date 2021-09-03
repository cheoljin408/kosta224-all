package step2;
/*
 �ڹ��� ������ Ÿ�Կ��� �⺻�� ������ Ÿ��(primitive data type)�� ������ ������ Ÿ��(reference data type)�� �ִ�.
1) primitive data type
			1byte	2byte	4byte	8byte
	������	byte	short	int		long	�������� �⺻���� int��
	�Ǽ���					float	double	�Ǽ����� �⺻���� double��
	������			char					�������� ���� �� ���ڸ� ����, ���ڿ��� �������� String�� ���
	����	boolean							������ true or false�� ����
 */
public class TestPrimitiveDataType {
	public static void main(String[] args) {
		// 1. ������
		byte b = 1;
		b = 2;
		System.out.println("byte: " + b);
		
		// java se api�� �̿��� byte Ÿ���� �ִ밪, �ּҰ��� Ȯ���غ���.
		System.out.println("byte�� �ִ밪: " + Byte.MAX_VALUE);
		System.out.println("byte�� �ּҰ�: " + Byte.MIN_VALUE);

		// b = 129; // error: byte �ִ밪�� �����Ƿ�
		
		// 2byte
		short s = 3;
		System.out.println("short: " + s);
		
		// 4byte
		int i = 1;
		System.out.println("int: " + i);
		
		// 8byte, long�� �����Ϳ��� �빮��or�ҹ��� l�� ���δ�. �Ⱥ��̸� int������ �ν�
		long l = 3L;
		System.out.println("long: " + l);
		
		// 2. �Ǽ���
		// 4byte, float�� �����Ϳ��� �빮��or�ҹ��� f�� ���δ�. �Ⱥ��̸� double������ �ν�
		float f = 3.14F;
		System.out.println("float: " + f);
		// 8byte, �Ǽ����� �⺻���� double
		double d = 3.14;
		System.out.println("double: " + d);
		
		// 3. ������(�� ���ڸ� ����, ���ڿ��� ������ String���� ����)
		char c = 'a';
		System.out.println("char: " + c);
		
		// 4. ����(true or false�� ����)
		boolean bo = true;
		bo = false;
		System.out.println("bolean: " + bo);
		
		// type casting ���
		byte b1 = 1;
		byte b2 = 6;
		// �Ʒ� �ڵ�� compile error
		// byte b3 = b1 + b2;// ������ 7�� �������� �⺻���� int�� �ν�
		
		// ���1
		// int in = b1 + b2;
		// ���2
		byte b3 = (byte)(b1 + b2); // �� ������ ���� ����� byte������ �νĽ�Ų�� -> type casting
		System.out.println("������: " + b3);
	}
}
